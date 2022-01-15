/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.chinesepspwechatpay.constants;



public interface ControllerConstants
{

	interface Views
	{
		String _AddonPrefix = "addon:/chinesepspwechatpaymentaddon/";

		interface Pages
		{

			interface Checkout
			{
				String WeChatPayPage = _AddonPrefix + "pages/checkout/weChatPayPage";
			}
		}
	}
}
