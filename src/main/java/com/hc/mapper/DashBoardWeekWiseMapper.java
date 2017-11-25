package com.hc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hc.model.WorkOutData;

public class DashBoardWeekWiseMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		WorkOutData workOut=new WorkOutData();
		
		workOut.setPlanName(rs.getString("planName"));
		workOut.setWorkOutName(rs.getString("workOutName"));
		workOut.setDuration(rs.getString("duration_time"));
		workOut.setCompletionMin(rs.getString("watchedTime"));	
		workOut.setCatId(rs.getInt("catId"));
		workOut.setLastUpdated(rs.getString("lastUpdated"));
		workOut.setLastUpdated(rs.getString("lastUpdated"));
		workOut.setIsCompleted(rs.getInt("isCompleted"));
		workOut.setIsOnDemand(rs.getInt("onDemand"));
		return workOut;
	}

}
