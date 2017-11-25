package com.hc.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "inHaleTime", "exHaleTime" })
public class Metrics implements Serializable { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String inHaleTime;
	private String exHaleTime;
	
	public String getInHaleTime() {
		return inHaleTime;
	}
	public void setInHaleTime(String inHaleTime) {
		this.inHaleTime = inHaleTime;
	}
	public String getExHaleTime() {
		return exHaleTime;
	}
	public void setExHaleTime(String exHaleTime) {
		this.exHaleTime = exHaleTime;
	}

}
