/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.customer.dao;

import de.hybris.platform.basecommerce.enums.ReturnStatus;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.enums.OrderStatus;
import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.core.model.order.payment.CreditCardPaymentInfoModel;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.returns.model.ReturnRequestModel;
import de.hybris.platform.servicelayer.internal.dao.Dao;
import de.hybris.platform.store.BaseStoreModel;

import java.util.Collection;
import java.util.Date;
import java.util.List;


/**
 * Data Access Object for looking up items related to the Customer's account.
 */
public interface CustomerAccountDao extends Dao
{
	/**
	 * Finds the specified order for the specified user in the current session's active catalog versions
	 *
	 * @param customerModel
	 *           the customer
	 * @param code
	 *           the code representing the order
	 * @param store
	 *           The current store
	 * @return The order found
	 * @throws de.hybris.platform.servicelayer.exceptions.ModelNotFoundException
	 *            if nothing was found
	 * @throws de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException
	 *            if by the given search params to many models where found
	 */
	OrderModel findOrderByCustomerAndCodeAndStore(CustomerModel customerModel, String code, BaseStoreModel store);

	/**
	 * Finds the specified order for the specified user in the current session's active catalog versions
	 *
	 * @param guid
	 *           the guid representing the order
	 * @param store
	 *           the current store
	 * @param expiryDate
	 *           Order expiration date
	 * @return the order
	 * @throws de.hybris.platform.servicelayer.exceptions.ModelNotFoundException
	 *            if nothing was found
	 * @throws de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException
	 *            if by the given search params to many models where found
	 */
	OrderModel findOrderByGUIDAndStore(String guid, BaseStoreModel store, Date expiryDate);

	/**
	 * Finds orders for the specified user in the current session's active catalog versions
	 *
	 * @param customerModel
	 *           the customer
	 * @param store
	 *           The current store
	 * @param status
	 *           A list of order statuses to include in the result, if null or empty then all statuses are included
	 * @return The list of orders owned by the customer associated with the store
	 */
	List<OrderModel> findOrdersByCustomerAndStore(CustomerModel customerModel, BaseStoreModel store, OrderStatus[] status);

	/**
	 * Finds orders for the specified user in the current session's active catalog versions
	 *
	 * @param customerModel
	 *           the customer
	 * @param store
	 *           The current store
	 * @param status
	 *           A list of order statuses to include in the result, if null or empty then all statuses are included
	 * @param pageableData
	 *           The pagination data
	 * @return The list of orders owned by the customer associated with the store
	 */
	SearchPageData<OrderModel> findOrdersByCustomerAndStore(CustomerModel customerModel, BaseStoreModel store,
			OrderStatus[] status, PageableData pageableData);

	/**
	 * Returns the {@link ReturnRequestModel} of the given user filtered by given list of {@link ReturnStatus}(s).
	 *
	 * @param customerModel
	 *           the {@link CustomerModel} to retrieve return requests for
	 * @param store
	 *           the current {@link BaseStoreModel}
	 * @param returnStatuses
	 * 		the {@link ReturnStatus}(s) to be included in the result. If null or empty then all statuses are included
	 * @param pageableData
	 *           pagination information
	 * @return the list of {@link ReturnRequestModel}
	 */
	SearchPageData<ReturnRequestModel> findReturnRequestsByCustomerAndStore(CustomerModel customerModel, BaseStoreModel store,
			ReturnStatus[] returnStatuses, PageableData pageableData);

	/**
	 * Retrieves the customer's list of credit card payment infos
	 *
	 * @param customerModel
	 *           the customer
	 * @param saved
	 *           <code>true</code> to retrieve only saved credit card payment infos
	 * @return the list of credit card payment infos
	 */
	List<CreditCardPaymentInfoModel> findCreditCardPaymentInfosByCustomer(CustomerModel customerModel, boolean saved);

	/**
	 * Retrieves the customer's credit card payment info
	 *
	 * @param customerModel
	 *           the customer
	 * @param code
	 *           the code of the credit card payment info
	 * @return the credit card payment info
	 */
	CreditCardPaymentInfoModel findCreditCardPaymentInfoByCustomer(CustomerModel customerModel, String code);

	/**
	 * Retrieves the order by order code and base store
	 *
	 * @param code
	 *           order code
	 * @param store
	 *           store
	 * @return order details
	 */
	OrderModel findOrderByCodeAndStore(String code, BaseStoreModel store);

	/**
	 * Find address book delivery entries for customer.
	 *
	 * @param customerModel
	 *           the customer model
	 * @param deliveryCountries
	 *           the delivery countries
	 * @return the list of delivery address
	 */
	List<AddressModel> findAddressBookDeliveryEntriesForCustomer(CustomerModel customerModel,
			Collection<CountryModel> deliveryCountries);
}
