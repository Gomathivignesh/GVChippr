package com.hc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hc.model.Plan;

public class WorkOutMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Plan workOut = new Plan();

		workOut.setId(rs.getInt("typeId"));
		workOut.setName(rs.getString("name"));
		
		return workOut;
	}

}
