package com.hc.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


//@XmlRootElement
//@XmlType(propOrder = { "id", "name" })
public class PlanStructure implements Serializable {

	/**
	 * 
	 `id` int(12) unsigned NOT NULL auto_increment, 'name' varchar(100) 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer day;
	private Integer firstCatId;
	private Integer secondCatId;
	private Integer thirdCatId;
	private String day_desc;
	private Integer firstApproxMin;
	private Integer secondApproxMin;
	private Integer thirdApproxMin;
	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getFirstCatId() {
		return firstCatId;
	}

	public void setFirstCatId(Integer firstCatId) {
		this.firstCatId = firstCatId;
	}

	public Integer getSecondCatId() {
		return secondCatId;
	}

	public void setSecondCatId(Integer secondCatId) {
		this.secondCatId = secondCatId;
	}

	public Integer getThirdCatId() {
		return thirdCatId;
	}

	public void setThirdCatId(Integer thirdCatId) {
		this.thirdCatId = thirdCatId;
	}

	public Integer getFirstCatCount() {
		return firstCatCount;
	}

	public void setFirstCatCount(Integer firstCatCount) {
		this.firstCatCount = firstCatCount;
	}

	public Integer getSecondCatCount() {
		return secondCatCount;
	}

	public void setSecondCatCount(Integer secondCatCount) {
		this.secondCatCount = secondCatCount;
	}

	public Integer getThirdCatCount() {
		return ThirdCatCount;
	}

	public void setThirdCatCount(Integer thirdCatCount) {
		ThirdCatCount = thirdCatCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	private Integer firstCatCount;
	private Integer secondCatCount;
	private Integer ThirdCatCount;
	
	private String firstCatName;
	private String secondCatName;
	private String ThirdCatName;
	
	//private String description;
//	private Integer duration;
	
	public String getFirstCatName() {
		return firstCatName;
	}

	public void setFirstCatName(String firstCatName) {
		this.firstCatName = firstCatName;
	}

	public String getSecondCatName() {
		return secondCatName;
	}

	public void setSecondCatName(String secondCatName) {
		this.secondCatName = secondCatName;
	}

	public String getThirdCatName() {
		return ThirdCatName;
	}

	public void setThirdCatName(String thirdCatName) {
		ThirdCatName = thirdCatName;
	}

	public PlanStructure() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer userId) {
		this.id = userId;
	}

	public String getDay_desc() {
		return day_desc;
	}

	public void setDay_desc(String day_desc) {
		this.day_desc = day_desc;
	}

	public Integer getFirstApproxMin() {
		return firstApproxMin;
	}

	public void setFirstApproxMin(Integer firstApproxMin) {
		this.firstApproxMin = firstApproxMin;
	}

	public Integer getSecondApproxMin() {
		return secondApproxMin;
	}

	public void setSecondApproxMin(Integer secondApproxMin) {
		this.secondApproxMin = secondApproxMin;
	}

	public Integer getThirdApproxMin() {
		return thirdApproxMin;
	}

	public void setThirdApproxMin(Integer thirdApproxMin) {
		this.thirdApproxMin = thirdApproxMin;
	}

	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		
//		return result;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		PlanStructure other = (PlanStructure) obj;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		}else if (!name.equals(other.name))
//			return false; 		
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		
//		return true;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
//	@Override
//	public String toString() {
//		return "Plan [planId=" + id + ", name=" + name + "]";
//	}

/*	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}*/

}
