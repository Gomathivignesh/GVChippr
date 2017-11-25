package com.hc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.hc.enums.UserTypeEnums;

@XmlRootElement
@XmlType(propOrder = { "id", "fName", "mName", "lName", "dob", "gender",
		"email", "score","currentModule",
		"currentLevel", "btMorning", "btAfternoon",
		"btEvening", "sequence", "cycle", "ratio", "hcFlag",
		"calibration", "userHealthCondition", "userCourseLog", "courseReview",
		"created", "lastUpdated", "pwd", "newPwd", "inpDob", "cycleRatio",
		"metrics", "userType", "trailBeginDate", "trialEndDate",
		"subsBeginDate", "subsEndDate", "trialEndDateAsLong",
		"subsEndDateAsLong", "availableGiftCount","zoneName","height","weight","bmi" })
public class User implements Serializable {

	/**
	 * 
	 `id` int(10) unsigned NOT NULL auto_increment, `pwd` varchar(100),
	 * `email` varchar(100) NOT NULL, `fname` varchar(100) NOT NULL, `mname`
	 * varchar(32), `lname` varchar(100) NOT NULL, `dob` datetime, `gender`
	 * varchar(10), `created` datetime, `lastupdated` datetime, `currentlevel`
	 * varchar(100), `score` int(10), `startinglevel` varchar(100),
	 * `primaryhealthcondition` varchar(5), `breathingtechmorning` int(10),
	 * `breathingtechafternoon` int(10), `breathingtechevening` int(10),
	 * `sequence` decimal(10,4), `cycle` int(10), `ratio` varchar(100),
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String pwd;
	private String newPwd;
	private String email;
	private String fName;
	private String mName;
	private String lName;
	private Date dob;
	private String inpDob;
	private String gender;
	private Date created;
	private Date lastUpdated;
	private String currentLevel;
	private String currentModule;
	private Integer score;
	private Integer btMorning;
	private Integer btAfternoon;
	private Integer btEvening;
	private String sequence;
	private String cycle;
	private String ratio;
	private String hcFlag;
	private String calibration;
	private List<UserHealthCondition> userHealthCondition;
	private UserCourseLog userCourseLog;
	private CourseReview courseReview;
	private List<Metrics> cycleRatio;
	private String metrics;
	private UserTypeEnums userType;
	private Date trailBeginDate;
	private Date trialEndDate;
	private Date subsBeginDate;
	private Date subsEndDate;
	private long trialEndDateAsLong;
	private long subsEndDateAsLong;
	private int availableGiftCount;
	private String zoneName;
	private String height;
	private String weight;
	private String bmi;

	
	public User() {

	}
	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer userId) {
		this.id = userId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getInpDob() {
		return inpDob;
	}

	public void setInpDob(String inpDob) {
		this.inpDob = inpDob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
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

	public String getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(String currentLevel) {
		this.currentLevel = currentLevel;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getRatio() {
		return ratio;
	}

	public void setRatio(String ratio) {
		this.ratio = ratio;
	}

	public String getHcFlag() {
		return hcFlag;
	}

	public void setHcFlag(String hcFlag) {
		this.hcFlag = hcFlag;
	}

	public String getCalibration() {
		return calibration;
	}

	public void setCalibration(String Calibration) {
		this.calibration = Calibration;
	}

	public List<UserHealthCondition> getUserHealthCondition() {
		return userHealthCondition;
	}

	public void setUserHealthCondition(
			List<UserHealthCondition> userHealthCondition) {
		this.userHealthCondition = userHealthCondition;
	}

	public UserCourseLog getUserCourseLog() {
		return userCourseLog;
	}

	public void setUserCourseLog(UserCourseLog userCourseLog) {
		this.userCourseLog = userCourseLog;
	}

	public CourseReview getCourseReview() {
		return courseReview;
	}

	public void setCourseReview(CourseReview courseReview) {
		this.courseReview = courseReview;
	}

	public List<Metrics> getCycleRatio() {
		return cycleRatio;
	}

	public void setCycleRatio(List<Metrics> cycleRatio) {
		this.cycleRatio = cycleRatio;
	}

	public String getMetrics() {
		return metrics;
	}

	public void setMetrics(String metrics) {
		this.metrics = metrics;
	}

	public UserTypeEnums getUserType() {
		return userType;
	}

	public void setUserType(UserTypeEnums userType) {
		this.userType = userType;
	}

	public Date getTrailBeginDate() {
		return trailBeginDate;
	}

	public void setTrailBeginDate(Date trailBeginDate) {
		this.trailBeginDate = trailBeginDate;
	}

	public Date getTrialEndDate() {
		return trialEndDate;
	}

	public void setTrialEndDate(Date trialEndDate) {
		this.trialEndDate = trialEndDate;
	}

	public Date getSubsBeginDate() {
		return subsBeginDate;
	}

	public void setSubsBeginDate(Date subsBeginDate) {
		this.subsBeginDate = subsBeginDate;
	}

	public Date getSubsEndDate() {
		return subsEndDate;
	}

	public void setSubsEndDate(Date subsEndDate) {
		this.subsEndDate = subsEndDate;
	}

	public long getTrialEndDateAsLong() {
		return trialEndDateAsLong;
	}

	public void setTrialEndDateAsLong(long trialEndDateAsLong) {
		this.trialEndDateAsLong = trialEndDateAsLong;
	}

	public long getSubsEndDateAsLong() {
		return subsEndDateAsLong;
	}

	public void setSubsEndDateAsLong(long subsEndDateAsLong) {
		this.subsEndDateAsLong = subsEndDateAsLong;
	}

	public int getAvailableGiftCount() {
		return availableGiftCount;
	}

	public void setAvailableGiftCount(int availableGiftCount) {
		this.availableGiftCount = availableGiftCount;
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
		result = prime
				* result
				+ ((btAfternoon == null) ? 0 : btAfternoon.hashCode());
		result = prime
				* result
				+ ((btEvening == null) ? 0 : btEvening.hashCode());
		result = prime
				* result
				+ ((btMorning == null) ? 0 : btMorning.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result
				+ ((currentLevel == null) ? 0 : currentLevel.hashCode());
		result = prime * result + ((cycle == null) ? 0 : cycle.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((inpDob == null) ? 0 : inpDob.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result
				+ ((lastUpdated == null) ? 0 : lastUpdated.hashCode());
		result = prime * result + ((mName == null) ? 0 : mName.hashCode());
		result = prime * result + ((newPwd == null) ? 0 : newPwd.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((ratio == null) ? 0 : ratio.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result
				+ ((sequence == null) ? 0 : sequence.hashCode());
		
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((userType == null) ? 0 : userType.hashCode());

		result = prime * result
				+ ((trailBeginDate == null) ? 0 : trailBeginDate.hashCode());
		result = prime * result
				+ ((trialEndDate == null) ? 0 : trialEndDate.hashCode());
		result = prime * result
				+ ((subsBeginDate == null) ? 0 : subsBeginDate.hashCode());
		result = prime * result
				+ ((subsEndDate == null) ? 0 : subsEndDate.hashCode());
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
		User other = (User) obj;
		if (btAfternoon == null) {
			if (other.btAfternoon != null)
				return false;
		} else if (!btAfternoon.equals(other.btAfternoon))
			return false;
		if (btEvening == null) {
			if (other.btEvening != null)
				return false;
		} else if (!btEvening.equals(other.btEvening))
			return false;
		if (btMorning == null) {
			if (other.btMorning != null)
				return false;
		} else if (!btMorning.equals(other.btMorning))
			return false;
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
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (inpDob == null) {
			if (other.inpDob != null)
				return false;
		} else if (!inpDob.equals(other.inpDob))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (lastUpdated == null) {
			if (other.lastUpdated != null)
				return false;
		} else if (!lastUpdated.equals(other.lastUpdated))
			return false;
		if (mName == null) {
			if (other.mName != null)
				return false;
		} else if (!mName.equals(other.mName))
			return false;
		if (newPwd == null) {
			if (other.newPwd != null)
				return false;
		} else if (!newPwd.equals(other.newPwd))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (ratio == null) {
			if (other.ratio != null)
				return false;
		} else if (!ratio.equals(other.ratio))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (sequence == null) {
			if (other.sequence != null)
				return false;
		} else if (!sequence.equals(other.sequence))
			return false;
		
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;

		if (trailBeginDate == null) {
			if (other.trailBeginDate != null)
				return false;
		} else if (!trailBeginDate.equals(other.trailBeginDate))
			return false;

		if (trialEndDate == null) {
			if (other.trialEndDate != null)
				return false;
		} else if (!trialEndDate.equals(other.trialEndDate))
			return false;

		if (subsBeginDate == null) {
			if (other.subsBeginDate != null)
				return false;
		} else if (!subsBeginDate.equals(other.subsBeginDate))
			return false;

		if (subsEndDate == null) {
			if (other.subsEndDate != null)
				return false;
		} else if (!subsEndDate.equals(other.subsEndDate))
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
		return "User [userId=" + id + ", pwd=" + pwd + ", newPwd=" + newPwd
				+ ", email=" + email + ", fName=" + fName + ", mName=" + mName
				+ ", lName=" + lName + ", dob=" + dob + ", inpDob=" + inpDob
				+ ", gender=" + gender + ", created=" + created
				+ ", lastUpdated=" + lastUpdated + ", currentLevel="
				+ currentLevel + ",currentModule=" + currentModule + ", score=" + score + ", btMorning="
				+ btMorning + ", btAfternoon="
				+ btAfternoon + ", btEvening="
				+ btEvening + ", sequence=" + sequence + ", cycle="
				+ cycle + ", ratio=" + ratio + ", userType=" + userType
				+ ", trailBeginDate=" + trailBeginDate + ", trialEndDate="
				+ trialEndDate + ", subsBeginDate=" + subsBeginDate
				+ ", subsEndDate=" + subsEndDate + "]";
	}

	public Integer getBtMorning() {
		return btMorning;
	}

	public void setBtMorning(Integer btMorning) {
		this.btMorning = btMorning;
	}

	public Integer getBtAfternoon() {
		return btAfternoon;
	}

	public void setBtAfternoon(Integer btAfternoon) {
		this.btAfternoon = btAfternoon;
	}

	public Integer getBtEvening() {
		return btEvening;
	}

	public void setBtEvening(Integer btEvening) {
		this.btEvening = btEvening;
	}

	public String getCurrentModule() {
		return currentModule;
	}

	public void setCurrentModule(String currentModule) {
		this.currentModule = currentModule;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}
}
