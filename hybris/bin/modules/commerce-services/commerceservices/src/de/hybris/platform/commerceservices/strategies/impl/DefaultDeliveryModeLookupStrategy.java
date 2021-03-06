/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.strategies.impl;

import de.hybris.platform.commerceservices.delivery.dao.CountryZoneDeliveryModeDao;
import de.hybris.platform.commerceservices.delivery.dao.PickupDeliveryModeDao;
import de.hybris.platform.commerceservices.strategies.DeliveryModeLookupStrategy;
import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.order.delivery.DeliveryModeModel;
import de.hybris.platform.core.model.user.AddressModel;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Required;


/**
 * Default implementation for {@link DeliveryModeLookupStrategy}
 * 
 */
public class DefaultDeliveryModeLookupStrategy implements DeliveryModeLookupStrategy
{
	private CountryZoneDeliveryModeDao countryZoneDeliveryModeDao;
	private PickupDeliveryModeDao pickupDeliveryModeDao;

	@Override
	public List<DeliveryModeModel> getSelectableDeliveryModesForOrder(final AbstractOrderModel abstractOrderModel)
	{
		if (isPickUpOnlyOrder(abstractOrderModel))
		{
			return new ArrayList<DeliveryModeModel>(getPickupDeliveryModeDao().findPickupDeliveryModesForAbstractOrder(
					abstractOrderModel));
		}
		else
		{
			final List<DeliveryModeModel> deliveryModes = new ArrayList<DeliveryModeModel>();
			final AddressModel deliveryAddress = abstractOrderModel.getDeliveryAddress();
			final CurrencyModel currency = abstractOrderModel.getCurrency();
			if (currency != null && deliveryAddress != null && deliveryAddress.getCountry() != null)
			{
				deliveryModes.addAll(getCountryZoneDeliveryModeDao().findDeliveryModes(abstractOrderModel));
				return deliveryModes;
			}
			return deliveryModes;
		}
	}

	protected boolean isPickUpOnlyOrder(final AbstractOrderModel abstractOrderModel)
	{
		if (CollectionUtils.isNotEmpty(abstractOrderModel.getEntries()))
		{
			for (final AbstractOrderEntryModel entry : abstractOrderModel.getEntries())
			{
				if (entry.getDeliveryPointOfService() == null)
				{
					return false;
				}
			}
		}
		return true;
	}

	protected PickupDeliveryModeDao getPickupDeliveryModeDao()
	{
		return pickupDeliveryModeDao;
	}

	@Required
	public void setPickupDeliveryModeDao(final PickupDeliveryModeDao pickupDeliveryModeDao)
	{
		this.pickupDeliveryModeDao = pickupDeliveryModeDao;
	}

	protected CountryZoneDeliveryModeDao getCountryZoneDeliveryModeDao()
	{
		return countryZoneDeliveryModeDao;
	}

	@Required
	public void setCountryZoneDeliveryModeDao(final CountryZoneDeliveryModeDao countryZoneDeliveryModeDao)
	{
		this.countryZoneDeliveryModeDao = countryZoneDeliveryModeDao;
	}
}
