package com.hc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hc.model.Plan;

public class BodyPartMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Plan bodyPart = new Plan();

		bodyPart.setId(rs.getInt("id"));
		bodyPart.setName(rs.getString("name"));
		
		return bodyPart;
	}

}
