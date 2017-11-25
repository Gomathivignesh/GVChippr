package com.hc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hc.model.WorkOutData;

public class DashBoardMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		WorkOutData workOut=new WorkOutData();
		
		workOut.setRange(rs.getString("range1"));
		workOut.setTotalTime(rs.getString("totalTime"));
		workOut.setIsOnDemand(rs.getInt("onDemand"));
		return workOut;
	}

}
