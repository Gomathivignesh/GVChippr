package com.hc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.hc.enums.UserTypeEnums;

public class MaxVideoWeekNo implements Serializable {
	
	private Integer maxVideoNo;
	private Integer weekNo;
	private Integer catId;
	public Integer getMaxVideoNo() {
		return maxVideoNo;
	}
	public void setMaxVideoNo(Integer maxVideoNo) {
		this.maxVideoNo = maxVideoNo;
	}
	public Integer getWeekNo() {
		return weekNo;
	}
	public void setWeekNo(Integer weekNo) {
		this.weekNo = weekNo;
	}
	public Integer getCatId() {
		return catId;
	}
	public void setCatId(Integer catId) {
		this.catId = catId;
	}

    

   
	}
			