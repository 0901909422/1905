/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jan 15, 2022, 4:18:31 PM                    ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.integrationservices.jalo;

import de.hybris.platform.integrationservices.constants.IntegrationservicesConstants;
import de.hybris.platform.integrationservices.jalo.IntegrationObjectItem;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.type.AttributeDescriptor;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.util.BidirectionalOneToManyHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem IntegrationObjectItemAttribute}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedIntegrationObjectItemAttribute extends GenericItem
{
	/** Qualifier of the <code>IntegrationObjectItemAttribute.attributeDescriptor</code> attribute **/
	public static final String ATTRIBUTEDESCRIPTOR = "attributeDescriptor";
	/** Qualifier of the <code>IntegrationObjectItemAttribute.attributeName</code> attribute **/
	public static final String ATTRIBUTENAME = "attributeName";
	/** Qualifier of the <code>IntegrationObjectItemAttribute.returnIntegrationObjectItem</code> attribute **/
	public static final String RETURNINTEGRATIONOBJECTITEM = "returnIntegrationObjectItem";
	/** Qualifier of the <code>IntegrationObjectItemAttribute.unique</code> attribute **/
	public static final String UNIQUE = "unique";
	/** Qualifier of the <code>IntegrationObjectItemAttribute.autoCreate</code> attribute **/
	public static final String AUTOCREATE = "autoCreate";
	/** Qualifier of the <code>IntegrationObjectItemAttribute.integrationObjectItem</code> attribute **/
	public static final String INTEGRATIONOBJECTITEM = "integrationObjectItem";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n INTEGRATIONOBJECTITEM's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedIntegrationObjectItemAttribute> INTEGRATIONOBJECTITEMHANDLER = new BidirectionalOneToManyHandler<GeneratedIntegrationObjectItemAttribute>(
	IntegrationservicesConstants.TC.INTEGRATIONOBJECTITEMATTRIBUTE,
	false,
	"integrationObjectItem",
	null,
	false,
	true,
	CollectionType.SET
	);
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(ATTRIBUTEDESCRIPTOR, AttributeMode.INITIAL);
		tmp.put(ATTRIBUTENAME, AttributeMode.INITIAL);
		tmp.put(RETURNINTEGRATIONOBJECTITEM, AttributeMode.INITIAL);
		tmp.put(UNIQUE, AttributeMode.INITIAL);
		tmp.put(AUTOCREATE, AttributeMode.INITIAL);
		tmp.put(INTEGRATIONOBJECTITEM, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.attributeDescriptor</code> attribute.
	 * @return the attributeDescriptor
	 */
	public AttributeDescriptor getAttributeDescriptor(final SessionContext ctx)
	{
		return (AttributeDescriptor)getProperty( ctx, ATTRIBUTEDESCRIPTOR);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.attributeDescriptor</code> attribute.
	 * @return the attributeDescriptor
	 */
	public AttributeDescriptor getAttributeDescriptor()
	{
		return getAttributeDescriptor( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItemAttribute.attributeDescriptor</code> attribute. 
	 * @param value the attributeDescriptor
	 */
	public void setAttributeDescriptor(final SessionContext ctx, final AttributeDescriptor value)
	{
		setProperty(ctx, ATTRIBUTEDESCRIPTOR,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItemAttribute.attributeDescriptor</code> attribute. 
	 * @param value the attributeDescriptor
	 */
	public void setAttributeDescriptor(final AttributeDescriptor value)
	{
		setAttributeDescriptor( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.attributeName</code> attribute.
	 * @return the attributeName
	 */
	public String getAttributeName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, ATTRIBUTENAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.attributeName</code> attribute.
	 * @return the attributeName
	 */
	public String getAttributeName()
	{
		return getAttributeName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItemAttribute.attributeName</code> attribute. 
	 * @param value the attributeName
	 */
	public void setAttributeName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, ATTRIBUTENAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItemAttribute.attributeName</code> attribute. 
	 * @param value the attributeName
	 */
	public void setAttributeName(final String value)
	{
		setAttributeName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.autoCreate</code> attribute.
	 * @return the autoCreate
	 */
	public Boolean isAutoCreate(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, AUTOCREATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.autoCreate</code> attribute.
	 * @return the autoCreate
	 */
	public Boolean isAutoCreate()
	{
		return isAutoCreate( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.autoCreate</code> attribute. 
	 * @return the autoCreate
	 */
	public boolean isAutoCreateAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isAutoCreate( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.autoCreate</code> attribute. 
	 * @return the autoCreate
	 */
	public boolean isAutoCreateAsPrimitive()
	{
		return isAutoCreateAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItemAttribute.autoCreate</code> attribute. 
	 * @param value the autoCreate
	 */
	public void setAutoCreate(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, AUTOCREATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItemAttribute.autoCreate</code> attribute. 
	 * @param value the autoCreate
	 */
	public void setAutoCreate(final Boolean value)
	{
		setAutoCreate( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItemAttribute.autoCreate</code> attribute. 
	 * @param value the autoCreate
	 */
	public void setAutoCreate(final SessionContext ctx, final boolean value)
	{
		setAutoCreate( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItemAttribute.autoCreate</code> attribute. 
	 * @param value the autoCreate
	 */
	public void setAutoCreate(final boolean value)
	{
		setAutoCreate( getSession().getSessionContext(), value );
	}
	
	@Override
	protected Item createItem(final SessionContext ctx, final ComposedType type, final ItemAttributeMap allAttributes) throws JaloBusinessException
	{
		INTEGRATIONOBJECTITEMHANDLER.newInstance(ctx, allAttributes);
		return super.createItem( ctx, type, allAttributes );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.integrationObjectItem</code> attribute.
	 * @return the integrationObjectItem
	 */
	public IntegrationObjectItem getIntegrationObjectItem(final SessionContext ctx)
	{
		return (IntegrationObjectItem)getProperty( ctx, INTEGRATIONOBJECTITEM);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.integrationObjectItem</code> attribute.
	 * @return the integrationObjectItem
	 */
	public IntegrationObjectItem getIntegrationObjectItem()
	{
		return getIntegrationObjectItem( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItemAttribute.integrationObjectItem</code> attribute. 
	 * @param value the integrationObjectItem
	 */
	public void setIntegrationObjectItem(final SessionContext ctx, final IntegrationObjectItem value)
	{
		INTEGRATIONOBJECTITEMHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItemAttribute.integrationObjectItem</code> attribute. 
	 * @param value the integrationObjectItem
	 */
	public void setIntegrationObjectItem(final IntegrationObjectItem value)
	{
		setIntegrationObjectItem( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.returnIntegrationObjectItem</code> attribute.
	 * @return the returnIntegrationObjectItem
	 */
	public IntegrationObjectItem getReturnIntegrationObjectItem(final SessionContext ctx)
	{
		return (IntegrationObjectItem)getProperty( ctx, RETURNINTEGRATIONOBJECTITEM);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.returnIntegrationObjectItem</code> attribute.
	 * @return the returnIntegrationObjectItem
	 */
	public IntegrationObjectItem getReturnIntegrationObjectItem()
	{
		return getReturnIntegrationObjectItem( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItemAttribute.returnIntegrationObjectItem</code> attribute. 
	 * @param value the returnIntegrationObjectItem
	 */
	public void setReturnIntegrationObjectItem(final SessionContext ctx, final IntegrationObjectItem value)
	{
		setProperty(ctx, RETURNINTEGRATIONOBJECTITEM,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItemAttribute.returnIntegrationObjectItem</code> attribute. 
	 * @param value the returnIntegrationObjectItem
	 */
	public void setReturnIntegrationObjectItem(final IntegrationObjectItem value)
	{
		setReturnIntegrationObjectItem( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.unique</code> attribute.
	 * @return the unique
	 */
	public Boolean isUnique(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, UNIQUE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.unique</code> attribute.
	 * @return the unique
	 */
	public Boolean isUnique()
	{
		return isUnique( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.unique</code> attribute. 
	 * @return the unique
	 */
	public boolean isUniqueAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isUnique( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItemAttribute.unique</code> attribute. 
	 * @return the unique
	 */
	public boolean isUniqueAsPrimitive()
	{
		return isUniqueAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItemAttribute.unique</code> attribute. 
	 * @param value the unique
	 */
	public void setUnique(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, UNIQUE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItemAttribute.unique</code> attribute. 
	 * @param value the unique
	 */
	public void setUnique(final Boolean value)
	{
		setUnique( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItemAttribute.unique</code> attribute. 
	 * @param value the unique
	 */
	public void setUnique(final SessionContext ctx, final boolean value)
	{
		setUnique( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItemAttribute.unique</code> attribute. 
	 * @param value the unique
	 */
	public void setUnique(final boolean value)
	{
		setUnique( getSession().getSessionContext(), value );
	}
	
}
