package com.hc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

import javax.sql.DataSource;

import com.hc.mapper.*;
import com.hc.model.*;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.google.gson.Gson;
import com.hc.enums.EmailTypeEnums;
import com.hc.enums.UserTypeEnums;
import com.hc.mail.SMTP;
import com.hc.util.GenericProperties;
import com.hc.util.Query;
import com.hc.util.SortBasedOnDemand;
import com.hc.util.SortVideos;
import com.hc.util.Util;
import com.hc.vo.ContentFeedCommentVO;

public class UserDao {
	private static final Logger log = Logger.getLogger(UserDao.class);
	private JdbcTemplate jdbcTemplate = null;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
	}

	/**
	 * @param email
	 * @param pwd
	 * @return
	 * @throws DataAccessException
	 */
	public List<User> getUser(String email, String pwd)
			throws DataAccessException {
		long startTime = System.currentTimeMillis();
		List<User> user = (List<User>) jdbcTemplate.query(Query.GET_USER_SQL,
				new Object[] { email, pwd }, new UserMapper());

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getUser - " + afterQuery
				+ " millseconds");
		return user;
	}

	public List<User> getFBUser(String email) throws DataAccessException {
		long startTime = System.currentTimeMillis();
		List<User> user = (List<User>) jdbcTemplate.query(Query.GET_USER_SQL_FB,
				new Object[] { email }, new UserMapper());

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getUser - " + afterQuery
				+ " millseconds");
		return user;
	}



	public List<User> getUserByEmail(String email) throws DataAccessException {
		long startTime = System.currentTimeMillis();
		@SuppressWarnings("unchecked")
		List<User> user = (List<User>) jdbcTemplate.query(
				Query.GET_USER_SQL_BY_EMAIL, new Object[] { email },
				new UserMapper());
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getUser - " + afterQuery
				+ " millseconds");
		return user;
	}

	/**
	 * @param userDetails
	 * @return
	 * @throws DataAccessException
	 * @throws ParseException
	 */
	public int addUser(User userDetails) throws DataAccessException, ParseException {
		long startTime = System.currentTimeMillis();
		Date dob = Util.formatDate(userDetails.getInpDob());
		Calendar cal = Calendar.getInstance();
		int returnVal;
		// referralId means its a gift user
	//if (!"0".equals(referralId)) {
//			cal.setTime(new Date());
//			cal.add(Calendar.YEAR, 1);
//			returnVal = jdbcTemplate.update(Query.ADD_GIFT_USER_SQL,
//					userDetails.getPwd(), userDetails.getEmail(),
//					userDetails.getfName(), userDetails.getmName(),
//					userDetails.getlName(), dob, userDetails.getGender(),
//					userDetails.getScore(), new Date(), new Date(),
//					UserTypeEnums.PAID.ordinal(), new Date(), cal.getTime());
			// update the user gift table as well
			//jdbcTemplate.update(Query.UPDATE_USER_GIFT_ON_REGIS_SQL,
				//	userDetails.getEmail(), new Date(), referralId);

		//} else {
			cal.setTime(new Date());
			cal.add(Calendar.MONTH, 1);
			returnVal = jdbcTemplate.update(Query.ADD_USER_SQL,
					userDetails.getPwd(), userDetails.getEmail(),
					userDetails.getfName(), userDetails.getmName(),
					userDetails.getlName(), dob, userDetails.getGender(),
					userDetails.getScore(), new Date(), new Date(),
					UserTypeEnums.FREE.ordinal(), new Date(),
					cal.getTime(),userDetails.getHeight(),userDetails.getWeight(),userDetails.getBmi());
	//	}
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time addUser - " + afterQuery
				+ " millseconds");
		return returnVal;
	}

	/**
	 * @param userDetails
	 * @return
	 * @throws DataAccessException
	 * @throws ParseException
	 */
	public int changePwd(User userDetails) throws DataAccessException,
			ParseException {
		long startTime = System.currentTimeMillis();
		int returnVal = jdbcTemplate.update(Query.CHG_PWD_SQL,
				userDetails.getNewPwd(), new Date(), userDetails.getEmail(),
				userDetails.getPwd());
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time changePwd - " + afterQuery
				+ " millseconds");
		return returnVal;
	}

	/**
	 * @param userDetails
	 * @return
	 * @throws DataAccessException
	 * @throws ParseException
	 */
	public List<User> getPwd(User userDetails) throws DataAccessException,
			ParseException {
		long startTime = System.currentTimeMillis();
		List<User> user = jdbcTemplate.query(Query.FGT_PWD_SQL,
				ParameterizedBeanPropertyRowMapper.newInstance(User.class),
				userDetails.getEmail());
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getPwd - " + afterQuery + " millseconds");
		return user;

	}

	/**
	 * @param userDetails
	 * @return
	 * @throws DataAccessException
	 * @throws ParseException
	 */
	public int updateUser(User userDetails) throws DataAccessException,
			ParseException {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;
		Date dob = null;
		String sql = Query.UPD_USER_SQL;
		StringBuilder sqlBuilder = new StringBuilder(250);

		sqlBuilder.append(Query.UPD_USER_SQL);

		if (userDetails.getfName() != null) {
			sqlBuilder.append(" fName = ? , ");
		}
		if (userDetails.getlName() != null) {
			sqlBuilder.append(" lName = ? , ");
		}
		if (userDetails.getInpDob() != null) {
			dob = Util.formatDate(userDetails.getInpDob());
			sqlBuilder.append(" dob = ? , ");
		}
		if (userDetails.getGender() != null) {
			sqlBuilder.append(" gender = ? ,");
		}
		if(userDetails.getHeight() != null && userDetails.getWeight() != null && userDetails.getBmi() != null){
			sqlBuilder.append(" height = ? ,weight = ?, bmi = ?,");
		}
		sqlBuilder.append(" lastupdated = ? where email = ?");
		sql = sqlBuilder.toString();

		if (userDetails.getfName() != null && userDetails.getlName() == null
				&& userDetails.getInpDob() == null
				&& userDetails.getGender() == null) {
			returnVal = jdbcTemplate.update(sql, userDetails.getfName(),
					new Date(), userDetails.getEmail());
		}
		if (userDetails.getfName() != null && userDetails.getlName() != null
				&& userDetails.getInpDob() == null
				&& userDetails.getGender() == null) {
			returnVal = jdbcTemplate.update(sql, userDetails.getfName(),
					userDetails.getlName(), new Date(), userDetails.getEmail());
		}
		if (userDetails.getfName() != null && userDetails.getlName() != null
				&& userDetails.getInpDob() != null
				&& userDetails.getGender() == null) {
			returnVal = jdbcTemplate.update(sql, userDetails.getfName(),
					userDetails.getlName(), dob, new Date(),
					userDetails.getEmail());
		}
		if (userDetails.getfName() != null && userDetails.getlName() != null
				&& userDetails.getInpDob() != null
				&& userDetails.getGender() != null &&
				userDetails.getHeight() == null && userDetails.getWeight() == null && userDetails.getBmi() == null) {
			returnVal = jdbcTemplate.update(sql, userDetails.getfName(),
					userDetails.getlName(), dob, userDetails.getGender(),
					new Date(), userDetails.getEmail());
		}
		if(userDetails.getfName() != null && userDetails.getlName() != null
				&& userDetails.getInpDob() != null
				&& userDetails.getGender() != null &&
				userDetails.getHeight() != null && userDetails.getWeight() != null && userDetails.getBmi() != null){
			returnVal = jdbcTemplate.update(sql,userDetails.getfName(),
					userDetails.getlName(), dob, userDetails.getGender(), userDetails.getHeight(),
					userDetails.getWeight(), userDetails.getBmi(),
					new Date(), userDetails.getEmail());
		}

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time updateUser - " + afterQuery
				+ " millseconds");
		return returnVal;
	}

	/**
//	 * @param userDetails
	 * @return
	 * @throws DataAccessException
	 * @throws ParseException
	 */
	public List<User> getEligibility(String email) throws DataAccessException,
			ParseException {
		long startTime = System.currentTimeMillis();
		List<User> user = jdbcTemplate.query(Query.GET_ELIGIBILITY_SQL,
				ParameterizedBeanPropertyRowMapper.newInstance(User.class),
				email);
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getEligibility - " + afterQuery
				+ " millseconds");
		return user;

	}

	/**
	 * @param userDetails
	 * @return
	 * @throws DataAccessException
	 * @throws ParseException
	 */
	public int addUserLevel(User userDetails) throws DataAccessException,
			ParseException {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;
		Gson gson = new Gson();
		String metricsJson = gson.toJson(userDetails.getCycleRatio());

		List<User> userLst = getUserFullDetails(userDetails.getEmail());
		User user = userLst.get(0);

		if (null != user && null == user.getCalibration()) {
			returnVal = jdbcTemplate.update(Query.UPD_USR_CYC_SQL,
					userDetails.getCycle(), userDetails.getRatio(),
					metricsJson, userDetails.getEmail());

			returnVal = jdbcTemplate.update(Query.ADD_USER_LEVL,
					userDetails.getEmail(), userDetails.getCycle());
		} else {
			returnVal = jdbcTemplate
					.update(Query.ADD_USER_CALIB, user.getId(),
							userDetails.getCycle(), userDetails.getRatio(),
							metricsJson);
		}

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time updateCycleRatio - " + afterQuery
				+ " millseconds");
		return returnVal;
	}

	public int updateCalibration(User userDetails) throws DataAccessException,
			ParseException {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;
		Gson gson = new Gson();
		String metricsJson = gson.toJson(userDetails.getCycleRatio());
		List<User> userLst = getUserFullDetails(userDetails.getEmail());
		User user = userLst.get(0);

		if (user == null) {
			return 0;
		}

		// Update the user info - cycle, module and level
		List<BreathCycle> breathCycleList = jdbcTemplate
				.query(Query.GET_BREATH_CYCLE_MODULE_LEVELS,
						ParameterizedBeanPropertyRowMapper
								.newInstance(BreathCycle.class), userDetails
								.getCycle());

		if (!breathCycleList.isEmpty()) {
			BreathCycle breathCycle = breathCycleList.get(0);
			returnVal = jdbcTemplate.update(Query.UPD_USR_CALIBRATION_SQL,
					userDetails.getCycle(), metricsJson,
					breathCycle.getCurrentLevel(),
					breathCycle.getCurrentModule(), userDetails.getEmail());
		}

		if (returnVal == 0) {
			return 0;
		}

		// Add an entry into the user calibration table
		returnVal = jdbcTemplate.update(Query.ADD_USER_CALIB, user.getId(),
				userDetails.getCycle(), userDetails.getRatio(), metricsJson);

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time updateCycleRatio - " + afterQuery
				+ " millseconds");
		return returnVal;
	}

	/**
	 * @param userDetails
	 * @return
	 * @throws DataAccessException
	 * @throws ParseException
	 */
	public int updateUserHC(User userDetails) throws DataAccessException,
			ParseException {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;
		String sql = Query.UPRT_HC_SQL;

		User user = getUser(userDetails);
		if (user != null) {
			List<UserHealthCondition> userHealthCondition = userDetails.getUserHealthCondition();
			boolean primaryHCFlag = false;
			if (userHealthCondition.size() > 0) {
				for (UserHealthCondition userHc : userHealthCondition) {
					returnVal = jdbcTemplate.update(sql, user.getId(),
							userHc.getHcId());
					// userHc.getHcId(), userHc.getHcValue(),
					// userHc.getHcStatus(), userHc.getHcValue());
					if (userHc.getHcValue().equals("Y") && !primaryHCFlag) {
						returnVal = jdbcTemplate.update(Query.UPD_USER_PRI_HC,
								userHc.getHcId(), userDetails.getEmail());
						primaryHCFlag = true;
					}
				}
				if (!primaryHCFlag) {
					returnVal = jdbcTemplate.update(Query.UPD_USER_PRI_HC_DEF,
							userDetails.getEmail());
				}
			}
		}

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time updateUser - " + afterQuery
				+ " millseconds");
		return returnVal;
	}

	/**
	 * @param userDetails
	 * @return
	 * @throws DataAccessException
	 * @throws ParseException
	 */
	public int insertUserCourseLog(User userDetails)
			throws DataAccessException, ParseException {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;
		String sql = Query.ADD_USERLOG_SQL;
		int courseScore = 0;
		User user = getUser(userDetails);
		if (user != null) {
			UserCourseLog userCourseLog = userDetails.getUserCourseLog();
			SystemPreferenceInfo systemPreference = getSystemPreference();
			// TODO: if the score >=10 then we set the score to 10 else we set
			// it to 0
			courseScore = 0;
			if (userCourseLog.getCourseDuration() >= systemPreference
					.getCourseDuration()) {
				courseScore = (int) systemPreference.getCourseDuration();
			}
			// Get the latest user level
			UserLevel userLevel = getUserLatestLevel(userDetails.getEmail());
			if (userCourseLog != null) {
				returnVal = jdbcTemplate.update(sql, user.getId(),
						userCourseLog.getLoginDateTime(),
						userCourseLog.getLogoutDateTime(),
						userCourseLog.getStartTime(),
						userCourseLog.getEndTime(),
						userCourseLog.getCourseId(),
						userCourseLog.getCourseDuration(),
						userCourseLog.getIpAddress(),
						userCourseLog.getInhaleTime(),
						userCourseLog.getExhaleTime(),
						userCourseLog.getRetentionTime(),
						userCourseLog.getCourseBucket(),
						userCourseLog.getDeviceName(), userCourseLog.getBtId(),
						courseScore, userLevel.getCurrentModule(),
						userLevel.getCurrentLevel());
			}
		}

		returnVal = updateUserLevel(userDetails);

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time updateUser - " + afterQuery
				+ " millseconds");
		return returnVal;
	}

	public int insertUserCourseLog_V1(User userDetails)
			throws DataAccessException, ParseException {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;
		String sql = Query.ADD_USERLOG_SQL;
		int courseScore = 0;
		List<User> userList = getUserByEmail(userDetails.getEmail());
		if (userList.isEmpty()) {
			return 0;
		}

		User user = userList.get(0);
		UserCourseLog userCourseLog = null;
		if (user != null) {
			userCourseLog = userDetails.getUserCourseLog();
			SystemPreferenceInfo systemPreference = getSystemPreference();
			// TODO: if the score >=10 then we set the score to 10 else we set
			// it to 0
			courseScore = 0;
			if (userCourseLog.getCourseDuration() >= systemPreference
					.getCourseDuration()) {
				courseScore = (int) systemPreference.getIncrement();
			}

			if (userCourseLog != null) {
				returnVal = jdbcTemplate.update(sql, user.getId(),
						userCourseLog.getLoginDateTime(),
						userCourseLog.getLogoutDateTime(),
						userCourseLog.getStartTime(),
						userCourseLog.getEndTime(),
						userCourseLog.getCourseId(),
						userCourseLog.getCourseDuration(),
						userCourseLog.getIpAddress(),
						userCourseLog.getInhaleTime(),
						userCourseLog.getExhaleTime(),
						userCourseLog.getRetentionTime(),
						userCourseLog.getCourseBucket(),
						userCourseLog.getDeviceName(), courseScore,
						user.getCurrentModule(), user.getCurrentLevel());
			}
		}

		if (user.getUserType().equals(UserTypeEnums.PAID)) {
			int points = 0;
			SystemPreferenceInfo systemPreference = getSystemPreference();
			if (userCourseLog.getCourseDuration() > systemPreference
					.getCourseDuration()) {
				points = (int) systemPreference.getIncrement();
			}
			int newScore = user.getScore() != null ? user.getScore() + points
					: points;
			if (newScore > systemPreference.getPromoteScore()) {
				// Fetch the next level and module and update and update it on
				// the user
				user.setScore(0);
				List<BreathCycle> breathCycleList = jdbcTemplate.query(
						Query.GET_BREATH_CYCLE,
						ParameterizedBeanPropertyRowMapper
								.newInstance(BreathCycle.class), user
								.getCurrentLevel(), user.getCurrentModule());

				if (!breathCycleList.isEmpty()) {
					BreathCycle breathCycle = breathCycleList.get(0);
					returnVal = jdbcTemplate.update(
							Query.UPD_USER_SCORE_AND_LEVEL, 0,
							breathCycle.getNextLevel(),
							breathCycle.getNextModule(), user.getEmail());
				}
			} else {
				user.setScore(newScore);
				returnVal = jdbcTemplate.update(Query.UPD_USER_SCORE, newScore,
						user.getEmail());
			}
		}

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time updateUser - " + afterQuery
				+ " millseconds");
		return returnVal;
	}

	public int insertCourseReview(User userDetails) throws DataAccessException,
			ParseException {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;
		String sql = Query.ADD_COURSEREV_SQL;

		User user = getUser(userDetails);

		if (user != null) {
			CourseReview userCourseReview = userDetails.getCourseReview();
			if (userCourseReview != null) {
				returnVal = jdbcTemplate.update(sql, user.getId(),
						userCourseReview.getCourseId(),
						userCourseReview.getfName(),
						userCourseReview.getlName(),
						userCourseReview.getFeedback(),
						userCourseReview.getRatings());
			}
		}
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time insertCourseReview - " + afterQuery
				+ " millseconds");
		return returnVal;
	}

	private User getUser(User userDetails) {
		User currentUser = null;
		List<User> user = jdbcTemplate.query(Query.USER_ID_SQL,
				ParameterizedBeanPropertyRowMapper.newInstance(User.class),
				userDetails.getEmail());
		if (user != null && user.size() > 0) {
			currentUser = user.get(0);
		}
		return currentUser;
	}

	public SystemPreferenceInfo getSystemPreference()
			throws DataAccessException {
		long startTime = System.currentTimeMillis();

		SystemPreferenceInfo systemPreference = (SystemPreferenceInfo) jdbcTemplate
				.queryForObject(Query.GET_SYS_PREFERENCE,
						ParameterizedBeanPropertyRowMapper
								.newInstance(SystemPreferenceInfo.class));

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getCourses - " + afterQuery
				+ " millseconds");
		return systemPreference;
	}

	/**
//	 * @param userDetails
	 * @return
	 * @throws DataAccessException
	 * @throws ParseException
	 */
	public List<Courses> getCourses(String email) throws DataAccessException,
			ParseException {
		long startTime = System.currentTimeMillis();

		// If trial user then cycle the value of M,A,E based on the
		// systemPreference table values
		List<User> userList = getUserByEmail(email);
		if (userList.size() == 0) {
			return null;
		}

		User user = userList.get(0);
		if (user.getUserType().equals(UserTypeEnums.FREE)) {
			updateUserBreathSeq(user, true, true, true);
		}

		UserLevel userLevel = getUserLatestLevel(email);

		List<Courses> courses = jdbcTemplate.query(Query.GET_COURSE_DTS_SQL,
				ParameterizedBeanPropertyRowMapper.newInstance(Courses.class),
				userLevel.getId(), email);

		// Missing some or all of the courses. Looping to find app courses.
		if (user.getUserType().equals(UserTypeEnums.FREE)
				&& courses.size() != 3) {
			boolean missingMorCourse = false, missingAftCourse = false, missingEveCourse = false;
			for (Courses course : courses) {
				if (course.getCourseDay().equalsIgnoreCase("m")) {
					missingMorCourse = true;
				}
				if (course.getCourseDay().equalsIgnoreCase("a")) {
					missingAftCourse = true;
				}
				if (course.getCourseDay().equalsIgnoreCase("e")) {
					missingEveCourse = true;
				}
			}

			// loop it twice to see if we can find any other course
			for (int i = 0; i < 2; i++) {
				updateUserBreathSeq(user, !missingMorCourse, !missingAftCourse,
						!missingEveCourse);
				List<Courses> dirtyFetchCourses = jdbcTemplate.query(
						Query.GET_COURSE_DTS_SQL,
						ParameterizedBeanPropertyRowMapper
								.newInstance(Courses.class), userLevel.getId(),
						email);
				for (Courses course : dirtyFetchCourses) {
					if ((course.getCourseDay().equalsIgnoreCase("m") && !missingMorCourse)
							|| (course.getCourseDay().equalsIgnoreCase("a") && !missingAftCourse)
							|| (course.getCourseDay().equalsIgnoreCase("e") && !missingEveCourse)) {
						courses.add(course);
					}
					if (courses.size() == 3) {
						break;
					}
				}
				if (courses.size() == 3) {
					break;
				}
			}
		}
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getCourses - " + afterQuery
				+ " millseconds");
		return courses;

	}

	private void updateUserBreathSeq(User user, boolean updateMor,
			boolean updateAft, boolean updateEve) {
		SystemPreferenceInfo systemPreference = getSystemPreference();

		if (updateMor) {
			if (user.getBtMorning() < systemPreference.getFreeUserSequencesM()) {
				user.setBtMorning(user.getBtMorning() + 1);
			} else {
				user.setBtMorning(1);
			}
		}

		if (updateAft) {
			if (user.getBtAfternoon() < systemPreference
					.getFreeUserSequencesA()) {
				user.setBtAfternoon(user.getBtAfternoon() + 1);
			} else {
				user.setBtAfternoon(1);
			}
		}

		if (updateEve) {
			if (user.getBtEvening() < systemPreference.getFreeUserSequencesE()) {
				user.setBtEvening(user.getBtEvening() + 1);
			} else {
				user.setBtEvening(1);
			}
		}
		jdbcTemplate.update(
				Query.UPDATE_TRIAL_USER_BREATHE_LEVEL,
				new Object[] { user.getBtMorning(), user.getBtAfternoon(),
						user.getBtEvening(), user.getEmail() });
	}

	private UserLevel getUserLatestLevel(String email) {
		UserLevel userLevel = jdbcTemplate
				.queryForObject(Query.GET_USER_LEVL_LST,
						ParameterizedBeanPropertyRowMapper
								.newInstance(UserLevel.class), email);
		return userLevel;
	}

	/**
//	 * @param userDetails
	 * @return
	 * @throws DataAccessException
	 * @throws ParseException
	 */
	public List<Sequence> getCoursesWithBreathSeq(String email)
			throws DataAccessException, ParseException {
		long startTime = System.currentTimeMillis();

		UserLevel userLevel = getUserLatestLevel(email);

		List<Sequence> sequences = jdbcTemplate.query(Query.GET_USER_BRTH_SEQ,
				ParameterizedBeanPropertyRowMapper.newInstance(Sequence.class),
				userLevel.getId(), email);
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getCourses - " + afterQuery
				+ " millseconds");
		return sequences;

	}

	/**
//	 * @param userDetails
	 * @return
	 * @throws DataAccessException
	 * @throws ParseException
	 */
	public List<Courses> getCoursesDesc(String id) throws DataAccessException,
			ParseException {
		long startTime = System.currentTimeMillis();
		List<Courses> courses = jdbcTemplate.query(Query.GET_COURSES_SQL,
				ParameterizedBeanPropertyRowMapper.newInstance(Courses.class),
				id);
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getCoursesDesc - " + afterQuery
				+ " millseconds");
		return courses;

	}

	/**
//	 * @param userDetails
	 * @return
	 * @throws DataAccessException
	 * @throws ParseException
	 */
	public List<CourseReview> getCourseReview(String courseId)
			throws DataAccessException, ParseException {
		long startTime = System.currentTimeMillis();

		List<CourseReview> reviews = jdbcTemplate.query(Query.GET_REVIEWS_SQL,
				ParameterizedBeanPropertyRowMapper
						.newInstance(CourseReview.class), courseId);
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getCourses - " + afterQuery
				+ " millseconds");
		return reviews;

	}

	/**
	 * @param email
	 * @return
	 * @throws DataAccessException
	 */
	public List<User> getUserFullDetails(String email)
			throws DataAccessException {
		long startTime = System.currentTimeMillis();
		List<User> user = jdbcTemplate.query(Query.GET_USER_FULL_SQL,
				ParameterizedBeanPropertyRowMapper.newInstance(User.class),
				email);
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getUser - " + afterQuery
				+ " millseconds");
		return user;
	}

	/**
//	 * @param email
	 * @return
	 * @throws DataAccessException
	 */
	public List<UserLevel> getUserLevel(String userId)
			throws DataAccessException {
		long startTime = System.currentTimeMillis();
		List<UserLevel> userLevel = jdbcTemplate
				.query(Query.GET_USER_LEVL, ParameterizedBeanPropertyRowMapper
						.newInstance(UserLevel.class), userId);
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getUser - " + afterQuery
				+ " millseconds");
		return userLevel;
	}

	/**
	 * @param userDetails
	 * @return
	 * @throws DataAccessException
	 * @throws ParseException
	 */
	public int updateUserLevel(User userDetails) throws DataAccessException,
			ParseException {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;

		UserCourseLog userCourseLog = userDetails.getUserCourseLog();
		User user = getUser(userDetails);

		if (user != null) {
			int points = 0;
			List<Courses> course = getCoursesDesc(userCourseLog.getCourseId()
					.toString());
			if (course != null && course.size() > 0) {
				Courses currentCourse = course.get(0);
				SystemPreferenceInfo systemPreference = getSystemPreference();
				if (userCourseLog.getCourseDuration() > systemPreference
						.getCourseDuration()) {
					points = (int) systemPreference.getCourseDuration();
				}
				// Update the usercourse log module and level based on teh score
				List<User> currentUserLst = getUserFullDetails(userDetails
						.getEmail());

				User currUser = null;
				if (currentUserLst != null && currentUserLst.size() > 0) {
					currUser = currentUserLst.get(0);
				}
				int newScore = currUser.getScore() != null ? currUser
						.getScore() + points : points;

				if (newScore > 50) {
					returnVal = jdbcTemplate.update(
							Query.ADD_USER_LEVL_COUR_UPD, user.getId(),
							currentCourse.getNextModule(), null,
							currentCourse.getNextLevel(), null,
							userCourseLog.getCourseDuration(), points);
				} else {
					returnVal = jdbcTemplate.update(
							Query.ADD_USER_LEVL_COUR_UPD, user.getId(),
							currentCourse.getModule(),
							currentCourse.getNextModule(),
							currentCourse.getLevel(),
							currentCourse.getNextLevel(),
							userCourseLog.getCourseDuration(), points);
				}
			}

			if (returnVal == 1) {
				User updateUser = new User();
				List<User> currentUserLst = getUserFullDetails(userDetails
						.getEmail());

				if (currentUserLst != null && currentUserLst.size() > 0) {
					User currUser = currentUserLst.get(0);
					System.err.println("1----" + userCourseLog.getCourseId()
							+ " " + userCourseLog.getBtId() + " ");
					SequenceMapping sequenceMapping = getHealthMap(
							userCourseLog.getCourseId(),
							userCourseLog.getBtId());

					int mSeq = currUser.getBtMorning();
					mSeq = mSeq + 1;

					int aSeq = currUser.getBtAfternoon();
					aSeq = aSeq + 1;

					int eSeq = currUser.getBtEvening();
					eSeq = eSeq + 1;

					if (mSeq > sequenceMapping.getmSequence()) {
						updateUser.setBtMorning(1);
					} else if (sequenceMapping.getmSequence() != 0
							&& mSeq <= sequenceMapping.getmSequence()) {
						updateUser.setBtMorning(mSeq);
					}

					if (aSeq > sequenceMapping.getaSequence()) {
						updateUser.setBtAfternoon(1);
					} else if (sequenceMapping.getaSequence() != 0
							&& aSeq <= sequenceMapping.getaSequence()) {
						updateUser.setBtAfternoon(aSeq);
					}

					if (eSeq > sequenceMapping.geteSequence()) {
						updateUser.setBtEvening(1);
					} else if (sequenceMapping.geteSequence() != 0
							&& eSeq <= sequenceMapping.geteSequence()) {
						updateUser.setBtEvening(eSeq);
					}

					int newScore = currUser.getScore() != null ? currUser
							.getScore() + points : points;
					if (updateUser.getBtMorning() != null) {
						updateUser.setScore(newScore);
						returnVal = jdbcTemplate.update(
								Query.UPD_USER_SCORE_MSEQ,
								updateUser.getScore(),
								updateUser.getBtMorning(),
								userDetails.getEmail());
					}
					if (updateUser.getBtAfternoon() != null) {
						updateUser.setScore(newScore);
						returnVal = jdbcTemplate.update(
								Query.UPD_USER_SCORE_ASEQ,
								updateUser.getScore(),
								updateUser.getBtAfternoon(),
								userDetails.getEmail());
					}
					if (updateUser.getBtEvening() != null) {
						updateUser.setScore(newScore);
						returnVal = jdbcTemplate.update(
								Query.UPD_USER_SCORE_ESEQ,
								updateUser.getScore(),
								updateUser.getBtEvening(),
								userDetails.getEmail());
					}
					if (newScore > 50) {
						returnVal = jdbcTemplate.update(
								Query.UPD_USER_SCORE_RESET,
								userDetails.getEmail());
					}
				}

			}
		}

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time updateCycleRatio - " + afterQuery
				+ " millseconds");
		return returnVal;
	}

	private SequenceMapping getHealthMap(Integer courseId, String id) {
		SequenceMapping sequenceMapping = jdbcTemplate.queryForObject(
				Query.GET_HLTH_MAP, ParameterizedBeanPropertyRowMapper
						.newInstance(SequenceMapping.class), id, courseId);
		return sequenceMapping;
	}

	public int updateUserSubscription(User userDetails)
			throws DataAccessException, ParseException {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;
		// Get the corresponding user
		List<User> userList = getUserByEmail(userDetails.getEmail());
		if (userList.size() == 0) {
			return returnVal;
		}

		User user = userList.get(0);
		Date newSubsEndDate = null, newSubsStartDate = null;
		Calendar cal = Calendar.getInstance();
		String subject = "";
		if (UserTypeEnums.FREE.equals(user.getUserType())) {
			newSubsStartDate = new Date();
			newSubsEndDate = new Date();
			if (userDetails.getAvailableGiftCount() > 0) {
				// email about subscription update and also gift info
				subject = "Trial to PAID user. Info about gift as well";
			} else {
				// email about subscription update only
				subject = "Trial to PAID user only.";
			}
		} else {
			newSubsStartDate = user.getSubsBeginDate();
			newSubsEndDate = user.getSubsEndDate();
			if (userDetails.getAvailableGiftCount() > 0) {
				// email about subscription update and also gift info
				subject = "PAID user subscription update. Info about gift as well";
			} else {
				// email about subscription update only
				subject = "PAID user subscription update only.";
			}
		}
		new Thread(new SMTP(user.getEmail(), subject, "Email body goes here"))
				.start();
		cal.setTime(newSubsEndDate);
		cal.add(Calendar.YEAR, 1);

		returnVal = jdbcTemplate.update(Query.UPD_USER_SUBSCRIPTION_SQL,
				UserTypeEnums.PAID.ordinal(), new Date(), newSubsStartDate,
				cal.getTime(), userDetails.getEmail());

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time update subscription - " + afterQuery
				+ " millseconds");
		return returnVal;
	}

	public int addUserGift(UserGift userGift, String email)
			throws DataAccessException, ParseException {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;

		returnVal = jdbcTemplate.update(Query.ADD_USER_GIFT_SQL, email,
				userGift.getAmount(), new Date());

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time add user gift information - "
				+ afterQuery + " millseconds");
		return returnVal;
	}

	public int addPaymentInformation(PaymentInfo payment)
			throws DataAccessException, ParseException {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;

		returnVal = jdbcTemplate.update(Query.ADD_PAYMENT_INFO_SQL,
				payment.getEmailId(), payment.getPurchaseMethod().ordinal(),
				payment.getPaymentType().ordinal(), payment.getBilledAmount(),
				payment.getTransactionId(), payment.getOtherDetails(),
				new Date(), new Date());

		if (payment.getGiftAmount() > 0) {
			for (int i = 0; i < payment.getGiftAmount() / 10; i++) {
				UserGift userGift = new UserGift();
				userGift.setAmount(10);
				addUserGift(userGift, payment.getEmailId());
			}
		}

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time add payment information - " + afterQuery
				+ " millseconds");
		return returnVal;
	}

	public int addGiftPurchaseInformation(GiftPurchaseInfoHistory giftInfo)
			throws DataAccessException, ParseException {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;

		returnVal = jdbcTemplate.update(Query.ADD_GIFT_PURCHASE_INFO_SQL,
				giftInfo.getEmailId(), giftInfo.getAnnualSubscription(),
				giftInfo.getNoOfOrders(), giftInfo.getGiftSubscription(),
				giftInfo.getBonusSubscription(), giftInfo.getAmountDue(),
				new Date(), new Date(), giftInfo.getTransactionId());

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time add gift purchase information - "
				+ afterQuery + " millseconds");
		return returnVal;
	}

	public List<PaymentInfo> getPaymentHistory(User user)
			throws DataAccessException, ParseException {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;
		String emailId = user.getEmail();
		List<PaymentInfo> paymentInfo = (List<PaymentInfo>) jdbcTemplate.query(
				Query.GET_PAYMENT_HISTORY_SQL, new Object[] { emailId },
				new PaymentHistoryMapper());

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time add payment information - " + afterQuery
				+ " millseconds");
		return paymentInfo;
	}

	public int sendUserGift(String sendTo, int sentFrom, String token)
			throws DataAccessException, ParseException {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;
		returnVal = jdbcTemplate.update(Query.UPDATE_USER_GIFT_SQL, sendTo,
				new Date(), token, sentFrom);

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time send gift - " + afterQuery
				+ " millseconds");
		return returnVal;
	}

	public List<UserGift> getAvailableUserGift(int id) {
		long startTime = System.currentTimeMillis();

		List<UserGift> userGift = jdbcTemplate.query(Query.GET_GIFT_AVAILABLE,
				new Object[] { id }, new BeanPropertyRowMapper(UserGift.class));
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time get available gift - " + afterQuery
				+ " millseconds");
		return userGift;
	}

	public List<UserGift> getPendingUserGift(int id) {
		long startTime = System.currentTimeMillis();

		List<UserGift> userGift = jdbcTemplate.query(
				Query.GET_PENDING_GIFT_AVAILABLE, new Object[] { id },
				new BeanPropertyRowMapper(UserGift.class));
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time get pending gift - " + afterQuery
				+ " millseconds");
		return userGift;
	}

	public List<UserGift> getProcessedUserGift(int id) {
		long startTime = System.currentTimeMillis();

		List<UserGift> userGift = jdbcTemplate.query(
				Query.GET_PROCESSED_GIFT_AVAILABLE, new Object[] { id },
				new BeanPropertyRowMapper(UserGift.class));
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time get processed gift - " + afterQuery
				+ " millseconds");
		return userGift;
	}

	public int isGiftTokenValid(String token) {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;
		returnVal = jdbcTemplate.queryForInt(Query.VALID_USER_GIFT_TOKEN_SQL,
				new Object[] { token });

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time get available gift - " + afterQuery
				+ " millseconds");
		return returnVal;
	}

	public List<ResetPassword> getPendingResetPassword(int id) {
		long startTime = System.currentTimeMillis();

		List<ResetPassword> resetPassword = jdbcTemplate.query(
				Query.GET_PENDING_RESET_PWD_TOKEN_SQL,
				ParameterizedBeanPropertyRowMapper
						.newInstance(ResetPassword.class), id);
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time get available gift - " + afterQuery
				+ " millseconds");
		return resetPassword;
	}

	public int addResetPwdToken(int id, String token) {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;
		returnVal = jdbcTemplate.update(Query.ADD_RESET_PWD_TOKEN_SQL, id,
				new Date(), token);

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time add reset password token - "
				+ afterQuery + " millseconds");
		return returnVal;
	}

	public int updatePasswordToken(ResetPassword resetPassword) {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;
		returnVal = jdbcTemplate.update(Query.RESET_PWD_SQL, new Date(),
				resetPassword.getResetToken());

		int userId = jdbcTemplate.queryForInt(
				Query.GET_USER_ID_RESET_TOKEN_SQL,
				new Object[] { resetPassword.getResetToken() });

		// reset the user password
		jdbcTemplate.update(Query.UPDATE_PWD_SQL, resetPassword.getPwd(),
				new Date(), userId);

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time add reset password token - "
				+ afterQuery + " millseconds");
		return returnVal;
	}

	public List<Statistics> getUserStats(final String email) {
		long startTime = System.currentTimeMillis();
		User userDetails = new User();
		userDetails.setEmail(email);

		User user = getUser(userDetails);
		List<Statistics> stats = Collections.emptyList();
		if (null != user) {
			stats = jdbcTemplate.query(Query.GET_USER_STATS,
					ParameterizedBeanPropertyRowMapper
							.newInstance(Statistics.class), user.getId(), user
							.getId());

			String module = null;
			String level = null;
			for (Statistics s : stats) {
				s.setMileStoneCrossed(false);
				if (null != module && !module.equals(s.getModule())) {
					s.setMileStoneCrossed(true);
				}
				if (null != level && !level.equals(s.getLevel())) {
					s.setMileStoneCrossed(true);
				}
				module = s.getModule();
				level = s.getLevel();
			}
		}
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time get user stats - " + afterQuery
				+ " millseconds");
		return stats;
	}

	/*
	 * public List<HealthCondition> getUserHealthConditions(String email) { long
	 * startTime = System.currentTimeMillis();
	 * 
	 * List<HealthCondition> healthConditionList =
	 * jdbcTemplate.query(Query.GET_USER_HEATH_CONDITION_SQL,
	 * ParameterizedBeanPropertyRowMapper.newInstance(HealthCondition.class),
	 * email); long afterQuery = System.currentTimeMillis() - startTime;
	 * log.info("Query Execution time get user health condition - " + afterQuery
	 * + " millseconds"); return healthConditionList; }
	 */

	public List<HealthConditionForUser> getUserHealthConditions(int userId) {
		long startTime = System.currentTimeMillis();

		/*
		 * List<HealthConditionForUser> healthConditionList =
		 * jdbcTemplate.query(Query.GET_ALL_HEALTH_CONDITIONS,
		 * ParameterizedBeanPropertyRowMapper
		 * .newInstance(HealthConditionForUser.class), userId);
		 */
		List<HealthConditionForUser> healthConditionList = jdbcTemplate.query(
				Query.GET_ALL_HEALTH_CONDITIONS, new Object[] { userId },
				new UserHealthConditionMapper());
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time get user health condition - "
				+ afterQuery + " millseconds");
		return healthConditionList;
	}

	public void deleteUserHealthConditions(int userId) {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;

		returnVal = jdbcTemplate.update(Query.DELETE_USER_HEALTH_CONDITINS,
				userId);

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time add gift purchase information - "
				+ afterQuery + " millseconds");
	}

	public int addUserHealthConditions(int userId, int healthConditionCode)
			throws DataAccessException, ParseException {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;

		returnVal = jdbcTemplate.update(Query.ADD_USER_HC_SQL, userId,
				healthConditionCode);

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time for add user health condition - "
				+ afterQuery + " millseconds");
		return returnVal;
	}

	public int getDefaultHealthConditionId() {
		long startTime = System.currentTimeMillis();
		int defaultHealthConditionId = jdbcTemplate
				.queryForInt(Query.GET_DEF_HEALTH_CONDITIONS);
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time get default health condition id- "
				+ afterQuery + " millseconds");
		return defaultHealthConditionId;
	}

	public int addEmailArchive(Integer userId, String recipients,
			String subject, String body, EmailTypeEnums emailType) {
		int returnVal = 0;
		long startTime = System.currentTimeMillis();
		returnVal = jdbcTemplate.update(Query.ADD_EMAIL_ARCHIVE_SQL, userId,
				recipients, emailType.ordinal(), subject, body);
		long afterQuery = System.currentTimeMillis() - startTime;
		return returnVal;
	}

	public List<HealthCondition> getUserHealthConditions(String email) {
		long startTime = System.currentTimeMillis();

		List<HealthCondition> healthConditionList = jdbcTemplate.query(
				Query.GET_USER_HEATH_CONDITION_SQL,
				ParameterizedBeanPropertyRowMapper
						.newInstance(HealthCondition.class), email);
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time get user health condition - "
				+ afterQuery + " millseconds");
		return healthConditionList;
	}

	public List<HCBTMap> getHealthConditionBtMap(List<Integer> healthConditionId) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", healthConditionId);
		return namedParameterJdbcTemplate.query(Query.GET_USER_BT, parameters,
				ParameterizedBeanPropertyRowMapper.newInstance(HCBTMap.class));
	}

	public List<String> getExclusionBtCodes(List<Integer> healthConditionId,
			String moduleLimit, String levelLimit) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", healthConditionId);
		parameters.addValue("moduleLimit", moduleLimit);
		parameters.addValue("levelLimit", levelLimit);
		List<Map<String, Object>> exclusionMapList = namedParameterJdbcTemplate
				.queryForList(Query.GET_HEALTHCONDITIONS_EXCLUSION, parameters);
		List<String> exclusionList = new ArrayList<String>();
		for (Map<String, Object> exclusionMap : exclusionMapList) {
			exclusionList.add((String) exclusionMap.get("btCode"));
		}
		return exclusionList;
	}

	public List<Courses> getCourses(List<String> healthConditionId,
			String module, String level) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", healthConditionId);
		parameters.addValue("module", module);
		parameters.addValue("level", level);
		return namedParameterJdbcTemplate.query(Query.GET_BREATHING_MODULES,
				parameters,
				ParameterizedBeanPropertyRowMapper.newInstance(Courses.class));
	}

	public List<ContentFeedANDFavourrite> getContentFeedByCategoryDAO(
			String email) {
		List<ContentFeedANDFavourrite> contentFeedList = jdbcTemplate.query(
				Query.GET_ALL_CONTENT_FEEDS, ParameterizedBeanPropertyRowMapper
						.newInstance(ContentFeedANDFavourrite.class), email);
		System.out.println("--->" + contentFeedList.size());
		log.info("Query Execution - get all content feed -size "
				+ contentFeedList.size());

		return contentFeedList;
	}

	public List<ContentFeedANDFavourrite> getContentFeedByFavoriteDAO(
			String email) {
		List<ContentFeedANDFavourrite> contentFeedList = jdbcTemplate.query(
				Query.GET_FAVORITE_CONTENT_FEEDS_BY_EMAIL,
				ParameterizedBeanPropertyRowMapper
						.newInstance(ContentFeedANDFavourrite.class), email);
		log.info("Query Execution - get all content feed -size "
				+ contentFeedList.size());
		return contentFeedList;
	}

	public int saveFavoriteDAO(String email, Integer contentFeedTypeId) {
		log.info("in side saveFavoriteDAO : : email:" + email
				+ "  :contentFeedTypeId: " + contentFeedTypeId);

		List<ContentFeedFavourite> contentFeedFavourites = jdbcTemplate.query(
				Query.SAVE_FAVORITE_BY_EMAIL_FID_VALIDATION,
				ParameterizedBeanPropertyRowMapper
						.newInstance(ContentFeedFavourite.class),
				contentFeedTypeId, email);
		if (contentFeedFavourites != null && contentFeedFavourites.size() > 0) {
			return 0;
		}

		int result = jdbcTemplate.update(Query.SAVE_FAVORITE_BY_EMAIL_FID,
				contentFeedTypeId, email);
		if (result > 0) {
			ContentFeedFavourite contentFeedFavourite = jdbcTemplate
					.queryForObject(
							Query.SAVE_FAVORITE_BY_EMAIL_FID_VALIDATION,
							ParameterizedBeanPropertyRowMapper
									.newInstance(ContentFeedFavourite.class),
							contentFeedTypeId, email);
			System.out.println("contentFeedFavourite-->id::"
					+ contentFeedFavourite.getId());
			return contentFeedFavourite.getId();
		}
		return 0;
	}

	public int deleteFavoriteDAO(Integer contentFeedFavouriteId) {
		log.info("in side deleteFavoriteDAO :  :contentFeedFavouriteId: "
				+ contentFeedFavouriteId);
		return jdbcTemplate.update(Query.DELETE_FAVORITE_BY_EMAIL_FID,
				contentFeedFavouriteId);
	}

	// 2015-07-26
	public int saveContentFeddCommentDAO(ContentFeedComment contentFeedComment)
			throws DataAccessException, ParseException {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;
		User userTemp = new User();
		userTemp.setEmail(contentFeedComment.getEmailId());
		User user = getUser(userTemp);// if user id available no need to hit the
										// db here
		// transaction is required
		if (user != null) {
			returnVal = jdbcTemplate.update(Query.SAVE_CONTENT_FEED_COMMENT,
					user.getId(), contentFeedComment.getEmailId(),
					contentFeedComment.getContentFeedId(),
					contentFeedComment.getFirstName(),
					contentFeedComment.getLastName(),
					contentFeedComment.getCommentText(),
					contentFeedComment.getRatings(), new Date(), new Date());

			System.out.println(returnVal
					+ "--inside saveContentFeddCommentDAO<-returnVal");
			if (returnVal > 0) {
				returnVal = jdbcTemplate.update(
						Query.UPDATE_CONTENT_FEED_COMMENT_IN_MAIN_FEED,
						contentFeedComment.getRatings(),
						contentFeedComment.getContentFeedId());
				System.out.println(returnVal + "--inside iff<-returnVal");
			}
		}
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time insertCourseReview - " + afterQuery
				+ " millseconds");
		return returnVal;
	}

	// 2015-07-26
	public List<ContentFeedCommentVO> getContentFeedCommentByIdDAO(
			Integer contentFeedCommentID) throws DataAccessException,
			ParseException {

		List<ContentFeedCommentVO> contentFeedList = jdbcTemplate.query(
				Query.GET_CONTENT_FEED_COMMENT_ID,
				ParameterizedBeanPropertyRowMapper
						.newInstance(ContentFeedCommentVO.class),
				contentFeedCommentID);
		log.info("Query Execution - get all content feed -size "
				+ contentFeedList.size());
		return contentFeedList;

	}

	// 2015-08-28
	public int saveContentFeedUserLogDAO(ContentFeedUserLog contentFeedUserLog)
			throws DataAccessException, ParseException {
		long startTime = System.currentTimeMillis();
		int returnVal = jdbcTemplate.update(
				GenericProperties.getProperty("SAVE_CONTENT_FEED_USER_LOG"),
				contentFeedUserLog.getUserId(),
				contentFeedUserLog.getUserEmail(),
				contentFeedUserLog.getEnergyScore(),
				contentFeedUserLog.getRelaxScore(), new Date());
		System.out.println(returnVal
				+ "--inside saveContentFeddCommentDAO<-returnVal");

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time insertCourseReview - " + afterQuery
				+ " millseconds");
		return returnVal;
	}

	public List<ContentFeedUserLog> getContentFeedUserScoreDAO(
			String userEmail, String date) throws DataAccessException,
			ParseException {

		List<ContentFeedUserLog> contentFeedUserLogs = jdbcTemplate
				.query(GenericProperties
						.getProperty("GET_CONTENT_FEED_USER_LOG_BY_EMAIL") + "",
						ParameterizedBeanPropertyRowMapper
								.newInstance(ContentFeedUserLog.class),
						userEmail, date);

		log.info("Query Execution - get all content feed user log -size "
				+ contentFeedUserLogs.size());
		return contentFeedUserLogs;

	}

	public Map<String, Integer> getUserJourneyForDashboardDAO(String userEmail)
			throws DataAccessException, ParseException {

		List<User> userList = jdbcTemplate.query(
				GenericProperties.getProperty("GET_USER_DETAILS"),
				ParameterizedBeanPropertyRowMapper.newInstance(User.class),
				userEmail);

		if (userList.size() <= 0) {
			return null;
		}

		User user = userList.get(0);
		Integer userId = Integer.valueOf(user.getId());

		// Integer startCycle =
		// jdbcTemplate.queryForInt(GenericProperties.getProperty("GET_START_CYCLE"),new
		// Object[] { userId });

		List<String> startCycleLst = jdbcTemplate.query(
				GenericProperties.getProperty("GET_START_CYCLE"),
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						return rs.getString(1);
					}
				}, new Object[] { userId });
		Integer startCycle = startCycleLst.isEmpty() ? 0 : Integer
				.valueOf(startCycleLst.get(0));

		List<String> currentCycleLst = jdbcTemplate.query(
				GenericProperties.getProperty("GET_CURRENT_CYCLE"),
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						return rs.getString(1);
					}
				}, new Object[] { userId });
		Integer currentCycle = currentCycleLst.isEmpty() ? 0 : Integer
				.valueOf(currentCycleLst.get(0));

		List<String> finalLst = jdbcTemplate.query(
				GenericProperties.getProperty("GET_FINAL_CYCLE"),
				new RowMapper() {
					public Object mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						return rs.getString(1);
					}
				}, new Object[] { userId });
		Integer finalCycle = finalLst.isEmpty() ? 0 : Integer.valueOf(finalLst
				.get(0));

		System.out.println(userId + " :<--userId: startCycle : " + startCycle
				+ "<=user.getCycle()==>" + user.getCycle()
				+ " ::currentCycle :: " + currentCycle + " :: finalCycle:: "
				+ finalCycle);

		if (finalCycle > currentCycle)
			currentCycle = finalCycle;

		if (startCycle == 0)
			startCycle = user.getCycle() != null ? Integer.valueOf(user
					.getCycle()) : currentCycle;

		if (finalCycle > startCycle)
			startCycle = finalCycle;

		Map<String, Integer> cycles = new HashMap<String, Integer>();

		cycles.put("startCycle", startCycle);
		cycles.put("currentCycle", currentCycle);
		cycles.put("finalCycle", finalCycle);

		System.out.println(cycles.size() + " ...After -- > startCycle : "
				+ startCycle + " ::currentCycle :: " + currentCycle
				+ " :: finalCycle:: " + finalCycle);

		log.info("Query Execution - get all content feed user log -size "
				+ cycles.size());
		return cycles;

	}

	public List<User> registerFbByEmail(User userDetails) {

		log.info("Inside registerFbByEmail DAO ");
		try {
			long startTime = System.currentTimeMillis();

			Date dob = null;
			if (userDetails.getInpDob() != null)
				dob = Util.formatDate(userDetails.getInpDob());

			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.MONTH, 1);

			int returnVal = jdbcTemplate
					.update(Query.ADD_USER_SQL,
							userDetails.getPwd() != null ? userDetails.getPwd()
									: "chippr123",
							userDetails.getEmail(),
							userDetails.getfName() != null ? userDetails
									.getfName() : "",
							userDetails.getmName() != null ? userDetails
									.getmName() : "",
							userDetails.getlName() != null ? userDetails
									.getlName() : "",
							dob,
							userDetails.getGender() != null ? userDetails
									.getGender() : "",
							userDetails.getScore() != null ? userDetails
									.getScore() : 0, new Date(), new Date(),
							UserTypeEnums.FREE.ordinal(), new Date(), cal
									.getTime());

			if (returnVal > 0)
				return getUserByEmail(userDetails.getEmail());

			long afterQuery = System.currentTimeMillis() - startTime;
			log.info(returnVal
					+ "query result <- Query Execution time registerFbByEmail - "
					+ afterQuery + " millseconds");

		} catch (DataAccessException e) {
			log.info("excpetion in registerFbByEmail : " + e);
			e.printStackTrace();
		} catch (Exception e) {
			log.info("excpetion in registerFbByEmail : " + e);
			e.printStackTrace();
		}
		return null;
	}

	public List<Plan> getAllPlans() throws DataAccessException {
		long startTime = System.currentTimeMillis();
		List<Plan> plans = (List<Plan>) jdbcTemplate.query(
				Query.GET_ALL_PLAN_SQL,
				ParameterizedBeanPropertyRowMapper.newInstance(Plan.class));

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getAllPlans - " + afterQuery
				+ " millseconds");
		return plans;
	}

	public List<Category> getAllPlanCategories(int planCatId)
			throws DataAccessException {
		long startTime = System.currentTimeMillis();

		List<Category> plans = (List<Category>) jdbcTemplate.query(
				Query.GET_ALL_PLANCAT_BY_ID_SQL, new Object[] { planCatId },
				new PlanCatMapper());

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getAllPlanCategories - " + afterQuery
				+ " millseconds");
		return plans;
	}

	public List<OnDemandContent> getOnDemandContent(int planCatId) {
		long startTime = System.currentTimeMillis();
		List<OnDemandContent> plans = (List<OnDemandContent>) jdbcTemplate
				.query(Query.GET_ON_DEMAND_CONTENT, new Object[] { planCatId },
						new OnDemandMapper());

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getAllPlanCategories - " + afterQuery
				+ " millseconds");
		return plans;
	}

	public List<PlanStructure> getPlanStructure(int planId, int fintNessLev)
			throws DataAccessException {
		long startTime = System.currentTimeMillis();

		List<PlanStructure> plans = (List<PlanStructure>) jdbcTemplate.query(
				Query.GET_PLAN_STRUCT_BY_ID,
				new Object[] { planId, fintNessLev }, new PlanStructMapper());

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getPlanStructure - " + afterQuery
				+ " millseconds");
		return plans;
	}

	// public Criteria getCurrentWorkInputs(Integer userid)
	// {
	//
	// }
	public List<VideoResObj> getVideosList(VideoReqObj req, Integer cat, Integer count, Integer maxVideoNumber) throws DataAccessException {

		List<VideoResObj> videos = new ArrayList<VideoResObj>();
		List<String> fit = new ArrayList<String>();
		// hard coded sub categories for now, will get sub categories from db
		// later.
		Integer equipment = Integer.parseInt(req.getEquipment());
		Integer bodyFocus = Integer.parseInt(req.getBodyFocus());

		if ("41".equals(req.getFitnessLevel())) {
			fit.add("41");
			fit.add("94");
		} else if ("42".equals(req.getFitnessLevel())) {
			fit.add("42");
			fit.add("44");
			fit.add("94");
		} else if ("43".equals(req.getFitnessLevel())) {
			fit.add("43");
			fit.add("44");
			fit.add("94");
		}
		List<String> cats = new ArrayList<String>();
		// Get the sub categories when ST(7),FT_Warmup(8),FT_warmDown(19),guided
		// relaxation(15)

		int temp = 0;
		if (cat == 8 || cat == 103 || cat == 62) // FT
		{
			if (cat == 8)
				temp = 3;
			else if (cat == 103)
				temp = 19;
			else if (cat == 62)
				temp = 15;
			else
				temp = cat;
			List<Category> subCat = getAllPlanCategories(temp);
			for (Category c : subCat) {
				cats.add("" + c.getId());
			}
		} else {
			cats.add("" + cat);
		}

		if (cat == 62 || cat == 61) {
			bodyFocus = 0;
			fit.clear();
			fit.add("0");
			equipment = 0;
		} else if (cat == 103 || cat == 8 || cat == 6 || cat == 45 || cat == 10) {
			if (cat == 8 || cat == 103)
				bodyFocus = Integer.parseInt(req.getFlexiblityType());
			equipment = 0;
		}
//		} else if (cat == 7) {
//			equipment = Integer.parseInt(req.getStrengthnings());
//		}
		if (cat == 61 || cat == 62) {
			// ramakanth need add catMapList
			// List<Integer> CatListData = catMapList.get(cat);
			// int day = CatListData.get(0);
			// System.out.println(CatListData);
			int day = 6;
			List<User> userData = getUserById(Integer.parseInt(req.getUserId()));
			User currUser = userData.get(0);
			// 1. Get the current level and module for the user
			if (currUser == null || currUser.getCurrentLevel() == null
					|| currUser.getCurrentModule() == null) {
				Status status = new Status(false,
						"Invalid User - Level/Module missing",
						StatusCodes.NO_RECORD_FOUND.code);

				return videos;
			}

			System.err.println(currUser.getCurrentLevel() + " - "
					+ currUser.getCurrentModule());

			// 2. Get the health conditions for the user from userhc table
			List<HealthCondition> userHealthConditionList = getUserHealthConditions(currUser
					.getEmail());

			// 3. For each #2 get all the breathing techniques from hc bt map
			// table
			List<Integer> healthConditionList = new ArrayList<Integer>();
			for (HealthCondition healthCondition : userHealthConditionList) {
				healthConditionList.add(healthCondition.getId());
			}

			if (healthConditionList.isEmpty()) {
				Status status = new Status(false,
						"No User Health Condition Found",
						StatusCodes.NO_RECORD_FOUND.code);

				return videos;
			}

			List<HCBTMap> hcbtMapList = getHealthConditionBtMap(healthConditionList);

			if (hcbtMapList.isEmpty()) {
				Status status = new Status(false,
						"No Breathing technique found",
						StatusCodes.NO_RECORD_FOUND.code);

				return videos;
			}
			List<Courses> courses = getUserMBandGR(currUser,
					healthConditionList, hcbtMapList, cat);
			List<ContentFeedANDFavourrite> listGim = getGuidedImageryDAO();
			videos = convertCoursetoVideo(courses, req, Integer.toString(day),
					Integer.toString(cat),listGim);

			System.out.println(videos);

		} else {
			NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
					jdbcTemplate);
			MapSqlParameterSource parameters1 = new MapSqlParameterSource();
			parameters1.addValue("fit", fit);
			parameters1.addValue("cats", cats);
			parameters1.addValue("body", bodyFocus);
			parameters1.addValue("equip", equipment);
			parameters1.addValue("pre", req.getPrenatal());
			parameters1.addValue("pick", req.getIsPickAplan());
			parameters1.addValue("maxVideo", maxVideoNumber);
			parameters1.addValue("count", count);

			videos = namedParameterJdbcTemplate
					.query("SELECT * from content_feed c join  instructor i on i.id=c.instructorId and c.levelId in (:fit) and c.catId in (:cats) and c.bodyFocusId=:body and c.equipmentId=:equip and c.prenatal=:pre and c.pickAplan=:pick and c.content_feed_id > :maxVideo and c.enable=1 order by c.content_feed_id limit :count",
							parameters1, new VideoMapper("" + cat));
		}
		return videos;
	}

	public List<User> getUserById(int userId) throws DataAccessException {
		long startTime = System.currentTimeMillis();
		List<User> user = (List<User>) jdbcTemplate.query(
				Query.GET_USER_SQL_BY_USER_ID, new Object[] { userId },
				new UserMapper());
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getUser - " + afterQuery
				+ " millseconds");
		return user;
	}

	public List<VideoResObj> convertCoursetoVideo(List<Courses> courses,
			VideoReqObj req, String day, String catId,List<ContentFeedANDFavourrite> listGim) {

		List<VideoResObj> videos = new ArrayList<VideoResObj>();

		if (courses.size() > 0) {
			for (Courses cou : courses) {
				if (cou != null) {
					VideoResObj videoObj = new VideoResObj();
					videoObj.setTitle(cou.getNameOfTech());

					videoObj.setBtCode(cou.getBtId());
					videoObj.setTitle(cou.getName());
					videoObj.setBtstatus(0);
					videoObj.setCatId(catId);
					videoObj.setContent_url(cou.getVideoLink());
					videoObj.setImage_url(cou.getImageUrl());
					videoObj.setContent_text(cou.getDescription());
					videoObj.setDay(day);
					videoObj.setPlanId(req.getPlanId());
					videoObj.setVideoId(Integer.toString(cou.getId()));
					videoObj.setFeed_type("Video");
					videoObj.setAudioUrl(cou.getAudioLink());
					videoObj.setTrainer_bio(cou.getTrainerBio());
					videoObj.setTrainer_image(cou.getTrainerImage());
					videoObj.setTrainer_name(cou.getTrainerName());
					videoObj.setAudioDuration(cou.getAudioDuration());

					
					
					if(listGim.size()>0 && Integer.parseInt(catId)==61){
						int guidedimgIndex=randamListvalue(listGim);
						ContentFeedANDFavourrite guidedimg = listGim.get(guidedimgIndex);
						listGim.remove(guidedimgIndex);
						videoObj.setAudioGuidedImg(guidedimg.getContentUrl());
						videoObj.setGuidedImgAudioDuration(guidedimg.getAudioDuration());
					}
					System.out.println(cou);
					videos.add(videoObj);
				}

			}
		}
		return videos;

	}

	public List<Courses> getUserMBandGRForOndemand(User currUser,
			List<Integer> healthConditionList, List<HCBTMap> hcbtMapList,
			int cat) {

		List<Courses> selectedCourses = new ArrayList<Courses>();
		List<String> exclusionList = new ArrayList<String>();

		Iterator<HCBTMap> iterator = hcbtMapList.iterator();
		System.err.println("Before - " + hcbtMapList.size());
		List<String> allowedMorningBtIds = new ArrayList<String>();
		List<String> allowedEveningBtIds = new ArrayList<String>();
		List<String> allowedAfternoonBtIds = new ArrayList<String>();

		while (iterator.hasNext()) {
			HCBTMap hCBTMap = iterator.next();

			if (exclusionList.contains(hCBTMap.getBtCode())) {
				iterator.remove();
			} else {

				allowedMorningBtIds.add(hCBTMap.getBtCode());
			}
			// allowedMorningBtIds.add(hCBTMap.getBtCode());
		}
		System.err.println("After - " + hcbtMapList.size());
		System.err.println(allowedMorningBtIds.size() + " "
				+ allowedAfternoonBtIds.size() + " "
				+ allowedEveningBtIds.size());

		// 6 - Fetch the breathing techniques
		int mb = 0;
		int gb = 0;
		if (!allowedMorningBtIds.isEmpty()) {
			List<Courses> courses = getCourses(allowedMorningBtIds,
					currUser.getCurrentModule(), currUser.getCurrentLevel());
			if (!courses.isEmpty()) {
				for (Courses currCourse : courses) {

					currCourse.setCourseDay("M");
					currCourse.setBreathCycle(currCourse.getBreathSequence());

					String nameBT = (currCourse.getName() != null && !currCourse
							.getName().equalsIgnoreCase("")) ? currCourse
							.getName() : "";
					String nameModuleBT = (currCourse.getNameOfTech() != null && !currCourse
							.getNameOfTech().equalsIgnoreCase("")) ? currCourse
							.getNameOfTech() : "";

					if (!nameBT.equalsIgnoreCase("")
							&& !nameModuleBT.equalsIgnoreCase(""))
						currCourse.setName(nameModuleBT);
					else {
						currCourse.setName(nameModuleBT);
					}

					currCourse
							.setDescription((currCourse.getBtDesc() != null ? currCourse
									.getBtDesc() : "")
									+ " "
									+ (currCourse.getDescription() != null ? currCourse
											.getDescription() : ""));
					currCourse.setAnimationLink(currCourse.getVideoLink());

					int currcatid = currCourse.getCatId();

					if (cat == 15 && (currcatid>=63 &&  currcatid<=69)) {

						selectedCourses.add(currCourse);
					} else if (cat == currcatid) {

						selectedCourses.add(currCourse);
					}

				}
			}
		}

		return selectedCourses;
	}

	public List<Courses> getUserMBandGR(User currUser,
			List<Integer> healthConditionList, List<HCBTMap> hcbtMapList,
			int cat) {

		List<Courses> selectedCourses = new ArrayList<Courses>();
		List<String> exclusionList = new ArrayList<String>();
		// 4. for each #2 get the exclusion from exclusion map table

		/*
		 * List<String> exclusionList = getExclusionBtCodes(healthConditionList,
		 * currUser.getCurrentModule(), currUser.getCurrentLevel());
		 */

		// 5 - #3 - #4
		Iterator<HCBTMap> iterator = hcbtMapList.iterator();
		System.err.println("Before - " + hcbtMapList.size());
		List<String> allowedMorningBtIds = new ArrayList<String>();
		List<String> allowedEveningBtIds = new ArrayList<String>();
		List<String> allowedAfternoonBtIds = new ArrayList<String>();

		List<WeeklyWorkOut> weekList = getCurrentWorkOut(currUser.getId());

		while (iterator.hasNext()) {
			HCBTMap hCBTMap = iterator.next();

			if (exclusionList.contains(hCBTMap.getBtCode())) {
				iterator.remove();
			} else {

				allowedMorningBtIds.add(hCBTMap.getBtCode());
			}
			// allowedMorningBtIds.add(hCBTMap.getBtCode());
		}
		System.err.println("After - " + hcbtMapList.size());
		System.err.println(allowedMorningBtIds.size() + " "
				+ allowedAfternoonBtIds.size() + " "
				+ allowedEveningBtIds.size());

		// 6 - Fetch the breathing techniques
		int mb = 0;
		int gb = 0;
		if (!allowedMorningBtIds.isEmpty()) {
			List<Courses> courses = getCourses(allowedMorningBtIds,
					currUser.getCurrentModule(), currUser.getCurrentLevel());
			if (!courses.isEmpty()) {
				for (Courses currCourse : courses) {

					currCourse.setCourseDay("M");
					currCourse.setBreathCycle(currCourse.getBreathSequence());

					String nameBT = (currCourse.getName() != null && !currCourse
							.getName().equalsIgnoreCase("")) ? currCourse
							.getName() : "";
					String nameModuleBT = (currCourse.getNameOfTech() != null && !currCourse
							.getNameOfTech().equalsIgnoreCase("")) ? currCourse
							.getNameOfTech() : "";

					if (!nameBT.equalsIgnoreCase("")
							&& !nameModuleBT.equalsIgnoreCase(""))
						currCourse.setName(nameModuleBT);
					else {
						currCourse.setName(nameModuleBT);
					}

					currCourse
							.setDescription((currCourse.getBtDesc() != null ? currCourse
									.getBtDesc() : "")
									+ " "
									+ (currCourse.getDescription() != null ? currCourse
											.getDescription() : ""));
					currCourse.setAnimationLink(currCourse.getVideoLink());

					for (WeeklyWorkOut weekdetails : weekList) {
						if (!weekdetails.getBtm_code().equals("")
								&& weekdetails.getBtm_code().equals(
										currCourse.getBtId())
								&& weekdetails.getWatchedTime() == currCourse
										.getCourseDuration()) {
							exclusionList.add(weekdetails.getBtm_code());
						}
					}

					if (nameBT.equals("MINDFUL BREATHING 101") && mb == 0
							&& cat == 61) {
						mb++;
						selectedCourses.add(currCourse);
					}
					if (nameBT.equals("GUIDED RELAXATION 101") && gb == 0
							&& cat == 62) {
						gb++;
						selectedCourses.add(currCourse);
					}

				}
			}
		}

		return selectedCourses;
	}

	public List<VideoResObj> getVideosListByCriteria(VideoReqObj req,
			Integer cat) throws DataAccessException {
		List<String> fit = new ArrayList<String>();
		if ("41".equals(req.getFitnessLevel())) {
			fit.add("41");
			fit.add("94");
		} else if ("42".equals(req.getFitnessLevel())) {
			fit.add("42");
			fit.add("44");
			fit.add("94");
		} else if ("43".equals(req.getFitnessLevel())) {
			fit.add("43");
			fit.add("44");
			fit.add("94");
		} else {
			fit.add("0");
		}
		long startTime = System.currentTimeMillis();
		List<VideoResObj> videos = new ArrayList<VideoResObj>();
		List<String> cats = new ArrayList<String>();
		if (cat == 103) {
			cats.add("11");
			cats.add("12");
			cats.add("13");
			cats.add("14");
			cats.add("15");
			cats.add("95");
		} else {
			cats.add("" + cat);
		}

		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				jdbcTemplate);
		MapSqlParameterSource parameters1 = new MapSqlParameterSource();
		parameters1.addValue("levelId", fit);
		parameters1.addValue("cats", cats);
		parameters1.addValue("body", req.getBodyFocus());
		parameters1.addValue("equip", req.getEquipment());
		parameters1.addValue("pre", req.getPrenatal());
		parameters1.addValue("userId", req.getUserId());

		videos = namedParameterJdbcTemplate
				.query("SELECT ww.Id onDemandId,c.content_feed_id,c.title,c.image_url,c.content_url,c.content_text,c.feed_type,c.comment_count,c.energy_score,c.relax_score,i.pic,i.name,i.bio,c.duration_time,c.catId,COALESCE(ww.watchedTime,'00:00:00'),COALESCE(ww.done,0) from content_feed c join instructor i on i.id=c.instructorId and c.levelId in (:levelId) and c.catId in (:cats) and c.bodyFocusId=:body and c.enable=1 and c.equipmentId=:equip and c.prenatal=:pre "+
						 " left join ondemand_work_out ww on ww.videoId=c.content_feed_id and ww.done=0 and ww.userId=:userId"+
						 " order by c.content_feed_id ",
						parameters1, new VideoMapper1());

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getVideosList - " + afterQuery
				+ " millseconds");
		return videos;
	}

	public List<VideoResObj> getVideosListOnDemans(VideoReqObj req,
			Integer cat, Integer subcat) throws DataAccessException {
		long startTime = System.currentTimeMillis();
		List<VideoResObj> videos = new ArrayList<VideoResObj>();
		List<String> cats = new ArrayList<String>();

		if (cat == 61) {
			cats.add(cat.toString());

		} else if (cat == 15 && subcat == 0) {
			cats.add("63");
			cats.add("64");
			cats.add("65");
			cats.add("66");
			cats.add("67");
			cats.add("68");
			cats.add("69");
		} else if (cat == 15 && subcat > 0) {
			cats.add(subcat.toString());

			cat = subcat;

		} else {
			cats.add("" + cat);
		}

		int day = 6;
		List<User> userData = getUserById(Integer.parseInt(req.getUserId()));
		User currUser = userData.get(0);
		// 1. Get the current level and module for the user
		if (currUser == null || currUser.getCurrentLevel() == null
				|| currUser.getCurrentModule() == null) {
			Status status = new Status(false,
					"Invalid User - Level/Module missing",
					StatusCodes.NO_RECORD_FOUND.code);

			return videos;
		}

		System.err.println(currUser.getCurrentLevel() + " - "
				+ currUser.getCurrentModule());

		// 2. Get the health conditions for the user from userhc table
		List<HealthCondition> userHealthConditionList = getUserHealthConditions(currUser
				.getEmail());

		// 3. For each #2 get all the breathing techniques from hc bt map
		// table
		List<Integer> healthConditionList = new ArrayList<Integer>();
		for (HealthCondition healthCondition : userHealthConditionList) {
			healthConditionList.add(healthCondition.getId());
		}

		if (healthConditionList.isEmpty()) {
			Status status = new Status(false, "No User Health Condition Found",
					StatusCodes.NO_RECORD_FOUND.code);

			return videos;
		}

		List<HCBTMap> hcbtMapList = getHealthConditionBtMap(healthConditionList);

		if (hcbtMapList.isEmpty()) {
			Status status = new Status(false, "No Breathing technique found",
					StatusCodes.NO_RECORD_FOUND.code);

			return videos;
		}
		List<Courses> courses = getUserMBandGRForOndemand(currUser,
				healthConditionList, hcbtMapList, cat);
		List<ContentFeedANDFavourrite> listGim = getGuidedImageryDAO();
		videos = convertCoursetoVideo(courses, req, Integer.toString(day),
				Integer.toString(cat),listGim);

		System.out.println(videos);
		return videos;
	}
	public int getcoursecountofCat(int cat, int userid){
		List<String> cats = new ArrayList<String>();
		cats.add(Integer.toString(cat));
		
		List<User> userData = getUserById(userid);
		User currUser = userData.get(0);
		// 1. Get the current level and module for the user
		if (currUser == null || currUser.getCurrentLevel() == null
				|| currUser.getCurrentModule() == null) {
			Status status = new Status(false,
					"Invalid User - Level/Module missing",
					StatusCodes.NO_RECORD_FOUND.code);

			return 0;
		}

		System.err.println(currUser.getCurrentLevel() + " - "
				+ currUser.getCurrentModule());

		// 2. Get the health conditions for the user from userhc table
		List<HealthCondition> userHealthConditionList = getUserHealthConditions(currUser
				.getEmail());

		// 3. For each #2 get all the breathing techniques from hc bt map
		// table
		List<Integer> healthConditionList = new ArrayList<Integer>();
		for (HealthCondition healthCondition : userHealthConditionList) {
			healthConditionList.add(healthCondition.getId());
		}

		if (healthConditionList.isEmpty()) {
			Status status = new Status(false, "No User Health Condition Found",
					StatusCodes.NO_RECORD_FOUND.code);

			return 0;
		}

		List<HCBTMap> hcbtMapList = getHealthConditionBtMap(healthConditionList);

		if (hcbtMapList.isEmpty()) {
			Status status = new Status(false, "No Breathing technique found",
					StatusCodes.NO_RECORD_FOUND.code);

			return 0;
		}
		List<Courses> courses = getUserMBandGRForOndemand(currUser,
				healthConditionList, hcbtMapList, cat);
		return courses.size();
	}

	public List<MaxVideoWeekNo> getMaxVideoAndWeekNo(Integer userId)
			throws DataAccessException {
		long startTime = System.currentTimeMillis();
		List<MaxVideoWeekNo> week = new ArrayList<MaxVideoWeekNo>();

		week = (List<MaxVideoWeekNo>) jdbcTemplate.query(
				Query.GET_MAXVIDEO_WEEKNUM, new Object[] { userId, userId },
				new MaxVideoWeekNoMapper());

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getMaxVideoAndWeekNo - " + afterQuery
				+ " millseconds");
		return week;
	}

	public int insertWorkOutVideo(VideoResObj video, int weekNo, int userId,
			VideoReqObj request) throws DataAccessException, ParseException {

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("weekNumber", weekNo);
		parameters.addValue("videoId", video.getVideoId());
		parameters.addValue("userId", userId);
		parameters.addValue("dayId", video.getDay());
		parameters.addValue("catId", video.getCatId());
		parameters.addValue("planId", video.getPlanId());
		parameters.addValue("subCatId", video.getSubCatId());

		parameters.addValue("fitnessLevel", request.getFitnessLevel());
		parameters.addValue("flexiblityType", request.getFlexiblityType());
		parameters.addValue("bodyFocus", request.getBodyFocus());
		parameters.addValue("equipment", request.getEquipment());
		parameters.addValue("strengthnings", request.getStrengthnings());
		parameters.addValue("btm_code", video.getBtCode());
		parameters.addValue("bt_status", video.getBtstatus());

		final String SQL = "INSERT INTO weekly_work_out (weekNumber,videoId,userId,dayId,catId,planId,created,lastUpdated,subCatId,fitnessLevel,flexiblityType,bodyFocus,equipment,strengthnings,btm_code,bt_status"
				+ ")values(:weekNumber,:videoId,:userId,:dayId,:catId,:planId,now(),now(),:subCatId,:fitnessLevel,:flexiblityType,:bodyFocus,:equipment,:strengthnings,:btm_code,:bt_status)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		NamedParameterJdbcTemplate namedJdbcTemplate = new NamedParameterJdbcTemplate(
				jdbcTemplate.getDataSource());
		int nb = namedJdbcTemplate.update(SQL, parameters, keyHolder,
				new String[] { "id" });
		int generatedId = keyHolder.getKey().intValue();

		return generatedId;

	}

	public List<WeeklyWorkOut> getCurrentWorkOut(Integer userId) {
		long startTime = System.currentTimeMillis();
		List<WeeklyWorkOut> totalWorkOut = new ArrayList<WeeklyWorkOut>();
		List<WeeklyWorkOut> weekWorkOut = new ArrayList<WeeklyWorkOut>();
		List<WeeklyWorkOut> weekWorkOut1 = new ArrayList<WeeklyWorkOut>();
		weekWorkOut = (List<WeeklyWorkOut>) jdbcTemplate.query(
				Query.GET_CURRENT_WORKOUT_VIDEOS,
				new Object[] { userId, userId }, new WeeklyWorkOutMapper());
		totalWorkOut.addAll(weekWorkOut);

		weekWorkOut1 = (List<WeeklyWorkOut>) jdbcTemplate.query(
				Query.GET_CURRENT_WORKOUT_VIDEOS1, new Object[] { userId,
						userId }, new WeeklyWorkOutMapper());
		totalWorkOut.addAll(weekWorkOut1);
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getMaxVideoAndWeekNo - " + afterQuery
				+ " millseconds");
		
		for(WeeklyWorkOut workout: totalWorkOut)
		{
			if(workout.getCatId()==61)
			{
				List<ContentFeedANDFavourrite> listGim = getGuidedImageryDAO();
				int guidedimgIndex=randamListvalue(listGim);
				ContentFeedANDFavourrite guidedimg = listGim.get(guidedimgIndex);
				listGim.remove(guidedimgIndex);
				workout.setAudioGuidedImg(guidedimg.getContentUrl());
			}
		}
		return totalWorkOut;
	}

	public void resetCurrentWorkOut(Integer userId, Integer weekNumber) {
		long startTime = System.currentTimeMillis();
		int returnVal = 0;

		returnVal = jdbcTemplate.update(Query.RESET_CURRENT_WORK_OUT, userId,
				weekNumber);

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time to reset current work out - "
				+ afterQuery + " millseconds");

	}

	public void updateVideoDurationMinutes(Integer userId,
			String duration_time, String workOutId) {

		jdbcTemplate.update(Query.UPDATE_VIDEO_DURATION, duration_time,
				new Date(), userId, workOutId);

	}

