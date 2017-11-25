package com.hc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hc.model.MaxVideoWeekNo;
import com.hc.model.Plan;

public class MaxVideoWeekNoMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		MaxVideoWeekNo week = new MaxVideoWeekNo();

		week.setMaxVideoNo(rs.getInt("videoId"));
		week.setWeekNo(rs.getInt("weekNumber"));
		week.setCatId(rs.getInt("catId"));
		
		return week;
	}

}
