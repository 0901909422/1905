/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.search.solrfacetsearch.converters.populator;

import de.hybris.platform.commercefacades.product.data.CategoryData;
import de.hybris.platform.commercefacades.search.data.SearchQueryData;
import de.hybris.platform.commercefacades.search.data.SearchStateData;
import de.hybris.platform.commerceservices.search.solrfacetsearch.data.SolrSearchQueryData;
import de.hybris.platform.commerceservices.url.UrlResolver;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;


/**
 */
public class SolrSearchStatePopulator implements Populator<SolrSearchQueryData, SearchStateData>
{
	private static final Logger LOG = Logger.getLogger(SolrSearchStatePopulator.class);

	private String searchPath;
	private UrlResolver<CategoryData> categoryDataUrlResolver;
	private Converter<SolrSearchQueryData, SearchQueryData> searchQueryConverter;

	protected String getSearchPath()
	{
		return searchPath;
	}

	@Required
	public void setSearchPath(final String searchPath)
	{
		this.searchPath = searchPath;
	}

	protected UrlResolver<CategoryData> getCategoryDataUrlResolver()
	{
		return categoryDataUrlResolver;
	}

	@Required
	public void setCategoryDataUrlResolver(final UrlResolver<CategoryData> categoryDataUrlResolver)
	{
		this.categoryDataUrlResolver = categoryDataUrlResolver;
	}

	protected Converter<SolrSearchQueryData, SearchQueryData> getSearchQueryConverter()
	{
		return searchQueryConverter;
	}

	@Required
	public void setSearchQueryConverter(final Converter<SolrSearchQueryData, SearchQueryData> searchQueryConverter)
	{
		this.searchQueryConverter = searchQueryConverter;
	}

	@Override
	public void populate(final SolrSearchQueryData source, final SearchStateData target)
	{
		target.setQuery(getSearchQueryConverter().convert(source));

		if (source.getCategoryCode() != null)
		{
			populateCategorySearchUrl(source, target);
		}
		else
		{
			populateFreeTextSearchUrl(source, target);
		}
	}

	protected void populateCategorySearchUrl(final SolrSearchQueryData source, final SearchStateData target)
	{
		target.setUrl(getCategoryUrl(source) + buildUrlQueryString(source, target));
	}

	protected void populateFreeTextSearchUrl(final SolrSearchQueryData source, final SearchStateData target)
	{
		target.setUrl(getSearchPath() + buildUrlQueryString(source, target));
	}

	protected String getCategoryUrl(final SolrSearchQueryData source)
	{
		final CategoryData categoryData = new CategoryData();
		categoryData.setCode(source.getCategoryCode());
		return getCategoryDataUrlResolver().resolve(categoryData);
	}

	protected String buildUrlQueryString(final SolrSearchQueryData source, final SearchStateData target)
	{
		final String searchQueryParam = target.getQuery().getValue();
		if (StringUtils.isNotBlank(searchQueryParam))
		{
			try
			{
				return "?q=" + URLEncoder.encode(searchQueryParam, "UTF-8");
			}
			catch (final UnsupportedEncodingException e)
			{
				LOG.error("Unsupported encoding (UTF-8). Fallback to html escaping.", e);
				return "?q=" + StringEscapeUtils.escapeHtml(searchQueryParam);
			}
		}
		return "";
	}
}
