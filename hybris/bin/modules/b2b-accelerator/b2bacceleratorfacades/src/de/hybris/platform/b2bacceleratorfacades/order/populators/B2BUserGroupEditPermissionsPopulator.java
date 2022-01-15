/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2bacceleratorfacades.order.populators;

import de.hybris.platform.b2b.company.B2BCommerceB2BUserGroupService;
import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.b2b.model.B2BUserGroupModel;
import de.hybris.platform.b2bacceleratorfacades.user.populators.B2BCustomerPopulator;
import de.hybris.platform.b2bcommercefacades.company.data.B2BUserGroupData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.converters.Populator;

import java.util.List;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Required;


/**
 * Populates {@link B2BUserGroupData} from {@link CustomerData} with User Group Edit Permissions. It assumes that
 * CustomerData always contains permission groups list. It can only be invoked after the {@link B2BCustomerPopulator}.
 *
 * @deprecated Since 6.0. Use
 *             {@link de.hybris.platform.b2bapprovalprocessfacades.company.converters.populators.B2BUserGroupEditPermissionsPopulator}
 *             instead.
 */
@Deprecated(since = "6.0")
public class B2BUserGroupEditPermissionsPopulator implements Populator<B2BCustomerModel, CustomerData>
{
	private static final int MAX_PAGE_SIZE = 100;
	private B2BCommerceB2BUserGroupService b2bCommerceB2bUserGroupService;

	@Override
	public void populate(final B2BCustomerModel source, final CustomerData target)
	{
		final List<B2BUserGroupData> processedPermissionGroups = populateUserGroupsEditPermissions(target).getPermissionGroups();
		target.setPermissionGroups(processedPermissionGroups);
	}

	protected CustomerData populateUserGroupsEditPermissions(final CustomerData customerData)
	{
		final List<B2BUserGroupData> customerPermissionGroups = customerData.getPermissionGroups();

		if (!customerPermissionGroups.isEmpty())
		{
			final SearchPageData<B2BUserGroupModel> currentUserPermissionGroups = getB2bCommerceB2bUserGroupService()
					.getPagedB2BUserGroups(createPageableData());
			final List<B2BUserGroupModel> results = currentUserPermissionGroups.getResults();

			CollectionUtils.forAllDo(customerPermissionGroups, new Closure()
			{
				@Override
				public void execute(final Object input)
				{
					final B2BUserGroupData b2bUserGroupData = (B2BUserGroupData) input;
					b2bUserGroupData.setEditable(isUserGroupAllowedToEditByCurrentUser(b2bUserGroupData, results));
				}
			});
		}
		return customerData;
	}

	protected PageableData createPageableData()
	{
		final PageableData pageableData = new PageableData();
		pageableData.setPageSize(MAX_PAGE_SIZE);
		return pageableData;
	}

	protected boolean isUserGroupAllowedToEditByCurrentUser(final B2BUserGroupData userGroupToCheck,
			final List<B2BUserGroupModel> editableUserGroupsForCurrentUser)
	{
		return CollectionUtils.exists(editableUserGroupsForCurrentUser, new org.apache.commons.collections.Predicate()
		{
			@Override
			public boolean evaluate(final Object input)
			{
				final B2BUserGroupModel b2BUserGroupModel = (B2BUserGroupModel) input;
				final String uidToCheck = userGroupToCheck.getUid();
				final String editableUid = b2BUserGroupModel.getUid();
				return StringUtils.equals(uidToCheck, editableUid);
			}
		});
	}

	protected B2BCommerceB2BUserGroupService getB2bCommerceB2bUserGroupService()
	{
		return b2bCommerceB2bUserGroupService;
	}

	@Required
	public void setB2bCommerceB2bUserGroupService(final B2BCommerceB2BUserGroupService b2bCommerceB2bUserGroupService)
	{
		this.b2bCommerceB2bUserGroupService = b2bCommerceB2bUserGroupService;
	}
}
