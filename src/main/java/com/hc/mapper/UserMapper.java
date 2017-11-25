package com.hc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hc.enums.UserTypeEnums;
import com.hc.model.User;

public class UserMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();

		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setfName(rs.getString("fname"));
		user.setlName(rs.getString("lname"));
		user.setDob(rs.getDate("dob"));
		user.setGender(rs.getString("gender"));
		user.setUserType(UserTypeEnums.values()[rs.getInt("userType")]);
		user.setCalibration(rs.getString("calibFlag"));
		user.setHcFlag(rs.getString("hcFlag"));
		user.setTrailBeginDate(rs.getDate("trialBeginDate"));
		user.setTrialEndDate(rs.getDate("trialEndDate"));
		user.setSubsBeginDate(rs.getDate("subsBeginDate"));
		user.setSubsEndDate(rs.getDate("subsEndDate"));
		user.setAvailableGiftCount(rs.getInt("availableGiftCount"));
		user.setBtMorning(rs.getInt("btMorning"));
		user.setBtAfternoon(rs.getInt("btAfternoon"));
		user.setBtEvening(rs.getInt("btEvening"));
		user.setCurrentLevel(rs.getString("currentLevel"));
		user.setCurrentModule(rs.getString("currentModule"));
		user.setScore(rs.getInt("score"));
		user.setCycle(rs.getString("cycle"));
		user.setHeight(rs.getString("height"));
		user.setWeight(rs.getString("weight"));
		user.setBmi(rs.getString("bmi"));

		user.setSubsEndDateAsLong(user.getSubsEndDate() != null ? user
				.getSubsEndDate().getTime() : 0);
		user.setTrialEndDateAsLong(user.getTrialEndDate() != null ? user
				.getTrialEndDate().getTime() : 0);
		return user;
	}

}
