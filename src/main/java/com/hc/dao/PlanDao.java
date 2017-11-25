package com.hc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.google.gson.Gson;
import com.hc.enums.EmailTypeEnums;
import com.hc.enums.UserTypeEnums;
import com.hc.mail.SMTP;
import com.hc.mapper.BodyPartMapper;
import com.hc.mapper.PaymentHistoryMapper;
import com.hc.mapper.UserHealthConditionMapper;
import com.hc.mapper.UserMapper;
import com.hc.mapper.WorkOutMapper;
import com.hc.model.BreathCycle;
import com.hc.model.ContentFeed;
import com.hc.model.ContentFeedANDFavourrite;
import com.hc.model.ContentFeedComment;
import com.hc.model.ContentFeedFavourite;
import com.hc.model.ContentFeedUserLog;
import com.hc.model.CourseReview;
import com.hc.model.Courses;
import com.hc.model.GiftPurchaseInfoHistory;
import com.hc.model.Goal;
import com.hc.model.HCBTMap;
import com.hc.model.HealthCondition;
import com.hc.model.HealthConditionForUser;
import com.hc.model.PaymentInfo;
import com.hc.model.Plan;
import com.hc.model.ResetPassword;
import com.hc.model.Sequence;
import com.hc.model.SequenceMapping;
import com.hc.model.Statistics;
import com.hc.model.SystemPreferenceInfo;
import com.hc.model.User;
import com.hc.model.UserCourseLog;
import com.hc.model.UserGift;
import com.hc.model.UserHealthCondition;
import com.hc.model.UserLevel;
import com.hc.util.GenericProperties;
import com.hc.util.Query;
import com.hc.util.Util;
import com.hc.vo.ContentFeedCommentVO;

public class PlanDao {
	private static final Logger log = Logger.getLogger(PlanDao.class);
	private JdbcTemplate jdbcTemplate = null;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	/**
	 *
	 * @return
	 * @throws DataAccessException
	 */
	public List<Plan> getAllPlans()
			throws DataAccessException {
		long startTime = System.currentTimeMillis();
		List<Plan> plans = (List<Plan>) jdbcTemplate.query(Query.GET_ALL_PLAN_SQL,
				ParameterizedBeanPropertyRowMapper.newInstance(Plan.class));
		
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getAllPlans - " + afterQuery
				+ " millseconds");
		return plans;
	}

	/*public List<Goal> getWeeklyGoalMin(Integer planId)
		throws DataAccessException {
			long startTime = System.currentTimeMillis();
			
//			List<Goal> goals = jdbcTemplate.query(Query.GET_GOAL_BASE_ON_PLAN,
//					ParameterizedBeanPropertyRowMapper.newInstance(Goal.class),planId.toString());
		//	List<Goal> goals = (List<Goal>) jdbcTemplate.query(Query.GET_GOAL_BASE_ON_PLAN,
					new Object[] { planId }, new PlanCatMapper());
			
		//	long afterQuery = System.currentTimeMillis() - startTime;
		//	log.info("Query Execution time getWeeklyGoalMin - " + afterQuery
			//		+ " millseconds");
			return goals;
	}*/

	

	public List<Plan> getWorkOutType(Integer id)throws DataAccessException {
		long startTime = System.currentTimeMillis();
		List<Plan> workOutTypes = (List<Plan>) jdbcTemplate.query(Query.GET_WORKTYPE_BASE_ON_PLAN,
				new Object[] { id }, new WorkOutMapper());
		
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getWorkOutType - " + afterQuery
				+ " millseconds");
		return workOutTypes;
	}

	public List<Plan> getBodyPartTypes() throws DataAccessException {
		long startTime = System.currentTimeMillis();
		List<Plan> bodyParts = (List<Plan>) jdbcTemplate.query(Query.GET_BODYPARTS,
				new Object[] { }, new BodyPartMapper());
		
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getBodyPartTypes - " + afterQuery
				+ " millseconds");
		return bodyParts;
	}

	public List<Plan> getAllEquipments() throws DataAccessException {
		long startTime = System.currentTimeMillis();
		List<Plan> equipments = (List<Plan>) jdbcTemplate.query(Query.GET_EQUIPMENTS,
				new Object[] { }, new BodyPartMapper());
		
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getBodyPartTypes - " + afterQuery
				+ " millseconds");
		return equipments;
	}
	
}
