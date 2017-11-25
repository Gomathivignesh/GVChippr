package com.hc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hc.enums.UserTypeEnums;
import com.hc.model.User;

public class CountMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rs.getInt("count");
	}

}