//	public void updateOndemandVideoDurationMinutes(Integer userId,
//			String duration_time, String workOutId) {
//
//		jdbcTemplate.update(Query.UPDATE_ONDEMAND_VIDEO_DURATION, duration_time,
//				new Date(), userId, workOutId);
//
//	}
//	
	public void setDoneToCurrentWorkOut(int userId, int weekNo) {
		jdbcTemplate.update(Query.UPDATE_DONE_WORKOUT, userId, weekNo);
	}

	public void setBtStatusToCurrentWorkOut(int userId) {
		jdbcTemplate.update(Query.UPDATE_BtStastus_WORKOUT, userId);
	}

	public List<WeekDetails> getWeekGoalAndWatchTime(Integer userId) {

		long startTime = System.currentTimeMillis();
		List<WeekDetails> weekWorkOut = new ArrayList<WeekDetails>();

		weekWorkOut = (List<WeekDetails>) jdbcTemplate.query(
				Query.GET_WEEK_DETAILS, new Object[] { userId, userId,userId,userId },
				new WeekDetailsMapper());

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getWeekGoalAndWatchTime - " + afterQuery
				+ " millseconds");
		return weekWorkOut;
	}

	public List<WeekDetails2> getWeekWatchedMinutesDetails(Integer userId,
			Integer weekNumber) {
		long startTime = System.currentTimeMillis();
		List<WeekDetails2> weekWorkOut = new ArrayList<WeekDetails2>();
		List<Criteria> criteriaList = new ArrayList<Criteria>();
		criteriaList = getCurrentWorkOutCriteria(userId);
		Criteria cri = criteriaList.get(0);
		int fitnessLevel = cri.getFitnessLevel();
		int planId = cri.getPlanId();
		// get the goal workout based on plan id and fitness level.
		List<PlanStructure> planStructure = getPlanStructure(planId,
				fitnessLevel);

		weekWorkOut = (List<WeekDetails2>) jdbcTemplate.query(
				Query.GET_WEEK_DETAILS_INDEPTH, new Object[] { userId,
						weekNumber, userId, weekNumber ,userId,weekNumber,userId,weekNumber},
				new WeekDetailsMapper2());

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getWeekWatchedMinutesDetails - "
				+ afterQuery + " millseconds");
		return weekWorkOut;
	}

	public List<Criteria> getCurrentWorkOutCriteria(Integer userId) {
		long startTime = System.currentTimeMillis();
		List<Criteria> criteriaDetails = jdbcTemplate.query(
				Query.GET_CURRENT_WORKOUT_CRITERIA,
				ParameterizedBeanPropertyRowMapper.newInstance(Criteria.class),
				userId, userId);

		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getCurrentWorkOutCriteria - "
				+ afterQuery + " millseconds");
		return criteriaDetails;
	}
	public List<ContentFeedANDFavourrite> getGuidedImageryDAO() {
		List<ContentFeedANDFavourrite> contentFeedList = jdbcTemplate.query(
				Query.GET_GUIDED_IMAGERY,
				ParameterizedBeanPropertyRowMapper
						.newInstance(ContentFeedANDFavourrite.class));
		log.info("Query Execution - get all content feed -size "
				+ contentFeedList.size());
		return contentFeedList;
	}
	
	 private int randamListvalue(List<ContentFeedANDFavourrite> list)
	    {
		 
		 Random randomGenerator = new Random();
	        int index = randomGenerator.nextInt(list.size());
	        return index;
	       
	    }

	public List<WorkOutData> getDashBoardData(Integer userId, String selectType) {
		long startTime = System.currentTimeMillis();
		String addDays="";
		if("day".equals(selectType))
		{
			addDays="0 DAY";
		}
		else if("week".equals(selectType))
		{
			addDays="6 DAY";
		}

		List<WorkOutData> workOutList = new ArrayList<WorkOutData>();
		String Query = "";
		
		if("week".equals(selectType) || "day".equals(selectType))
		{
			Query="select 0 as onDemand,case when A.watchedTime= A.duration_time then 1 else 0 end as isCompleted,A.* from(select p.name as planName,ww.created,cl.name as workOutName,  case when ww.watchedTime= (select duration_time from content_feed where ww.videoId=content_feed_id) then 1 else 0 end as isCompleted, "+
					"case when ww.catId not in (61,62) then (select duration_time from content_feed where ww.videoId=content_feed_id) else "+ 
					"(select audio_duration from btmodule where ww.videoId=id) "+
					"END AS duration_time,ww.watchedTime,ww.catId,ww.lastUpdated FROM weekly_work_out ww join workoutplan p on ww.planId=p.id join plan_cat_list cl on  "+
					 "cl.id=ww.catId and ww.userId ="+userId+" and ww.lastUpdated >= curdate() - INTERVAL "+addDays+" ) as A "
					 		+ "UNION ALL "+
 "select  1 as onDemand,case when A.watchedTime= A.duration_time then 1 else 0 end as isCompleted,A.* from(select 0 as planName,ww.created,cl.name as workOutName,  case when ww.watchedTime= "+ 
"(select duration_time from content_feed where ww.videoId=content_feed_id) then 1 else 0 end as isCompleted, "+
	"case when ww.catId not in (61,62) then (select duration_time from content_feed where ww.videoId=content_feed_id) else "+ 
	"(select audio_duration from btmodule where ww.videoId=id) "+
	"END AS duration_time,ww.watchedTime,ww.catId,ww.lastUpdated FROM ondemand_work_out ww join plan_cat_list cl on "+  
	"cl.id=ww.catId and ww.userId="+userId+" and ww.lastUpdated >= curdate() - INTERVAL "+addDays+" ) as A";
			workOutList = (List<WorkOutData>) jdbcTemplate.query(
					Query,
					new Object[] {}, new DashBoardWeekWiseMapper());
		}
		if("year".equals(selectType))
		{
			Query="select 0 as onDemand,year(lastUpdated) as range1,COALESCE(SEC_TO_TIME(sum(TIME_TO_SEC(watchedTime))),'00:00:00') as totalTime from weekly_work_out where userId="+userId+" group by year(lastUpdated) UNION ALL "
					+ "select 1 as onDemand,year(lastUpdated) as range1,COALESCE(SEC_TO_TIME(sum(TIME_TO_SEC(watchedTime))),'00:00:00') as totalTime from ondemand_work_out where userId="+userId+" group by year(lastUpdated)";
			workOutList = (List<WorkOutData>) jdbcTemplate.query(
					Query,
					new Object[] {}, new DashBoardMapper());
			return workOutList;	
		}
		
		return workOutList;

	}

	public List<WorkOutData> getDashBoardRangeData(Integer userId,String fromDate,String endDate) {
		long startTime = System.currentTimeMillis();
		String addDays="";
		
		List<WorkOutData> workOutList = new ArrayList<WorkOutData>();
		String Query=" select  0 as onDemand,case when A.watchedTime= A.duration_time then 1 else 0 end as isCompleted,A.* from(select ww.videoId,p.name as planName,ww.created,cl.name as workOutName, "+
				"case when ww.catId not in (61,62) then (select duration_time from content_feed where ww.videoId=content_feed_id) else "+ 
				"(select audio_duration from btmodule where ww.videoId=id) END as duration_time ,ww.watchedTime, "+
"ww.catId,ww.lastUpdated FROM weekly_work_out ww join workoutplan p on "+
"ww.planId=p.id join plan_cat_list cl on "+
 "cl.id=ww.catId and ww.userId="+userId+" and ww.lastUpdated between '"+fromDate+"' and '"+endDate+"') as A UNION ALL "
 		+ "select 1 as onDemand, case when A.watchedTime= A.duration_time then 1 else 0 end as isCompleted,A.* from(select ww.videoId,0 as planName,ww.created,cl.name as workOutName, "+ 
				"case when ww.catId not in (61,62) then (select duration_time from content_feed where ww.videoId=content_feed_id) else  "+
"(select audio_duration from btmodule where ww.videoId=id) END as duration_time ,ww.watchedTime, "+
"ww.catId,ww.lastUpdated FROM ondemand_work_out ww left join plan_cat_list cl on "+
"cl.id=ww.catId where ww.userId="+userId+" and ww.lastUpdated between '"+fromDate+"' and '"+endDate+"') as A  ";	
		workOutList = (List<WorkOutData>) jdbcTemplate.query(
				Query,
				new Object[] {}, new DashBoardWeekWiseMapper());
		
		return workOutList;
		
	}

	public DashBoardItem getDashBoardDataInChart(Integer userId, String selectType) throws ParseException {
		long startTime = System.currentTimeMillis();
		List<ChartData> workOutList = new ArrayList<ChartData>();
		String Query="";
		if("day".equals(selectType))
		{
			Query="select *, 0 as onDemand,COALESCE(X.totalTime1,'00:00:00') as totaltime from hour_table ht LEFT JOIN (select floor(hour(ww.lastUpdated) / 4) as hour1,COALESCE(SEC_TO_TIME(sum(TIME_TO_SEC(watchedTime))),'00:00:00') as totalTime1 from weekly_work_out  ww where ww.lastUpdated >= curdate() and userid="+userId+ 
                   " group by floor(hour(ww.lastUpdated) / 4) ) AS X on ht.id=X.hour1  UNION ALL "
                   + "select *, 1 as onDemand,COALESCE(X.totalTime1,'00:00:00') as totaltime from hour_table ht LEFT JOIN (select floor(hour(ww.lastUpdated) / 4) as hour1,COALESCE(SEC_TO_TIME(sum(TIME_TO_SEC(watchedTime))),'00:00:00') as totalTime1 from ondemand_work_out  ww where ww.lastUpdated >= curdate() and userid="+userId+ 
                    " group by floor(hour(ww.lastUpdated) / 4) ) AS X on ht.id=X.hour1 ";
			workOutList = (List<ChartData>) jdbcTemplate.query(
					Query,
					new Object[] {}, new DashBoardChartMapperNoDates());
		}
		else if("week".equals(selectType))
		{
			Query="SELECT  0 as onDemand,curdate() -  INTERVAL (dt.id) DAY dayDate,dt.id,dt.name,COALESCE(SEC_TO_TIME(sum(TIME_TO_SEC(ww.watchedTime))),'00:00:00') as totalTime "+
			"FROM day_table dt "+
			"LEFT JOIN weekly_work_out ww ON dt.id = DATEDIFF(curdate(),ww.lastUpdated) and ww.lastUpdated >= curdate() -  INTERVAL 6 DAY and userid="+userId+
			" GROUP BY dt.id "+           
            " UNION ALL "+
             " SELECT  1 as onDemand,curdate() -  INTERVAL (dt.id) DAY dayDate,dt.id,dt.name,COALESCE(SEC_TO_TIME(sum(TIME_TO_SEC(ww.watchedTime))),'00:00:00') as totalTime "+ 
			 " FROM day_table dt "+
			 " LEFT JOIN ondemand_work_out ww ON dt.id = DATEDIFF(curdate(),ww.lastUpdated) and ww.lastUpdated >= curdate() -  INTERVAL 6 DAY and userid="+userId+
			 " GROUP BY dt.id";
			workOutList = (List<ChartData>) jdbcTemplate.query(
					Query,
					new Object[] {}, new DashBoardMapperWeek());
		}
		else if("month".equals(selectType) || "year".equals(selectType))
		{
			int days=0;
			String name="";
			if("month".equals(selectType)){ days=-6;name="week";}
			else if("year".equals(selectType)) {days=-90;name="quarter";}
			List<ChartData> totworkOutList = new ArrayList<ChartData>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(new Date()); // Now use today date.
			for(int i=0;i<4;i++)
			{
				String toDate=sdf.format(c.getTime());
				c.add(Calendar.DATE, days); 
				String fromDate = sdf.format(c.getTime());
				Query="select  0 as onDemand,'"+(i+1)+"' as id, '"+name+(i+1)+"' as name,'"+fromDate+"' as FROM_DATE, '"+toDate+"' as TO_DATE, COALESCE(SEC_TO_TIME(sum(TIME_TO_SEC(watchedTime))),'00:00:00') as totalTime from weekly_work_out where lastUpdated <= '"+toDate+"' + INTERVAL 1 DAY  and lastUpdated>='"+fromDate+"'  and userid="+userId;
				totworkOutList = (List<ChartData>) jdbcTemplate.query(
						Query,
						new Object[] {}, new DashBoardChartMapper());
				workOutList.addAll(totworkOutList);
				Query="select  1 as onDemand,'"+(i+1)+"' as id, '"+name+(i+1)+"' as name,'"+fromDate+"' as FROM_DATE, '"+toDate+"' as TO_DATE, COALESCE(SEC_TO_TIME(sum(TIME_TO_SEC(watchedTime))),'00:00:00') as totalTime from ondemand_work_out where lastUpdated <= '"+toDate+"' + INTERVAL 1 DAY  and lastUpdated>='"+fromDate+"'  and userid="+userId;
				totworkOutList = (List<ChartData>) jdbcTemplate.query(
						Query,
						new Object[] {}, new DashBoardChartMapper());
				workOutList.addAll(totworkOutList);
				
			}
		}
		//sort the collection based on workoutlist isOnDemand. 
		Collections.sort(workOutList, new SortBasedOnDemand());
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		long sum=0;		
		final DateFormat dt = new SimpleDateFormat("HH:mm:ss");
		for(ChartData cd: workOutList)
		{
			sum=sum + timeFormat.parse(cd.getTotalTime()).getTime();
		}
		DashBoardItem dbi=new DashBoardItem();
		dbi.setChartData(workOutList);
		dbi.setTotalWorkOutTime(timeFormat.format(new Date(sum)));
		return dbi;
	}

	public List<WorkOutData> getDashBoardWeekWiseByQuarter(Integer userId, String fromDate,String toDate) {
		List<WorkOutData> workOutList = new ArrayList<WorkOutData>();
		 String Query = "select a.onDemand,a.id,a.FROM_DATE,a.TO_DATE,SEC_TO_TIME(sum(TIME_TO_SEC(a.totalTime))) as totalTime from"+
"(select  0 as onDemand,ww.userId as id,'' as name,"+
"DATE_ADD(Date(ww.lastUpdated), INTERVAL(1-DAYOFWEEK(ww.lastUpdated)) DAY) as FROM_DATE, "+
"adddate(Date(ww.lastUpdated), INTERVAL 7-DAYOFWEEK(ww.lastUpdated) DAY) TO_DATE,"+
"SEC_TO_TIME(sum(TIME_TO_SEC(ww.watchedTime))) as totalTime ,"+
"week(ww.lastUpdated) as lastupdated "+
" FROM weekly_work_out ww where ww.userId="+userId+" and ww.lastUpdated >= '"+fromDate+"' and ww.lastUpdated <= '"+toDate+"' group by lastupdated) a group by a.FROM_DATE,a.TO_DATE "+
 " union All "+
 "select a.onDemand,a.id,a.FROM_DATE,a.TO_DATE,SEC_TO_TIME(sum(TIME_TO_SEC(a.totalTime))) as totalTime from "+
"(select  1 as onDemand,ww.userId as id,'' as name, "+
"DATE_ADD(Date(ww.lastUpdated), INTERVAL(1-DAYOFWEEK(ww.lastUpdated)) DAY) as FROM_DATE, "+
"adddate(Date(ww.lastUpdated), INTERVAL 7-DAYOFWEEK(ww.lastUpdated) DAY) TO_DATE, "+
"SEC_TO_TIME(sum(TIME_TO_SEC(ww.watchedTime))) as totalTime , "+
"week(ww.lastUpdated) as lastupdated "+
" FROM ondemand_work_out ww where ww.userId="+userId+" and ww.lastUpdated >= '"+fromDate+"' and ww.lastUpdated <= '"+toDate+"' group by lastupdated) a group by a.FROM_DATE,a.TO_DATE";
 workOutList = (List<WorkOutData>) jdbcTemplate.query(
									Query,
									new Object[] {}, new DashBoardChartMapper());
		
		return workOutList;
	}

	public List<WorkOutData> getDashBoardQuarterDataByYear(Integer userId, String yearNo) {
		List<WorkOutData> workOutList = new ArrayList<WorkOutData>();
		String Query = " select a.onDemand,a.id,a.FROM_DATE,a.TO_DATE,SEC_TO_TIME(sum(TIME_TO_SEC(a.totalTime))) as totalTime from "+
		" (select  0 as onDemand, ww.userId as id, "+
		" MAKEDATE(YEAR(ww.lastUpdated), 1) + INTERVAL QUARTER(ww.lastUpdated) QUARTER - INTERVAL 1 QUARTER  as FROM_DATE, "+
		" MAKEDATE(YEAR(ww.lastUpdated), 1) + INTERVAL QUARTER(ww.lastUpdated) QUARTER - INTERVAL 1 DAY TO_DATE, "+
		" SEC_TO_TIME(sum(TIME_TO_SEC(ww.watchedTime))) as totalTime, "+
		" DATE(ww.lastUpdated) as lastupdated "+
		" FROM weekly_work_out ww where ww.userId="+userId+" and YEAR(ww.lastUpdated) = '"+yearNo+"' group by lastupdated) a group by a.FROM_DATE,a.TO_DATE "+
		" union all "+
		" select b.onDemand,b.id,b.FROM_DATE,b.TO_DATE,SEC_TO_TIME(sum(TIME_TO_SEC(b.totalTime))) as totalTime from "+
		" (select 1 as onDemand, ww.userId as id, "+
		" MAKEDATE(YEAR(ww.lastUpdated), 1) + INTERVAL QUARTER(ww.lastUpdated) QUARTER - INTERVAL 1 QUARTER  as FROM_DATE, "+
		" MAKEDATE(YEAR(ww.lastUpdated), 1) + INTERVAL QUARTER(ww.lastUpdated) QUARTER - INTERVAL 1 DAY TO_DATE, "+
		" SEC_TO_TIME(sum(TIME_TO_SEC(ww.watchedTime))) as totalTime, "+
		" DATE(ww.lastUpdated) as lastupdated "+
		" FROM ondemand_work_out ww where ww.userId="+userId+" and YEAR(ww.lastUpdated) = '"+yearNo+"' group by lastupdated) b group by b.FROM_DATE,b.TO_DATE";
		                 workOutList = (List<WorkOutData>) jdbcTemplate.query(
									Query,
									new Object[] {}, new DashBoardChartMapper());
							return workOutList;
	}

	public void updateOndemandVideoDurationMinutes(Integer userId, OnDemandWorkOut video) {

		
		String Query= "select count(*) as count from ondemand_work_out where userId=:userId and videoId=:videoId and done=0";
				NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
						jdbcTemplate);
				MapSqlParameterSource parameters1 = new MapSqlParameterSource();
				parameters1.addValue("userId", userId);
				parameters1.addValue("videoId", video.getVideoId());
				List<Integer> count = namedParameterJdbcTemplate
						.query(Query,
								parameters1, new CountMapper());
				Integer totCount=count.get(0);
				
				//check the done information using watched time. 
				Query=" select count(*) as count from content_feed cf where content_feed_id=:videoId and duration_time=:duration_time";
				NamedParameterJdbcTemplate namedParameterJdbcTemplate1 = new NamedParameterJdbcTemplate(
						jdbcTemplate);
				MapSqlParameterSource parameter1 = new MapSqlParameterSource();
				parameter1.addValue("videoId", video.getVideoId());
				parameter1.addValue("duration_time", video.getWatchedTime());
				
				List<Integer> doneList = namedParameterJdbcTemplate1
						.query(Query,
								parameter1, new CountMapper());
				Integer done=doneList.get(0);
				
				
				if(totCount==0)
				{
					//insert record.
					long startTime = System.currentTimeMillis();
					int returnVal = 0;
					String sql ="insert into ondemand_work_out(videoId,userId,watchedTime,done,catId,created,lastUpdated) values(?,?,?,?,?,now(),now())";

						returnVal = jdbcTemplate.update(sql, video.getVideoId(),
									userId,
									video.getWatchedTime(),
									done,video.getCatId());
					
				}
				else if(totCount==1)
				{
					int returnVal = 0;
					//update record.
					returnVal = jdbcTemplate.update("update ondemand_work_out set watchedTime=?, done=? , lastUpdated=now() where userId=? and videoId=? and id=?",
							video.getWatchedTime(), done,
							userId, video.getVideoId(),video.getOnDemandId()
							);
				}
				
	}

	public List<FavouritesData> getFavourites(String email){
		List<FavouritesData> result = new ArrayList<FavouritesData>();

		String query = "SELECT c.title as title,c.image_url imageURL,c.content_url as contentURL,c.trainer_name trainerName FROM content_feed c join favourite_video f on f.content_id=c.content_feed_id and f.email='"+email+"'" ;


		result = (List<FavouritesData>) jdbcTemplate.query(query, new Object[] {}, new FavouriteMapper());
		return result;
	}

	public List<SearchData> getSearchData(String searchText){
		List<SearchData> result = new ArrayList<SearchData>();

			String query = "SELECT cf.comment_count as commentCount,cf.comment_like as commentLike,cf.content_feed_id as contentFeedId," +
					"                    cf.content_text contentText ," +
					"                    cf.content_url contentUrl ," +
					"                    cf.duration_time durationTime," +
					"                    cf.enable enable," +
					"                    cf.energy_score energyScore ," +
					"                    cf.feed_type feedType ," +
					"                    cf.image_url imageUrl," +
					"                    cf.relax_score relaxScore," +
					"                    cf.title title," +
					"                    bf.categoryName Category," +
					"                    cf.trainer_desc trainerDesc," +
					"                    cf.trainer_image trainerImage," +
					"                    cf.trainer_name trainerName" +
					"                    FROM ebdb.content_feed cf left join bodyFocus bf on cf.bodyFocusId = bf.id where cf.feed_type='VIDEO'";
			if(searchText != null){
				query += " and cf.Tags like '%" + searchText + "%'";
			}
			query += " limit 50";

			result = (List<SearchData>) jdbcTemplate.query(query, new Object[] {}, new SearchMapper());
			return result;
	}

	public void addToFavourities(String email,Integer id,Integer favoutId){

		int returnVal = jdbcTemplate.update("UPDATE content_feed_favourite SET isFavour =? WHERE user_email_id=? and content_feed_type_id =? ",favoutId,email,id);
		if(returnVal == 0){
			 returnVal = jdbcTemplate.update("insert into content_feed_favourite(isFavour,user_email_id,content_feed_type_id) values(?,?,?) ",favoutId,email,id);
		}
	}


 }

