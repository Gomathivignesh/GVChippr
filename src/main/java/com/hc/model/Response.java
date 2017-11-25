package com.hc.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.hc.payment.model.PaymentResponse;
import com.hc.vo.ContentFeedCommentVO;

@XmlRootElement
public class Response {
	private Status status;
	private User user;
	private List<HealthCondition> hc;
	private List<Courses> courses;
	private List<CourseReview> courseReviews;
	private List<PaymentInfo> paymentInfo;
	private List<UserGift> availableUserGift;
	private PaymentResponse paymentResponse;
	private List<Statistics> userStats;
	private List<HealthConditionForUser> healthCondition;
	private List<Plan> plans;
	private List<Category> cats;
	private List<Goal> goals;
	private List<PlanStructure> planStruct;
	private String onDemandtitle;
	private String screenName;
	private DashBoardData dashBoardData;
	private DashBoardDataWeekWise dashBoardDataWeekWise;
	private List<SearchData> searchDatas;
	private List<FavouritesData> favouritesData;
	private  List<InsufficentCount> icList;

	private List<ContentFeedMapper> contentFeedsMappers;
	private List<ContentFeedANDFavourriteMapper> contentFeedANDFavourriteMappers;
	
	private List<ContentFeedCommentVO> contentFeedCommentVOs;
	private Integer currentDay;
	
	private Double energyScore;
	private Double relaxScore;
	
	private Integer journeyStart;
	private Integer journeyCurrent;	
	private Integer journeyFinal;	
	
	private List<VideoResObj> setVideoResList;
	
	private List<WeekDetails2> weekList2;
	private List<WeekDetails> weekList;
	private String title;
	private String description;
	private List<WeeklyWorkOut> weeklyWorkOut;
	private List<Criteria> criteria;
	private String bmi;

	@XmlElement
	public List<ContentFeedMapper> getContentFeedsMappers() {
		return contentFeedsMappers;
	}
	public void setContentFeedsMappers(List<ContentFeedMapper> contentFeedsMappers) {
		this.contentFeedsMappers = contentFeedsMappers;
	}
	
	@XmlElement
	public List<HealthConditionForUser> getHealthCondition() {
		return healthCondition;
	}
	public void setHealthCondition(List<HealthConditionForUser> healthCondition) {
		this.healthCondition = healthCondition;
	}
	
	@XmlElement
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@XmlElement
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@XmlElement
	public List<HealthCondition> getHc() {
		return hc;
	}

	public void setHc(List<HealthCondition> hc) {
		this.hc = hc;
	}

	@XmlElement
	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

	@XmlElement
	public List<CourseReview> getCourseReviews() {
		return courseReviews;
	}

	public void setCourseReviews(List<CourseReview> courseReview) {
		this.courseReviews = courseReview;
	}

