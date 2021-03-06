/**
 * (c) Copyright 2009 TeleNav.
 *  All Rights Reserved.
 */
package com.telenav.cserver.ac.executor;

import com.telenav.cserver.framework.executor.ExecutorRequest;

/**
 * ValidateAddressRequestACEWS.java
 *
 * @author bhu@telenav.cn
 * @version 1.0 2009-7-7
 */
public class ValidateAddressRequestACEWS extends ExecutorRequest
{
	private String firstLine;
	private String lastLine;
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String country;
	private String zip;
	private String label;
	private boolean maitai;
	private String transactionId;
	private String addressSearchId;
	
	public String getAddressSearchId() {
		return addressSearchId;
	}
	public void setAddressSearchId(String addressSearchId) {
		this.addressSearchId = addressSearchId;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	/**
	 * @param firstLine the firstLine to set
	 */
	public void setFirstLine(String firstLine)
	{
		this.firstLine = firstLine;
	}
	/**
	 * @return the firstLine
	 */
	public String getFirstLine()
	{
		return firstLine;
	}
	/**
	 * @param lastLine the lastLine to set
	 */
	public void setLastLine(String lastLine)
	{
		this.lastLine = lastLine;
	}
	/**
	 * @return the lastLine
	 */
	public String getLastLine()
	{
		return lastLine;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country)
	{
		this.country = country;
	}
	/**
	 * @return the country
	 */
	public String getCountry()
	{
		return country;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip)
	{
		this.zip = zip;
	}
	/**
	 * @return the zip
	 */
	public String getZip()
	{
		return zip;
	}
	/**
	 * @param street1 the street1 to set
	 */
	public void setStreet1(String street1)
	{
		this.street1 = street1;
	}
	/**
	 * @return the street1
	 */
	public String getStreet1()
	{
		return street1;
	}
	/**
	 * @param street2 the street2 to set
	 */
	public void setStreet2(String street2)
	{
		this.street2 = street2;
	}
	/**
	 * @return the street2
	 */
	public String getStreet2()
	{
		return street2;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city)
	{
		this.city = city;
	}
	/**
	 * @return the city
	 */
	public String getCity()
	{
		return city;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state)
	{
		this.state = state;
	}
	/**
	 * @return the state
	 */
	public String getState()
	{
		return state;
	}
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public boolean isMaitai() {
        return maitai;
    }
    public void setMaitai(boolean maitai) {
        this.maitai = maitai;
    }
}
