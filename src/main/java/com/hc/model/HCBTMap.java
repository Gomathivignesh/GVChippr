package com.hc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.hc.enums.UserTypeEnums;

@XmlRootElement
@XmlType(propOrder = { "id", "hcId", "btCode", "timeOfDay", 
		"created", "lastUpdated","breathTechnique"})
public class HCBTMap implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer hcId;
	private String btCode;
	private String timeOfDay;	
	private Date created;
	private Date lastUpdated;
	private String breathTechnique;
	
	public String getBreathTechnique() {
		return breathTechnique;
	}
	public void setBreathTechnique(String breathTechnique) {
		this.breathTechnique = breathTechnique;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getHcId() {
		return hcId;
	}
	public void setHcId(Integer hcId) {
		this.hcId = hcId;
	}
	public String getBtCode() {
		return btCode;
	}
	public void setBtCode(String btCode) {
		this.btCode = btCode;
	}
	public String getTimeOfDay() {
		return timeOfDay;
	}
	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}	
}
