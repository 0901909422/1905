/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.marketplaceaddon.controllers;

import de.hybris.platform.cms2lib.model.components.BannerComponentModel;
import de.hybris.platform.cms2lib.model.components.ProductCarouselComponentModel;
import de.hybris.platform.cms2lib.model.components.RotatingImagesComponentModel;


/**
 */
public interface MarketplaceaddonControllerConstants
{
	// Constant names cannot be changed due to their usage in dependant extensions, thus nosonar

	final String ADDON_PREFIX = "addon:/marketplaceaddon";

	/**
	 * Class with action name constants
	 */
	interface Actions
	{
		interface Cms // NOSONAR
		{
			String _Prefix = "/view/"; // NOSONAR
			String _Suffix = "Controller"; // NOSONAR

			/**
			 * Default CMS component controller
			 */
			String ProductCarouselComponent = _Prefix + ProductCarouselComponentModel._TYPECODE + _Suffix; // NOSONAR
			String RotatingImagesComponent = _Prefix + RotatingImagesComponentModel._TYPECODE + _Suffix; // NOSONAR
			String BannerComponent = _Prefix + BannerComponentModel._TYPECODE + _Suffix; // NOSONAR

		}
	}

	interface Views
	{
		interface Pages
		{
			interface Order
			{
				String OrderReviewPage = ADDON_PREFIX + "/pages/order/orderReviewPage";
			}

			interface Vendor
			{
				String VendorIndexPage = ADDON_PREFIX + "/pages/layout/vendorIndexLayoutPage";
				String VendorReviewsPage = ADDON_PREFIX + "/pages/store/vendorReviewsPage";
			}
		}
	}

}
