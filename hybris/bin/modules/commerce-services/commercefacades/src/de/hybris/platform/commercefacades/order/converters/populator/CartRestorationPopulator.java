/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.order.converters.populator;

import de.hybris.platform.commercefacades.order.data.CartModificationData;
import de.hybris.platform.commercefacades.order.data.CartRestorationData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.commerceservices.order.CommerceCartModification;
import de.hybris.platform.commerceservices.order.CommerceCartRestoration;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;


/**
 */
public class CartRestorationPopulator implements Populator<CommerceCartRestoration, CartRestorationData>
{
	private Converter<CommerceCartModification, CartModificationData> cartModificationConverter;

	protected Converter<CommerceCartModification, CartModificationData> getCartModificationConverter()
	{
		return cartModificationConverter;
	}

	@Required
	public void setCartModificationConverter(
			final Converter<CommerceCartModification, CartModificationData> cartModificationConverter)
	{
		this.cartModificationConverter = cartModificationConverter;
	}

	@Override
	public void populate(final CommerceCartRestoration source, final CartRestorationData target)
	{
		if (source != null)
		{
			final List<CartModificationData> modifications = new ArrayList<CartModificationData>();
			for (final CommerceCartModification modification : source.getModifications())
			{
				modifications.add(getCartModificationConverter().convert(modification));
			}
			target.setModifications(modifications);
		}
	}
}
