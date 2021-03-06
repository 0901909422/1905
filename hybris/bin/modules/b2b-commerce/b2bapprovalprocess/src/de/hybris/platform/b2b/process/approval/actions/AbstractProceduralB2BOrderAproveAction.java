/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.b2b.process.approval.actions;

import de.hybris.platform.b2b.process.approval.model.B2BApprovalProcessModel;
import de.hybris.platform.processengine.action.AbstractProceduralAction;
import de.hybris.platform.processengine.model.BusinessProcessModel;
import de.hybris.platform.task.RetryLaterException;


/**
 * An interface for executing an action of a b2b approval process
 * 
 * @deprecated Since 4.5. Use {@link AbstractProceduralB2BOrderApproveAction}
 */
@Deprecated(since = "4.5")
public abstract class AbstractProceduralB2BOrderAproveAction extends AbstractProceduralAction
{
	@Override
	public final void executeAction(final BusinessProcessModel process) throws RetryLaterException
	{
		this.executeAction((B2BApprovalProcessModel) process);
	}

	/**
	 * Execute an action of a B2B approval process
	 * 
	 * @param process
	 *           the process context to work on
	 * @throws RetryLaterException
	 *            Triggers the action to be processes again.
	 * @throws Exception
	 *            Any error has occurred.
	 */
	public abstract void executeAction(B2BApprovalProcessModel process) throws RetryLaterException;


}
