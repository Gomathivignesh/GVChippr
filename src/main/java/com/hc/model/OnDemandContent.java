package com.hc.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlType(propOrder = { "id", "title","screenName","description" })
public class OnDemandContent implements Serializable {

	/**
	 * 
	 `id` int(12) unsigned NOT NULL auto_increment, 'name' varchar(100) 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	//private String description;
	private String screenName;
	private String description;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OnDemandContent() {

	}

	
}
