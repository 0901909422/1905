/*
 *  
 * [y] hybris Platform
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.customerinterestsoccaddon.jalo;

import de.hybris.platform.customerinterestsoccaddon.constants.CustomerinterestsoccaddonConstants;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.apache.log4j.Logger;

public class CustomerinterestsoccaddonManager extends GeneratedCustomerinterestsoccaddonManager
{
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger( CustomerinterestsoccaddonManager.class.getName() );
	
	public static final CustomerinterestsoccaddonManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (CustomerinterestsoccaddonManager) em.getExtension(CustomerinterestsoccaddonConstants.EXTENSIONNAME);
	}
	
}
