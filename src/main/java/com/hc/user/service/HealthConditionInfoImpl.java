package com.hc.user.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hc.dao.UserDao;
import com.hc.model.*;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hc.dao.HealthConditionDao;

@Path("/health")
@Component
@Scope("request")
public class HealthConditionInfoImpl implements HealthConditionInfo{
	private static final Logger log = Logger.getLogger(HealthConditionInfoImpl.class);
	private HealthConditionDao hcDao;
	private UserDao userDao;

	public HealthConditionDao getHcDao() {
		return hcDao;
	}

	public void setHcDao(HealthConditionDao hcDao) {
		this.hcDao = hcDao;
	}


	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@GET
	@Path("conditions/{userEmail}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHealthConditions(@PathParam("userEmail") String userEmail) {
		log.info("In getHealthConditions method ");
		Response response = new Response();
		List<HealthCondition> hc = hcDao.getHealthConditionDao();
		List<User> getUserDetails = userDao.getUserByEmail(userEmail);
		if(hc != null && hc.size() > 0){
			Status status = new Status(true,StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setUser(getUserDetails.get(0));
			response.setStatus(status);
			response.setHc(hc);
		}else{
			Status status = new Status(false, StatusCodes.NO_RECORD_FOUND.code);
            response.setStatus(status);
		}

		return response;
	}


}
