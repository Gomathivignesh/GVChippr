package com.hc.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "id", "cycle", "current_module","current_level","next_module","next_level","created", "lastUpdated"})
public class BreathCycle implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String currentLevel;
	private String currentModule;
	private String nextLevel;
	private String nextModule;
	private String cycle;
	private Date created;
	private Date lastUpdated;	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(String currentLevel) {
		this.currentLevel = currentLevel;
	}

	public String getCurrentModule() {
		return currentModule;
	}

	public void setCurrentModule(String currentModule) {
		this.currentModule = currentModule;
	}

	public String getNextLevel() {
		return nextLevel;
	}

	public void setNextLevel(String nextLevel) {
		this.nextLevel = nextLevel;
	}

	public String getNextModule() {
		return nextModule;
	}

	public void setNextModule(String nextModule) {
		this.nextModule = nextModule;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;		
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result	+ ((currentLevel == null) ? 0 : currentLevel.hashCode());
		result = prime * result	+ ((currentModule == null) ? 0 : currentModule.hashCode());
		result = prime * result	+ ((nextLevel == null) ? 0 : nextLevel.hashCode());
		result = prime * result	+ ((nextModule == null) ? 0 : nextModule.hashCode());
		result = prime * result + ((cycle == null) ? 0 : cycle.hashCode());		
		result = prime * result	+ ((lastUpdated == null) ? 0 : lastUpdated.hashCode());		
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BreathCycle other = (BreathCycle) obj;
		
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (currentLevel == null) {
			if (other.currentLevel != null)
				return false;
		} else if (!currentLevel.equals(other.currentLevel))
			return false;
		if (cycle == null) {
			if (other.cycle != null)
				return false;
		} else if (!cycle.equals(other.cycle))
			return false;		
		if (lastUpdated == null) {
			if (other.lastUpdated != null)
				return false;
		} else if (!lastUpdated.equals(other.lastUpdated))
			return false;		
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (currentModule == null) {
			if (other.currentModule != null)
				return false;
		} else if (!currentModule.equals(other.currentModule))
			return false;
		if (nextLevel == null) {
			if (other.nextLevel != null)
				return false;
		} else if (!nextLevel.equals(other.nextLevel))
			return false;
		if (nextModule == null) {
			if (other.nextModule != null)
				return false;
		} else if (!nextModule.equals(other.nextModule))
			return false;
		return true;
	}

}
