package com.hc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hc.model.WeekDetails;
import com.hc.model.WeeklyWorkOut;

public class WeekDetailsMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		WeekDetails weekDetails =new WeekDetails();
		weekDetails.setGoalWorkOut(rs.getString("goalWorkOut"));
		weekDetails.setCompletedWorkOut(rs.getString("completedWorkOut"));
		weekDetails.setWeekNumber(rs.getInt("weekNumber"));
		weekDetails.setGoal(rs.getString("Goal"));
		weekDetails.setScore(rs.getString("score"));
		weekDetails.setPlanName(rs.getString("planName"));

		return weekDetails;
	}

}
