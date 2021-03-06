/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commerceservices.util;

import de.hybris.platform.util.Config;

import org.apache.commons.lang.StringUtils;


/**
 * Temporary class to verify if the current experience is responsive or 'classic' desktop. This will be deleted at the
 * same time as the 'classic' desktop experience.
 * 
 */
public class ResponsiveUtils
{
	public static final String DEFAULT_UI_EXPERIENCE = "commerceservices.default.desktop.ui.experience";
	public static final String RESPONSIVE = "responsive";

	/**
	 * @return true if the application is set up as responsive
	 */
	public static boolean isResponsive()
	{
		if (StringUtils.isBlank(Config.getParameter(DEFAULT_UI_EXPERIENCE)))
		{
			return true;
		}
		return StringUtils.equalsIgnoreCase(Config.getParameter(DEFAULT_UI_EXPERIENCE), RESPONSIVE);
	}

}
