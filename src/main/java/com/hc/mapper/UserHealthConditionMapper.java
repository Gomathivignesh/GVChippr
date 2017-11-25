package com.hc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hc.model.HealthConditionForUser;
 
public class UserHealthConditionMapper implements RowMapper
{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		HealthConditionForUser heathcondition = new HealthConditionForUser();
		
		heathcondition.setConditions(rs.getString("conditions"));
		heathcondition.setDescription(rs.getString("description"));
		heathcondition.setCode(Integer.parseInt(rs.getString("code")));
		heathcondition.setUserHasCondition(rs.getString("userHasCondition")==null?false:true);
		
		return heathcondition;
	}
 
}
