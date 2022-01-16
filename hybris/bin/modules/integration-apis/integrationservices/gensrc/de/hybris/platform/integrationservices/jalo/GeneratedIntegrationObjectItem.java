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
import de.hybris.platform.integrationservices.jalo.IntegrationObject;
import de.hybris.platform.integrationservices.jalo.IntegrationObjectItemAttribute;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.util.BidirectionalOneToManyHandler;
import de.hybris.platform.util.OneToManyHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem IntegrationObjectItem}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedIntegrationObjectItem extends GenericItem
{
	/** Qualifier of the <code>IntegrationObjectItem.code</code> attribute **/
	public static final String CODE = "code";
	/** Qualifier of the <code>IntegrationObjectItem.integrationObject</code> attribute **/
	public static final String INTEGRATIONOBJECT = "integrationObject";
	/** Qualifier of the <code>IntegrationObjectItem.type</code> attribute **/
	public static final String TYPE = "type";
	/** Qualifier of the <code>IntegrationObjectItem.root</code> attribute **/
	public static final String ROOT = "root";
	/** Qualifier of the <code>IntegrationObjectItem.attributes</code> attribute **/
	public static final String ATTRIBUTES = "attributes";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n INTEGRATIONOBJECT's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedIntegrationObjectItem> INTEGRATIONOBJECTHANDLER = new BidirectionalOneToManyHandler<GeneratedIntegrationObjectItem>(
	IntegrationservicesConstants.TC.INTEGRATIONOBJECTITEM,
	false,
	"integrationObject",
	null,
	false,
	true,
	CollectionType.SET
	);
	/**
	* {@link OneToManyHandler} for handling 1:n ATTRIBUTES's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<IntegrationObjectItemAttribute> ATTRIBUTESHANDLER = new OneToManyHandler<IntegrationObjectItemAttribute>(
	IntegrationservicesConstants.TC.INTEGRATIONOBJECTITEMATTRIBUTE,
	true,
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
		tmp.put(CODE, AttributeMode.INITIAL);
		tmp.put(INTEGRATIONOBJECT, AttributeMode.INITIAL);
		tmp.put(TYPE, AttributeMode.INITIAL);
		tmp.put(ROOT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.attributes</code> attribute.
	 * @return the attributes
	 */
	public Set<IntegrationObjectItemAttribute> getAttributes(final SessionContext ctx)
	{
		return (Set<IntegrationObjectItemAttribute>)ATTRIBUTESHANDLER.getValues( ctx, this );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.attributes</code> attribute.
	 * @return the attributes
	 */
	public Set<IntegrationObjectItemAttribute> getAttributes()
	{
		return getAttributes( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItem.attributes</code> attribute. 
	 * @param value the attributes
	 */
	public void setAttributes(final SessionContext ctx, final Set<IntegrationObjectItemAttribute> value)
	{
		ATTRIBUTESHANDLER.setValues( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItem.attributes</code> attribute. 
	 * @param value the attributes
	 */
	public void setAttributes(final Set<IntegrationObjectItemAttribute> value)
	{
		setAttributes( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to attributes. 
	 * @param value the item to add to attributes
	 */
	public void addToAttributes(final SessionContext ctx, final IntegrationObjectItemAttribute value)
	{
		ATTRIBUTESHANDLER.addValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to attributes. 
	 * @param value the item to add to attributes
	 */
	public void addToAttributes(final IntegrationObjectItemAttribute value)
	{
		addToAttributes( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from attributes. 
	 * @param value the item to remove from attributes
	 */
	public void removeFromAttributes(final SessionContext ctx, final IntegrationObjectItemAttribute value)
	{
		ATTRIBUTESHANDLER.removeValue( ctx, this, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from attributes. 
	 * @param value the item to remove from attributes
	 */
	public void removeFromAttributes(final IntegrationObjectItemAttribute value)
	{
		removeFromAttributes( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.code</code> attribute.
	 * @return the code
	 */
	public String getCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.code</code> attribute.
	 * @return the code
	 */
	public String getCode()
	{
		return getCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItem.code</code> attribute. 
	 * @param value the code
	 */
	public void setCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItem.code</code> attribute. 
	 * @param value the code
	 */
	public void setCode(final String value)
	{
		setCode( getSession().getSessionContext(), value );
	}
	
	@Override
	protected Item createItem(final SessionContext ctx, final ComposedType type, final ItemAttributeMap allAttributes) throws JaloBusinessException
	{
		INTEGRATIONOBJECTHANDLER.newInstance(ctx, allAttributes);
		return super.createItem( ctx, type, allAttributes );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.integrationObject</code> attribute.
	 * @return the integrationObject
	 */
	public IntegrationObject getIntegrationObject(final SessionContext ctx)
	{
		return (IntegrationObject)getProperty( ctx, INTEGRATIONOBJECT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.integrationObject</code> attribute.
	 * @return the integrationObject
	 */
	public IntegrationObject getIntegrationObject()
	{
		return getIntegrationObject( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItem.integrationObject</code> attribute. 
	 * @param value the integrationObject
	 */
	public void setIntegrationObject(final SessionContext ctx, final IntegrationObject value)
	{
		INTEGRATIONOBJECTHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItem.integrationObject</code> attribute. 
	 * @param value the integrationObject
	 */
	public void setIntegrationObject(final IntegrationObject value)
	{
		setIntegrationObject( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.root</code> attribute.
	 * @return the root
	 */
	public Boolean isRoot(final SessionContext ctx)
	{
		return (Boolean)getProperty( ctx, ROOT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.root</code> attribute.
	 * @return the root
	 */
	public Boolean isRoot()
	{
		return isRoot( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.root</code> attribute. 
	 * @return the root
	 */
	public boolean isRootAsPrimitive(final SessionContext ctx)
	{
		Boolean value = isRoot( ctx );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.root</code> attribute. 
	 * @return the root
	 */
	public boolean isRootAsPrimitive()
	{
		return isRootAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItem.root</code> attribute. 
	 * @param value the root
	 */
	public void setRoot(final SessionContext ctx, final Boolean value)
	{
		setProperty(ctx, ROOT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItem.root</code> attribute. 
	 * @param value the root
	 */
	public void setRoot(final Boolean value)
	{
		setRoot( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItem.root</code> attribute. 
	 * @param value the root
	 */
	public void setRoot(final SessionContext ctx, final boolean value)
	{
		setRoot( ctx,Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItem.root</code> attribute. 
	 * @param value the root
	 */
	public void setRoot(final boolean value)
	{
		setRoot( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.type</code> attribute.
	 * @return the type
	 */
	public ComposedType getType(final SessionContext ctx)
	{
		return (ComposedType)getProperty( ctx, TYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IntegrationObjectItem.type</code> attribute.
	 * @return the type
	 */
	public ComposedType getType()
	{
		return getType( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItem.type</code> attribute. 
	 * @param value the type
	 */
	public void setType(final SessionContext ctx, final ComposedType value)
	{
		setProperty(ctx, TYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IntegrationObjectItem.type</code> attribute. 
	 * @param value the type
	 */
	public void setType(final ComposedType value)
	{
		setType( getSession().getSessionContext(), value );
	}
	
}
