/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.strategies;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commerceservices.strategies.impl.CommerceNetGrossStrategy;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.order.CartService;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.site.BaseSiteService;
import de.hybris.platform.store.BaseStoreModel;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Integration test for {@link CommerceNetGrossStrategy}.
 */
@IntegrationTest
public class CommerceNetGrossStrategyIntTest extends ServicelayerTransactionalTest
{
	@Resource
	private NetGrossStrategy commerceNetGrossStrategy;

	@Resource
	private CartService cartService;

	@Resource
	private NetGrossStrategy defaultNetGrossStrategy;

	@Resource
	private ModelService modelService;

	@Resource
	private BaseSiteService baseSiteService;

	private CommerceStrategyTestHelper helper;

	private BaseSiteModel baseSiteModel;

	@Before
	public void setUp()
	{
		helper = new CommerceStrategyTestHelper();
		baseSiteModel = helper.createSite(modelService, baseSiteService);

	}

	@Test
	public void testBaseStore()
	{
		final BaseStoreModel store1 = helper.createStore("store1", modelService);
		final List<BaseStoreModel> stores = new LinkedList<BaseStoreModel>();
		stores.add(store1);
		baseSiteModel.setStores(stores);
		modelService.save(baseSiteModel);
		Assert.assertEquals(Boolean.valueOf(store1.isNet()), Boolean.valueOf(commerceNetGrossStrategy.isNet()));
	}

	@Test
	public void testCart()
	{
		final CartModel cart = cartService.getSessionCart();
		Assert.assertEquals(cart.getNet(), Boolean.valueOf(commerceNetGrossStrategy.isNet()));
	}

	@Test
	public void testFallback()
	{
		Assert.assertEquals(Boolean.valueOf(defaultNetGrossStrategy.isNet()), Boolean.valueOf(commerceNetGrossStrategy.isNet()));
	}
}
