/**
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.hybris.merchandising.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import com.hybris.charon.annotations.OAuth;
import com.hybris.merchandising.model.Strategy;


/**
 * MerchStrategyServiceClient is an JAX-RS client for the Merch v2 Strategy Service.
 */
@OAuth
public interface MerchStrategyServiceClient
{
	/**
	 * getStrategies is an API for returning a list of configured {@link Strategy} entities. This is intended for use with
	 * pagination.
	 */
	@GET
	@Path("/${tenant}/strategies")
	List<Strategy> getStrategies(@QueryParam("pageNumber") Integer pageNumber, @QueryParam("pageSize") Integer pageSize);

	/**
	 * getStrategies is an API for returning all {@link Strategy} entities configured without pagination.
	 */
	@GET
	@Path("/${tenant}/strategies")
	List<Strategy> getStrategies();

	/**
	 * getStrategy is an API for returning a {@link Strategy} entity with an id
	 */
	@GET
	@Path("/${tenant}/strategies/{id}")
	Strategy getStrategy(@PathParam("id") String id);
}
