package com.hc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.hc.model.HealthCondition;
import com.hc.util.Query;

public class HealthConditionDao {
	private static final Logger log = Logger.getLogger(HealthConditionDao.class);
	private JdbcTemplate jdbcTemplate = null;
	
	public void setDataSource(DataSource dataSource) {
	    this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * @return
	 * @throws DataAccessException
	 */
	public List<HealthCondition> getHealthConditionDao() throws DataAccessException {
		long startTime = System.currentTimeMillis();
		List<HealthCondition> healthCondition = jdbcTemplate.query(Query.GET_HC_SQL,
				ParameterizedBeanPropertyRowMapper.newInstance(HealthCondition.class));
		long afterQuery = System.currentTimeMillis() - startTime;
		log.info("Query Execution time getHealthCondition - " + afterQuery
				+ " millseconds");
		return healthCondition;
	}

}
