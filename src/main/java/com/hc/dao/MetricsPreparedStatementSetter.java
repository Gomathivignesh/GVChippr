package com.hc.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.lob.LobHandler;

import com.hc.model.User;

public class MetricsPreparedStatementSetter implements PreparedStatementSetter{
	private User user =null;
	private LobHandler lobHandler = null;
	
	public MetricsPreparedStatementSetter(User user, LobHandler lobHandler) {
		super();
		this.user = user;
		this.lobHandler = lobHandler;
	}

	@Override
	public void setValues(PreparedStatement ps) throws SQLException {
		ps.setString(1, user.getEmail());
		lobHandler.getLobCreator().setClobAsString(ps, 2,
				user.getMetrics());		
	}

}
