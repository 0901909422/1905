/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock

import de.hybris.bootstrap.annotations.IntegrationTest
import de.hybris.platform.ycommercewebservicestest.setup.TestSetupUtils
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.access.AccessRightsTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.access.OAuth2Test
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.address.AddressTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.basesites.BaseSitesTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.basestores.BaseStoresTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.carts.*
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.catalogs.CatalogsResourceTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.consents.ConsentResourcesTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.countries.CountryResourcesTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.customergroups.CustomerGroupsTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.errors.ErrorTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.export.ExportTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.filters.CartMatchingFilterTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.filters.UserMatchingFilterTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.flows.AddressBookFlow
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.flows.CartFlowTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.general.HeaderTests
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.general.StateTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.misc.*
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.orders.OrdersTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.paymentdetails.PaymentsTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.paymentmodes.PaymentModesTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.products.ProductResourceTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.products.ProductsStockTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.promotions.PromotionsTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.stores.StoresTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.users.UserAccountTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.users.UserOrdersTest
import de.hybris.platform.ycommercewebservicestest.test.groovy.webservicetests.v2.spock.users.UsersResourceTest

import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.slf4j.LoggerFactory

@RunWith(Suite.class)
@Suite.SuiteClasses([
	AccessRightsTest, OAuth2Test, StateTest, CartDeliveryTest, CartMergeTest, CartEntriesTest, CartPromotionsTest,
	CartResourceTest, CartVouchersTest, GuestsTest, OrderPlacementTest, CatalogsResourceTest, CustomerGroupsTest, ErrorTest, ExportTest,
	AddressBookFlow, CartFlowTest, CardTypesTest, CurrenciesTest, DeliveryCountriesTest, LanguagesTest, LocalizationRequestTest, TitlesTest,
	OrdersTest, ProductResourceTest, ProductsStockTest, PromotionsTest, SavedCartTest ,SavedCartFullScenarioTest, StoresTest, UserAccountTest,
	AddressTest, UserOrdersTest, PaymentsTest, PaymentModesTest, UsersResourceTest, CartMatchingFilterTest, UserMatchingFilterTest, HeaderTests,
	ConsentResourcesTest, CountryResourcesTest, BaseStoresTest, BaseSitesTest])
@IntegrationTest
class AllSpockTests {

	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(AllSpockTests.class)

	@BeforeClass
	public static void setUpClass() {
		TestSetupUtils.loadData();
		TestSetupUtils.startServer();
	}

	@AfterClass
	public static void tearDown(){
		TestSetupUtils.stopServer();
		TestSetupUtils.cleanData();
	}

	@Test
	public static void testing() {
		//dummy test class
	}
}
