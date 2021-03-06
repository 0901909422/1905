/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.product;

import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.commerceservices.stock.CommerceStockService;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;

import java.util.Collection;


/**
 * Product related methods that add extra b2c relevant functions not provided in {@link ProductService}
 */
public interface CommerceProductService
{

	/**
	 * Gets the super categories except classification classes.
	 * 
	 * @param productModel
	 *           the product model to retrieve super categories from
	 * @return the super categories except classification classes items
	 * @throws IllegalArgumentException
	 *            the illegal argument exception when given product model is <code>null</code>
	 */
	Collection<CategoryModel> getSuperCategoriesExceptClassificationClassesForProduct(ProductModel productModel)
			throws IllegalArgumentException;

	/**
	 * @deprecated Since 5.0. Use {@link CommerceStockService}
	 * 
	 * @param productModel
	 *           the product model to look stock level for
	 * @return the available stock
	 */
	@Deprecated(since = "5.0")
	Integer getStockLevelForProduct(ProductModel productModel);

}
