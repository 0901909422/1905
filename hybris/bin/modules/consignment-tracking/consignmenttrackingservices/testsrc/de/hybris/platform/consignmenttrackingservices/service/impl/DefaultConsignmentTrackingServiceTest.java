/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.consignmenttrackingservices.service.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.acceleratorservices.urlresolver.SiteBaseUrlResolutionService;
import de.hybris.platform.basecommerce.enums.ConsignmentStatus;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.consignmenttrackingservices.adaptors.CarrierAdaptor;
import de.hybris.platform.consignmenttrackingservices.daos.ConsignmentDao;
import de.hybris.platform.consignmenttrackingservices.delivery.data.ConsignmentEventData;
import de.hybris.platform.consignmenttrackingservices.model.CarrierModel;
import de.hybris.platform.ordersplitting.model.ConsignmentModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.site.BaseSiteService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.configuration.BaseConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;



@UnitTest
public class DefaultConsignmentTrackingServiceTest
{
	private DefaultConsignmentTrackingService consignmentTrackingService;

	private ConsignmentModel consignment;

	@Mock
	private CarrierAdaptor carrierAdaptor;

	private Map<String, CarrierAdaptor> carrierAdaptors;

	private String trackingId;

	@Mock
	private ConfigurationService configurationService;

	@Mock
	private ConsignmentDao consignmentDao;

	@Mock
	private ModelService modelService;

	@Mock
	private SiteBaseUrlResolutionService siteBaseUrlResolutionService;

	@Mock
	private BaseSiteService baseSiteService;

	private String orderCode;

	private String consignmentCode;

	private List<ConsignmentModel> modelList;

	@Mock
	private BaseConfiguration baseConfiguration;

	@Before
	public void prepare()
	{
		MockitoAnnotations.initMocks(this);

		orderCode = "20160818174512";
		consignmentCode = "a20160818174512";

		trackingId = "160818174512002";

		final String carrierCode = "MockCarrier";

		carrierAdaptors = new HashMap<>();
		carrierAdaptors.put(carrierCode, carrierAdaptor);

		final CarrierModel carrier = new CarrierModel();
		carrier.setCode(carrierCode);

		consignment = new ConsignmentModel();
		consignment.setTrackingID(trackingId);
		consignment.setCode(consignmentCode);
		consignment.setStatus(ConsignmentStatus.READY);
		consignment.setCarrierDetails(carrier);

		consignmentTrackingService = new DefaultConsignmentTrackingService();
		consignmentTrackingService.setCarrierAdaptors(carrierAdaptors);
		consignmentTrackingService.setConfigurationService(configurationService);
		consignmentTrackingService.setConsignmentDao(consignmentDao);
		consignmentTrackingService.setModelService(modelService);
		consignmentTrackingService.setSiteBaseUrlResolutionService(siteBaseUrlResolutionService);
		consignmentTrackingService.setBaseSiteService(baseSiteService);
		modelList = new ArrayList<>(0);
		modelList.add(consignment);
	}

	@Test
	public void testGetTrackingUrlForConsignment() throws MalformedURLException
	{
		final URL defaultURL = new URL("http://127.0.0.1");
		Mockito.when(carrierAdaptor.getTrackingUrl(trackingId)).thenReturn(defaultURL);
		final URL url = consignmentTrackingService.getTrackingUrlForConsignment(consignment);
		Assert.assertEquals(defaultURL, url);
	}

	@Test
	public void testIsTrackingIdValid()
	{
		Mockito.when(Boolean.valueOf(carrierAdaptor.isTrackingIdValid(trackingId))).thenReturn(Boolean.TRUE);
		final boolean result = consignmentTrackingService.isTrackingIdValid(consignment);
		Assert.assertTrue(result);
	}

	@Test
	public void testGetConsignmentEvents()
	{
		final List<ConsignmentEventData> events = Mockito.mock(List.class);
		Mockito.when(carrierAdaptor.getConsignmentEvents(trackingId)).thenReturn(events);
		final List<ConsignmentEventData> result = consignmentTrackingService.getConsignmentEvents(consignment);
		Assert.assertEquals(events, result);
		

	}

	@Test
	public void testGetConsignmentEvents_TackingidIsNone()
	{

		consignment.setTrackingID(null);
		final List<ConsignmentEventData> res = consignmentTrackingService.getConsignmentEvents(consignment);
		Assert.assertEquals(Collections.emptyList(), res);

	}

	@Test
	public void testGetCarrierAdaptor_CarrierDetailIsNone()
	{
		consignment.setCarrierDetails(null);

		Optional op = consignmentTrackingService.getCarrierAdaptor(consignment);
		Assert.assertFalse(op.isPresent());

	}

	@Test
	public void testGetConsignmentForCode()
	{
		Mockito.when(consignmentDao.findConsignmentByCode(orderCode, consignmentCode)).thenReturn(Optional.of(consignment));
		final Optional<ConsignmentModel> result = consignmentTrackingService.getConsignmentForCode(orderCode, consignmentCode);
		Assert.assertEquals(consignment, result.get());
	}

	@Test
	public void testGetConsignmentForOrder()
	{
		Mockito.when(consignmentDao.findConsignmentsByOrder(orderCode)).thenReturn(modelList);
		final List<ConsignmentModel> result = consignmentTrackingService.getConsignmentsForOrder(orderCode);
		Assert.assertEquals(consignment, result.get(0));
	}

	@Test
	public void testGetDeliveryLeadTime()
	{
		final int defaultLeadTime = 1;
		Mockito.when(Integer.valueOf(carrierAdaptor.getDeliveryLeadTime(consignment))).thenReturn(Integer.valueOf(defaultLeadTime));
		final int result = consignmentTrackingService.getDeliveryLeadTime(consignment);
		Assert.assertEquals(defaultLeadTime, result);
	}

	@Test
	public void testGetDefaultDeliveryLeadTime()
	{
		Mockito.when(configurationService.getConfiguration()).thenReturn(baseConfiguration);
		Mockito.when(baseConfiguration.getInt(Mockito.anyString(), Mockito.anyInt())).thenReturn(0);

		final int result = consignmentTrackingService.getDefaultDeliveryLeadTime();

		Assert.assertEquals(result, 0);
	}

	@Test
	public void testUpdateConsignmentStatusForCode()
	{
		Mockito.when(consignmentDao.findConsignmentByCode(orderCode, consignmentCode)).thenReturn(Optional.of(consignment));
		Mockito.doNothing().when(modelService).save(Mockito.any());
		consignmentTrackingService.updateConsignmentStatusForCode(orderCode, consignmentCode, ConsignmentStatus.SHIPPED);
		final Optional<ConsignmentModel> optional = consignmentDao.findConsignmentByCode(orderCode, consignmentCode);
		Assert.assertEquals(ConsignmentStatus.SHIPPED, optional.get().getStatus());
	}
}
