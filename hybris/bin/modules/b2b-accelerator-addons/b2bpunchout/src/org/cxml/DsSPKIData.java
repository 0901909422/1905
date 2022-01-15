/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.12 at 07:19:30 PM EDT 
//



package org.cxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dsSPKISexp"
})
@XmlRootElement(name = "ds:SPKIData")
public class DsSPKIData {

    @XmlElement(name = "ds:SPKISexp", required = true)
    protected String dsSPKISexp;

    /**
     * Gets the value of the dsSPKISexp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsSPKISexp() {
        return dsSPKISexp;
    }

    /**
     * Sets the value of the dsSPKISexp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsSPKISexp(String value) {
        this.dsSPKISexp = value;
    }

}
