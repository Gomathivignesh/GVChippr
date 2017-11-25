package com.hc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hc.model.ChartData;

public class DashBoardChartMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ChartData workOut=new ChartData();
		
		workOut.setId(rs.getInt("id"));
		workOut.setName("");
		workOut.setTotalTime(rs.getString("totalTime"));
		workOut.setFromDate(rs.getString("FROM_DATE"));
		workOut.setToDate(rs.getString("TO_DATE"));
		workOut.setIsOnDemand(rs.getInt("onDemand"));
		return workOut;
	}

}
