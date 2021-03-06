/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.marketplaceservices.catalog.impl;

import de.hybris.platform.category.model.CategoryModel;
import de.hybris.platform.commerceservices.search.solrfacetsearch.provider.impl.DefaultCategorySource;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class MarketplaceCategorySource extends DefaultCategorySource
{
	@Override
	public Collection<CategoryModel> getCategoriesForConfigAndProperty(final IndexConfig indexConfig,
			final IndexedProperty indexedProperty, final Object model)
	{
		final Set<ProductModel> products = getProducts(model);
		final Set<CategoryModel> directCategories = getDirectSuperCategories(products);
		final Set<CategoryModel> allCategories = new HashSet<>();

		if (directCategories != null && !directCategories.isEmpty())
		{
			final ProductModel product = (ProductModel) model;
			product.getSupercategories().stream().map(CategoryModel::getCatalogVersion).findAny().map(Collections::singletonList)
					.map(this::lookupRootCategories).ifPresent(rootCategories -> directCategories
							.forEach(category -> allCategories.addAll(getAllCategories(category, rootCategories))));
		}

		return allCategories;
	}

}
