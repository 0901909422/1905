/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.assistedserviceservices.exception;


/**
 * Exception for the {@link AssistedServiceFacade} which is used when customer and cart id not provided to start session
 * emulating.
 */
public class AssistedServiceAgentNoCustomerAndCartIdException extends AssistedServiceException
{
	public AssistedServiceAgentNoCustomerAndCartIdException(final String message)
	{
		super(message);
	}

	@Override
	public String getMessageCode()
	{
		return "asm.emulate.error.no_customer_or_cart_id_provided";
	}
}