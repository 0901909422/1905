/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.cockpitng.dataaccess.facades;

import static org.assertj.core.api.Assertions.assertThat;

import com.hybris.cockpitng.i18n.CockpitLocaleService;
import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.product.VariantsService;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.i18n.I18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.type.TypeService;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import com.hybris.backoffice.cockpitng.dataaccess.facades.common.PlatformFacadeStrategyHandleCache;
import com.hybris.backoffice.cockpitng.dataaccess.facades.type.DefaultPlatformTypeFacadeStrategy;
import com.hybris.cockpitng.dataaccess.facades.type.DataType;
import com.hybris.cockpitng.dataaccess.facades.type.exceptions.TypeNotFoundException;
import com.hybris.cockpitng.dataaccess.facades.type.impl.DefaultTypeFacade;
import com.hybris.cockpitng.dataaccess.facades.type.impl.TypeFacadeStrategyRegistry;
import org.mockito.Mockito;


@IntegrationTest
public class DefaultTypeFacadeTest extends ServicelayerBaseTest
{
	@Resource
	private TypeService typeService;
	@Resource
	private I18NService i18NService;
	@Resource
	private ModelService modelService;
	@Resource
	private VariantsService variantsService;

	private CockpitLocaleService cockpitLocaleService;

	private DefaultTypeFacade typeFacade;

	@Before
	public void setUp()
	{
		typeFacade = new DefaultTypeFacade();
		cockpitLocaleService = Mockito.mock(CockpitLocaleService.class);

		final TypeFacadeStrategyRegistry registry = new TypeFacadeStrategyRegistry();
		final DefaultPlatformTypeFacadeStrategy strategy = new DefaultPlatformTypeFacadeStrategy();
		strategy.setTypeService(typeService);
		strategy.setI18nService(i18NService);
		strategy.setCockpitLocaleService(cockpitLocaleService);
		strategy.setModelService(modelService);
		strategy.setVariantsService(variantsService);
		final PlatformFacadeStrategyHandleCache platformFacadeStrategyHandleCache = new PlatformFacadeStrategyHandleCache();
		platformFacadeStrategyHandleCache.setTypeService(typeService);
		strategy.setPlatformFacadeStrategyHandleCache(platformFacadeStrategyHandleCache);
		registry.setDefaultStrategy(strategy);
		typeFacade.setStrategyRegistry(registry);
	}

	@Test
	public void testTypeLoad() throws TypeNotFoundException
	{
		final DataType facadeType = typeFacade.load(ProductModel._TYPECODE);
		assertThat(facadeType).isNotNull();

		final ComposedTypeModel platformType = typeService.getComposedTypeForCode("Product");
		assertThat(platformType.getCode()).isEqualTo(facadeType.getCode());
	}

	@Test(expected = TypeNotFoundException.class)
	public void testTypeLoadFail() throws TypeNotFoundException
	{
		typeFacade.load(null);
	}
}
