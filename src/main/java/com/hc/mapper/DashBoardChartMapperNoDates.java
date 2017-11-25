package com.hc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hc.model.ChartData;
import com.hc.model.WorkOutData;

public class DashBoardChartMapperNoDates implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ChartData workOut=new ChartData();
		
		workOut.setId(rs.getInt("id"));
		workOut.setName(rs.getString("name"));
		workOut.setTotalTime(rs.getString("totalTime"));
		workOut.setIsOnDemand(rs.getInt("onDemand"));
		return workOut;
	}

}