	@XmlElement
	public List<PaymentInfo> getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(List<PaymentInfo> paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public List<UserGift> getAvailableUserGift() {
		return availableUserGift;
	}

	public void setAvailableUserGift(List<UserGift> availableUserGift) {
		this.availableUserGift = availableUserGift;
	}

	@XmlElement
	public PaymentResponse getPaymentResponse() {
		return paymentResponse;
	}

	public void setPaymentResponse(PaymentResponse paymentResponse) {
		this.paymentResponse = paymentResponse;
	}

	@XmlElement
	public List<Statistics> getUserStats() {
		return userStats;
	}

	public void setUserStats(List<Statistics> userStats) {
		this.userStats = userStats;
	}
	
	@XmlElement
	public List<ContentFeedANDFavourriteMapper> getContentFeedANDFavourriteMappers() {
		return contentFeedANDFavourriteMappers;
	}
	
	public void setContentFeedANDFavourriteMappers(
			List<ContentFeedANDFavourriteMapper> contentFeedANDFavourriteMappers) {
		this.contentFeedANDFavourriteMappers = contentFeedANDFavourriteMappers;
	}
	
	public List<ContentFeedCommentVO> getContentFeedCommentVOs() {
		return contentFeedCommentVOs;
	}
	public void setContentFeedCommentVOs(
			List<ContentFeedCommentVO> contentFeedCommentVOs) {
		this.contentFeedCommentVOs = contentFeedCommentVOs;
	}
	
	@XmlElement
	public Double getEnergyScore() {
		return energyScore;
	}
	
	public void setEnergyScore(Double energyScore) {
		this.energyScore = energyScore;
	}
	
	@XmlElement
	public Double getRelaxScore() {
		return relaxScore;
	}
	
	public void setRelaxScore(Double relaxScore) {
		this.relaxScore = relaxScore;
	}
	public Integer getJourneyStart() {
		return journeyStart;
	}
	public void setJourneyStart(Integer journeyStart) {
		this.journeyStart = journeyStart;
	}
	public Integer getJourneyCurrent() {
		return journeyCurrent;
	}
	public void setJourneyCurrent(Integer journeyCurrent) {
		this.journeyCurrent = journeyCurrent;
	}
	public Integer getJourneyFinal() {
		return journeyFinal;
	}
	public void setJourneyFinal(Integer journeyFinal) {
		this.journeyFinal = journeyFinal;
	}
	@XmlElement
	public List<Plan> getPlans() {
		return plans;
	}
	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}
	public List<Goal> getGoals() {
		return goals;
	}
	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}
	public List<PlanStructure> getPlanStruct() {
		return planStruct;
	}
	public void setPlanStruct(List<PlanStructure> planStruct) {
		this.planStruct = planStruct;
	}
	public List<VideoResObj> getSetVideoResList() {
		return setVideoResList;
	}
	public void setSetVideoResList(List<VideoResObj> setVideoResList) {
		this.setVideoResList = setVideoResList;
	}
	public List<WeeklyWorkOut> getWeeklyWorkOut() {
		return weeklyWorkOut;
	}
	public void setWeeklyWorkOut(List<WeeklyWorkOut> weeklyWorkOut) {
		this.weeklyWorkOut = weeklyWorkOut;
	}
	public Integer getCurrentDay() {
		return currentDay;
	}
	public void setCurrentDay(Integer currentDay) {
		this.currentDay = currentDay;
	}
	public List<Category> getCats() {
		return cats;
	}
	public void setCats(List<Category> cats) {
		this.cats = cats;
	}
	public List<WeekDetails2> getWeekList2() {
		return weekList2;
	}
	public void setWeekList2(List<WeekDetails2> weekList2) {
		this.weekList2 = weekList2;
	}
	public List<WeekDetails> getWeekList() {
		return weekList;
	}
	public void setWeekList(List<WeekDetails> weekList) {
		this.weekList = weekList;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Criteria> getCriteria() {
		return criteria;
	}
	public void setCriteria(List<Criteria> criteria) {
		this.criteria = criteria;
	}
	public String getOnDemandtitle() {
		return onDemandtitle;
	}
	public void setOnDemandtitle(String onDemandtitle) {
		this.onDemandtitle = onDemandtitle;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public List<InsufficentCount> getIcList() {
		return icList;
	}
	public void setIcList(List<InsufficentCount> icList) {
		this.icList = icList;
	}
	public DashBoardData getDashBoardData() {
		return dashBoardData;
	}
	public void setDashBoardData(DashBoardData dashBoardData) {
		this.dashBoardData = dashBoardData;
	}
	public DashBoardDataWeekWise getDashBoardDataWeekWise() {
		return dashBoardDataWeekWise;
	}
	public void setDashBoardDataWeekWise(DashBoardDataWeekWise dashBoardDataWeekWise) {
		this.dashBoardDataWeekWise = dashBoardDataWeekWise;
	}

	public List<SearchData> getSearchDatas() {
		return searchDatas;
	}

	public void setSearchDatas(List<SearchData> searchDatas) {
		this.searchDatas = searchDatas;
	}

	public List<FavouritesData> getFavouritesData() {
		return favouritesData;
	}

	public void setFavouritesData(List<FavouritesData> favouritesData) {
		this.favouritesData = favouritesData;
	}

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}
}
