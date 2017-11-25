package com.hc.user.service;


import java.util.List;
import java.util.ResourceBundle;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import com.hc.dao.PlanDao;
import com.hc.dao.UserDao;




@Path("/plan")
@Component
@Scope("request")
@Produces(MediaType.APPLICATION_JSON)
public class PlanInfoImpl {
	private static final Logger log = Logger.getLogger(PlanInfoImpl.class);
	private PlanDao planInfo;
	private ResourceBundle rb = ResourceBundle.getBundle("message");

	/*@GET
	@Path("getAllPlans")
	@Scope("request")
	public Response getAllPlans() {
		Response response = new Response();
		
		try {
			System.out.println("======="+planInfo);
			PlanDao pd=new PlanDao();
				List<Plan> plans = pd.getAllPlans();
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
				response.setPlans(plans);
		} catch (DuplicateKeyException e) {
			log.error(e);
			Status status = new Status(true, rb.getString("USER_EXISTS"),
					StatusCodes.DATA_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, e.getLocalizedMessage(),
					StatusCodes.DATA_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		}
		return response;
	}
	
	@GET
	@Path("getWeeklyGoalMin/{planid}")
	public Response getWeeklyGoalMin(@PathParam("planid") Integer id) {
		Response response = new Response();
		
		try {
				List<Goal> goals = planInfo.getWeeklyGoalMin(id);
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
				response.setGoals(goals);
		} catch (DuplicateKeyException e) {
			log.error(e);
			Status status = new Status(true, rb.getString("USER_EXISTS"),
					StatusCodes.DATA_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, e.getLocalizedMessage(),
					StatusCodes.DATA_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		}
		return response;
	}
	
	@GET
	@Path("getWorkOutType/{planid}")
	public Response getWorkOutType(@PathParam("planid") Integer id) {
		Response response = new Response();
		
		try {
				List<Plan> workOutTypes = planInfo.getWorkOutType(id);
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
				response.setPlans(workOutTypes);
		} catch (DuplicateKeyException e) {
			log.error(e);
			Status status = new Status(true, rb.getString("USER_EXISTS"),
					StatusCodes.DATA_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, e.getLocalizedMessage(),
					StatusCodes.DATA_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		}
		return response;
	}
	
	@GET
	@Path("getAllBodyParts")
	public Response getBodyPartTypes() {
		Response response = new Response();
		
		try {
				List<Plan> bodyParts = planInfo.getBodyPartTypes();
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
				response.setPlans(bodyParts);
		} catch (DuplicateKeyException e) {
			log.error(e);
			Status status = new Status(true, rb.getString("USER_EXISTS"),
					StatusCodes.DATA_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, e.getLocalizedMessage(),
					StatusCodes.DATA_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		}
		return response;
	}
	
	@GET
	@Path("getAllEquipments")
	public Response getAllEquipments() {
		Response response = new Response();
		
		try {
				List<Plan> equipments = planInfo.getAllEquipments();
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
				response.setPlans(equipments);
		} catch (DuplicateKeyException e) {
			log.error(e);
			Status status = new Status(true, rb.getString("USER_EXISTS"),
					StatusCodes.DATA_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, e.getLocalizedMessage(),
					StatusCodes.DATA_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		}
		return response;
	}*/
	
	
	public PlanDao getPlanInfo() {
		return planInfo;
	}

	public void setPlanInfo(PlanDao planInfo) {
		this.planInfo = planInfo;
	}
}