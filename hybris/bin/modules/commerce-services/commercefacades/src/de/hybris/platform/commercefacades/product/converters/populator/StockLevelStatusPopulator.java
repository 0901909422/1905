/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.product.converters.populator;

import de.hybris.platform.basecommerce.enums.StockLevelStatus;
import de.hybris.platform.commercefacades.product.data.StockData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;


/**
 * Populate the stock data with simplistic stock information.
 */
public class StockLevelStatusPopulator<SOURCE extends StockLevelStatus, TARGET extends StockData> implements
		Populator<SOURCE, TARGET>
{
	@Override
	public void populate(final SOURCE stockLevelStatusEnum, final TARGET stockData) throws ConversionException
	{
		if (StockLevelStatus.OUTOFSTOCK.equals(stockLevelStatusEnum))
		{
			stockData.setStockLevelStatus(StockLevelStatus.OUTOFSTOCK);
			stockData.setStockLevel(Long.valueOf(0));
		}
		else if (StockLevelStatus.INSTOCK.equals(stockLevelStatusEnum))
		{
			stockData.setStockLevelStatus(StockLevelStatus.INSTOCK);
			stockData.setStockLevel(null);
		}
	}
}
