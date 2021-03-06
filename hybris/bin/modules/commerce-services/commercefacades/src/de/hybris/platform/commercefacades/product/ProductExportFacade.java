/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.product;

import de.hybris.platform.commercefacades.product.data.ProductResultData;

import java.util.Collection;
import java.util.Date;


/**
 * Product export facade interface. Its main purpose is to retrieve products for export operations.
 */
public interface ProductExportFacade
{

	/**
	 * Retrieves all products
	 *
	 * @param catalog
	 *           the catalog from which to get the products
	 * @param version
	 *           the catalog version
	 * @param start
	 *           index position of the first Product, which will be included in the returned List
	 * @param count
	 *           number of Products which will be returned in the List
	 * @param options
	 *           options set that determines amount of information that will be attached to the returned product.
	 * @return {@link ProductResultData}
	 */
	ProductResultData getAllProductsForOptions(final String catalog, final String version, Collection<ProductOption> options,
			final int start, final int count);

	/**
	 * Retrieves products that were modified after timestamp
	 *
	 * @param catalog
	 *           the catalog from which to get the products
	 * @param version
	 *           the catalog version
	 * @param modifiedTime
	 *           timestamp
	 * @param start
	 *           index position of the first Product, which will be included in the returned List
	 * @param count
	 *           number of Products which will be returned in the List
	 * @param options
	 *           options set that determines amount of information that will be attached to the returned product.
	 * @return {@link ProductResultData}
	 */
	ProductResultData getOnlyModifiedProductsForOptions(String catalog, String version, Date modifiedTime,
			Collection<ProductOption> options, int start, int count);

}
