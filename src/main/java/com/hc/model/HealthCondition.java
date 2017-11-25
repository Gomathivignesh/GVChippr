package com.hc.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/*
 *   

  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `conditions` text,
  `des` text,
  `link` text,
  `hcode` varchar(15) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `lastupdated` datetime DEFAULT NULL
 */
@XmlRootElement
@XmlType(propOrder = { "id", "conditions", "des", "link", "HCode", "created", "lastUpdated", "levellimit", "modulelimit"})
public class HealthCondition {
	private Integer id;
	private String conditions;
	private String des;
	private String link;
	private String hCode;
	private Date created;
	private Date lastUpdated;
	private String levellimit;
	private String modulelimit;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the conditions
	 */
	public String getConditions() {
		return conditions;
	}
	/**
	 * @param conditions the conditions to set
	 */
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	/**
	 * @return the des
	 */
	public String getDes() {
		return des;
	}
	/**
	 * @param des the des to set
	 */
	public void setDes(String des) {
		this.des = des;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @return the hCode
	 */
	public String getHCode() {
		return hCode;
	}
	/**
	 * @param hCode the hCode to set
	 */
	public void setHCode(String hCode) {
		this.hCode = hCode;
	}
	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * @return the lastUpdated
	 */
	public Date getLastUpdated() {
		return lastUpdated;
	}
	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hCode == null) ? 0 : hCode.hashCode());
		result = prime * result
				+ ((conditions == null) ? 0 : conditions.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((des == null) ? 0 : des.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastUpdated == null) ? 0 : lastUpdated.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HealthCondition other = (HealthCondition) obj;
		if (hCode == null) {
			if (other.hCode != null)
				return false;
		} else if (!hCode.equals(other.hCode))
			return false;
		if (conditions == null) {
			if (other.conditions != null)
				return false;
		} else if (!conditions.equals(other.conditions))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (des == null) {
			if (other.des != null)
				return false;
		} else if (!des.equals(other.des))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastUpdated == null) {
			if (other.lastUpdated != null)
				return false;
		} else if (!lastUpdated.equals(other.lastUpdated))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HealthCondition [id=" + id + ", conditions=" + conditions
				+ ", des=" + des + ", link=" + link + ", hCode=" + hCode
				+", levellimit=" + levellimit + ",moduleLimit=" + modulelimit
				+ ", created=" + created + ", lastUpdated=" + lastUpdated + "]";
	}
	public String getLevellimit() {
		return levellimit;
	}
	public void setLevellimit(String levellimit) {
		this.levellimit = levellimit;
	}
	public String getModulelimit() {
		return modulelimit;
	}
	public void setModulelimit(String modulelimit) {
		this.modulelimit = modulelimit;
	}

}
