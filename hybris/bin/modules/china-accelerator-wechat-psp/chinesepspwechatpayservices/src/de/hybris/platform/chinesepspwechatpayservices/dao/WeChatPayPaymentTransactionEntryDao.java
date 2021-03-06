/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.chinesepspwechatpayservices.dao;

import de.hybris.platform.payment.dto.TransactionStatus;
import de.hybris.platform.payment.enums.PaymentTransactionType;
import de.hybris.platform.payment.model.WeChatPayPaymentTransactionEntryModel;
import de.hybris.platform.payment.model.WeChatPayPaymentTransactionModel;

import java.util.List;


/**
 * Provide method to find WeChatPay Payment Transaction Entry
 */
public interface WeChatPayPaymentTransactionEntryDao
{

	/**
	 * Get the list of WeChatPayPaymentTransactionEntries by the given PaymentTransactionEntry type, transaction status
	 * and WeChatPayPaymentTransaction.
	 *
	 * @param capture
	 *           PaymentTransactionEntry type: CAPTURE,CANCEL and so on
	 * @param status
	 *           PaymentTransactionStatus: ACCEPTED,REJECTED and so on
	 * @param weChatPayPaymentTransaction
	 *           WeChatPay Payment Transaction
	 * @return List of WeChatPayPaymentTransactionEntries found
	 */
	List<WeChatPayPaymentTransactionEntryModel> findPaymentTransactionEntryByTypeAndStatus(
			final PaymentTransactionType capture, final TransactionStatus status,
			final WeChatPayPaymentTransactionModel weChatPayPaymentTransaction);

}
