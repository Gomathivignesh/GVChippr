package com.hc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hc.model.WeekDetails2;

public class WeekDetailsMapper2 implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		WeekDetails2 weekDetails =new WeekDetails2();
		weekDetails.setCompletedWorkOut(rs.getString("completedWorkOut"));
		weekDetails.setGoalWorkOut(rs.getString("goalWorkOut"));
		//weekDetails.setCatId(rs.getInt("catId"));
		weekDetails.setDayId(rs.getInt("dayId"));
		//weekDetails.setName(rs.getString("name"));
		//weekDetails.setGoal(rs.getString("goal"));
		weekDetails.setPlanName(rs.getString("planName"));
		weekDetails.setDayDesc(rs.getString("day_desc"));
		return weekDetails;
	}

}
