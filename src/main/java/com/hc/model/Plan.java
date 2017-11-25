package com.hc.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlType(propOrder = { "id", "name","duration" })
public class Plan implements Serializable {

	/**
	 * 
	 `id` int(12) unsigned NOT NULL auto_increment, 'name' varchar(100) 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	//private String description;
	private Integer duration;
	
	public Plan() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer userId) {
		this.id = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		Plan other = (Plan) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		}else if (!name.equals(other.name))
			return false; 		
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Plan [planId=" + id + ", name=" + name + "]";
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

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
