/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.solrsearch.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import de.hybris.platform.core.model.type.ComposedTypeModel;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.hybris.backoffice.solrsearch.model.BackofficeIndexedTypeToSolrFacetSearchConfigModel;

@RunWith(MockitoJUnitRunner.class)
public class DefaultBackofficeFacetSearchConfigServiceTest {

    public static final String TYPE = "Type";
    public static final String SUB_TYPE = "SubType";
    @Spy
    private DefaultBackofficeFacetSearchConfigService service;

    @Mock
    private ComposedTypeModel typeModel;
    @Mock
    private ComposedTypeModel subTypeModel;
    @Mock
    private BackofficeIndexedTypeToSolrFacetSearchConfigModel configType;
    @Mock
    private BackofficeIndexedTypeToSolrFacetSearchConfigModel configSubtype;

    @Test
    public void findMatchingConfigShouldReturnResultOfRecursiveLookup()
    {
        //given
        final Collection<BackofficeIndexedTypeToSolrFacetSearchConfigModel> configs = new ArrayList<>();

        configs.add(configType);
        configs.add(configSubtype);

        doReturn(typeModel).when(configType).getIndexedType();
        doReturn(subTypeModel).when(configSubtype).getIndexedType();

        doReturn(TYPE).when(typeModel).getCode();
        doReturn(SUB_TYPE).when(subTypeModel).getCode();

        doReturn(configSubtype).when(service).findMatchingConfigRecursively(any(), any());

        //when
        final BackofficeIndexedTypeToSolrFacetSearchConfigModel result = service.findMatchingConfig(typeModel, configs);

        //then
        assertThat(result).isSameAs(configSubtype);
    }

    @Test
    public void findMatchingConfigShouldReturnNullOnEmptyConfig()
    {
        //when
        final BackofficeIndexedTypeToSolrFacetSearchConfigModel result = service.findMatchingConfig(typeModel, new ArrayList<>());

        //then
        assertThat(result).isNull();
    }

    @Test
    public void findMatchingConfigShouldReturnTheOnlyElementWithNoFurtherChecks()
    {
        //given
        final Collection<BackofficeIndexedTypeToSolrFacetSearchConfigModel> configs = new ArrayList<>();

        configs.add(configType);

        //when
        final BackofficeIndexedTypeToSolrFacetSearchConfigModel result = service.findMatchingConfig(typeModel, configs);

        //then
        assertThat(result).isSameAs(configType);
        verify(service, never()).findMatchingConfigRecursively(any(), any());
    }

}