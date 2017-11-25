package com.hc.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement
@XmlType(propOrder = { "userId", "planId", "fitnessLevel", "flexiblityType", "bodyFocus", "equipment",
		"prenatal", "isPickAplan","strengthnings" })

/*{"VideoReqObj":{
"userId":"1",
"planId":"1",
"fitnessLevel":"2",
"flexiblityType":"1",
"bodyFocus":"1",
"equipment":"1",
"prenatal":"0",
"isPickAplan":"1",
"strengthnings":"1"

}*/

public class VideoReqObj implements Serializable {
	    /**
	 * private String prenatal;

	    private String fitnessLevel;

	    private String userId;

	    private String isPickAplan;

	    private String flexiblityType;

	    private String equipment;

	    private String strengthnings;

	    private String planId;

	    private String bodyFocus;
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((prenatal == null) ? 0 : prenatal.hashCode());
		result = prime
				* result
				+ ((fitnessLevel == null) ? 0 : fitnessLevel.hashCode());
		result = prime
				* result
				+ ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((isPickAplan == null) ? 0 : isPickAplan.hashCode());
		result = prime * result
				+ ((flexiblityType == null) ? 0 : flexiblityType.hashCode());
		result = prime * result + ((equipment == null) ? 0 : equipment.hashCode());
		result = prime * result + ((strengthnings == null) ? 0 : strengthnings.hashCode());
		result = prime * result + ((planId == null) ? 0 : planId.hashCode());
		result = prime * result + ((bodyFocus == null) ? 0 : bodyFocus.hashCode());
		return result;
	}

	


	private static final long serialVersionUID = 1L;

		private String prenatal;

	    private String fitnessLevel;

	    private String userId;

	    private String isPickAplan;

	    private String flexiblityType;

	    private String equipment;

	    private String strengthnings;

	    private String planId;

	    private String bodyFocus;

	    public VideoReqObj() {

		}
	    
	    public String getPrenatal ()
	    {
	        return prenatal;
	    }

	    public void setPrenatal (String prenatal)
	    {
	        this.prenatal = prenatal;
	    }

	    public String getFitnessLevel ()
	    {
	        return fitnessLevel;
	    }

	    public void setFitnessLevel (String fitnessLevel)
	    {
	        this.fitnessLevel = fitnessLevel;
	    }

	    public String getUserId ()
	    {
	        return userId;
	    }

	    public void setUserId (String userId)
	    {
	        this.userId = userId;
	    }

	    public String getIsPickAplan ()
	    {
	        return isPickAplan;
	    }

	    public void setIsPickAplan (String isPickAplan)
	    {
	        this.isPickAplan = isPickAplan;
	    }

	    public String getFlexiblityType ()
	    {
	        return flexiblityType;
	    }

	    public void setFlexiblityType (String flexiblityType)
	    {
	        this.flexiblityType = flexiblityType;
	    }

	    public String getEquipment ()
	    {
	        return equipment;
	    }

	    public void setEquipment (String equipment)
	    {
	        this.equipment = equipment;
	    }

	    public String getStrengthnings ()
	    {
	        return strengthnings;
	    }

	    public void setStrengthnings (String strengthnings)
	    {
	        this.strengthnings = strengthnings;
	    }

	    public String getPlanId ()
	    {
	        return planId;
	    }

	    public void setPlanId (String planId)
	    {
	        this.planId = planId;
	    }

	    public String getBodyFocus ()
	    {
	        return bodyFocus;
	    }

	    public void setBodyFocus (String bodyFocus)
	    {
	        this.bodyFocus = bodyFocus;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [prenatal = "+prenatal+", fitnessLevel = "+fitnessLevel+", userId = "+userId+", isPickAplan = "+isPickAplan+", flexiblityType = "+flexiblityType+", equipment = "+equipment+", strengthnings = "+strengthnings+", planId = "+planId+", bodyFocus = "+bodyFocus+"]";
	    }
	}
			