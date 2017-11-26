package com.hc.user.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.hc.model.*;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hc.dao.UserDao;
import com.hc.enums.EmailTypeEnums;
import com.hc.mail.SMTP;
import com.hc.payment.model.PaymentRequest;
import com.hc.payment.model.PaymentResponse;
import com.hc.payment.service.PaymentProcessImpl;
import com.hc.util.BeanUtils;
import com.hc.util.GenericProperties;
import com.hc.util.SortVideos;
import com.hc.util.SortVideos1;
import com.hc.util.Util;
import com.hc.vo.ContentFeedANDFavourriteVO;
import com.hc.vo.ContentFeedCommentVO;

@Path("/user")
@Component
@Scope("request")
@Produces(MediaType.APPLICATION_JSON)
public class UserInfoImpl implements UserInfo {

	private static final Logger log = Logger.getLogger(UserInfoImpl.class);
	private UserDao userDao;
	private ResourceBundle rb = ResourceBundle.getBundle("message");
	private Util util;
	private static Random rand = new Random();



	@POST
	@Path("signup")
	public Response addUser(@RequestBody User user) {
		Response response = new Response();
		log.info("In addUser method ");
		int returnVal = 0;
		try {
			returnVal = userDao.addUser(user);
			if (returnVal == 1) {
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
			}
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
		} catch (ParseException e) {
			log.error(e);
			Status status = new Status(true, e.getMessage(),
					StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		}
		return response;
	}


	@POST
	@Path("signin")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUser(@RequestBody User user) {
		log.info("In getUser method ");
		Response response = new Response();
		String email = user.getEmail();
		String pwd = user.getPwd();
		List<User> userDetails = userDao.getUser(email, pwd);
		if (userDetails != null && userDetails.size() > 0) {
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
			response.setUser(userDetails.get(0));
		} else {
			Status status = new Status(false, rb.getString("NO_RECORD_FOUND"),
					StatusCodes.NO_RECORD_FOUND.code);
			response.setStatus(status);
		}
		return response;
	}

	@POST
	@Path("facebookSignin")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserbyEmail(@RequestBody User user) {
		log.info("In getUser method ");
		Response response = new Response();
		String email = user.getEmail();
		List<User> userDetails = userDao.getFBUser(email);
		if (userDetails != null && userDetails.size() > 0) {
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
			response.setUser(userDetails.get(0));
		} else {
			Status status = new Status(false, rb.getString("NO_RECORD_FOUND"),
					StatusCodes.NO_RECORD_FOUND.code);
			response.setStatus(status);
		}
		return response;
	}


	@POST
	@Path("changepwd")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePwd(@RequestBody User user)
			throws DataAccessException, ParseException {
		log.info("In updatePwd method ");
		Response response = new Response();
		int returnVal = userDao.changePwd(user);
		if (returnVal == 1) {
			Status status = new Status(true, rb.getString("PWD_UPDATED"),
					StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
		} else {
			Status status = new Status(true, rb.getString("NO_RECORD_FOUND"),
					StatusCodes.NO_RECORD_FOUND.code);
			status.setSuccess(false);
			response.setStatus(status);
		}
		return response;
	}


	@POST
	@Path("update/profile")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(@RequestBody User user) {
		log.info("In updateUser method ");
		Response response = new Response();
		int returnVal = 0;
		try {
			returnVal = userDao.updateUser(user);
			if (returnVal == 1) {
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
			} else {
				Status status = new Status(false,
						rb.getString("NO_RECORD_FOUND"),
						StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
			}
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, rb.getString("DATA_ERROR"),
					StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		} catch (ParseException e) {
			log.error(e);
			Status status = new Status(true, e.getMessage(),
					StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		}
		return response;
	}

	@POST
	@Path("forgetPwd")
	@Consumes(MediaType.APPLICATION_JSON)
	public User getPwd(@RequestBody User user) throws DataAccessException,
			ParseException {
		List<User> userDetails = userDao.getPwd(user);
		if (userDetails != null && userDetails.size() > 0) {
			user = userDetails.get(0);
		}
		return user;
	}

//	/**
//	 * @param user
//	 * @return
//	 * @throws ParseException
//	 * @throws DataAccessException
//	 */
	@GET
	@Path("eligibility/{email}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getEligibility(@PathParam("email") String email) {
		log.info("In getEligibility method ");
		Response response = new Response();
		List<User> userDetails = null;
		try {
			userDetails = userDao.getEligibility(email);
			if (userDetails != null && userDetails.size() > 0) {
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
				response.setUser(userDetails.get(0));
			} else {
				log.debug("User not found " + email);
				Status status = new Status(false,
						rb.getString("NO_RECORD_FOUND"),
						StatusCodes.NO_RECORD_FOUND.code);
				response.setStatus(status);
			}
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, rb.getString("INTERNAL_ERROR"),
					StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		} catch (ParseException e) {
			log.error(e);
			Status status = new Status(true, rb.getString("INTERNAL_ERROR"),
					StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		}
		return response;
	}

	@POST
	@Path("update/condition")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUserHC(@RequestBody User user) {
		log.info("In updateUserHC method ");
		Response response = new Response();
		int returnVal = 0;
		try {
			returnVal = userDao.updateUserHC(user);
			if (returnVal >= 1) {
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
			} else {
				log.debug("User not found " + user.getEmail());
				Status status = new Status(false,
						rb.getString("NO_RECORD_FOUND"),
						StatusCodes.NO_RECORD_FOUND.code);
				response.setStatus(status);
			}
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		} catch (ParseException e) {
			log.error(e);
			Status status = new Status(true, StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		}
		return response;
	}

	@POST
	@Path("update/subscription")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUserSubscription(@RequestBody User user) {
		log.info("In update subscription method ");
		Response response = new Response();
		int returnVal = 0;
		try {
			returnVal = userDao.updateUserSubscription(user);
			if (returnVal == 1) {
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
				// Get the corresponding user
				List<User> userList = userDao.getUserByEmail(user.getEmail());
				if (userList.size() == 0) {
					response.setUser(null);
				}
				response.setUser(userList.get(0));
			} else {
				log.debug("User not found " + user.getEmail());
				Status status = new Status(false,
						rb.getString("NO_RECORD_FOUND"),
						StatusCodes.NO_RECORD_FOUND.code);
				response.setStatus(status);
			}
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		} catch (ParseException e) {
			log.error(e);
			Status status = new Status(true, StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		}
		return response;
	}

	@POST
	@Path("update/metrics")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUserMetrics(@RequestBody User user) {
		log.info("In updateUserMetrics method ");
		Response response = new Response();
		int returnVal = 0;
		try {
			// TODO 03/16/2014 Cycle & Ratio hardcoded as on now
			/*
			 * Removed default value on 02172015 user.setCycle("20");
			 * user.setRatio("2:2");
			 */
			List<Metrics> metricsInfo = user.getCycleRatio();
			int totalInhale = 0, totalExhale = 0;
			System.out
					.println(metricsInfo + "metricsInfo" + metricsInfo.size());
			for (Metrics metrics : metricsInfo) {
				if (metrics.getInHaleTime() != null
						&& !metrics.getInHaleTime().equals("")) {
					totalInhale += Integer.parseInt(metrics.getInHaleTime());
				}
				if (metrics.getExHaleTime() != null
						&& !metrics.getExHaleTime().equals("")) {
					totalExhale += Integer.parseInt(metrics.getExHaleTime());
				}
			}
			// The min cycle is set to 6 as per db value
			int defaultCycle = Math.round(metricsInfo.size() >= 6 ? metricsInfo
					.size() : 6);
			// If the value is odd then make it to even
			if (defaultCycle % 2 != 0) {
				defaultCycle += 1;
			}
			user.setCycle((metricsInfo == null || metricsInfo.isEmpty()) ? "24"
					: Integer.toString(defaultCycle));
			user.setRatio(totalInhale + ":" + totalExhale);
			returnVal = userDao.updateCalibration(user);
			userDao.setBtStatusToCurrentWorkOut(user.getId());
			if (returnVal >= 1) {
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
			} else {
				log.debug("User not found " + user.getEmail());
				Status status = new Status(false,
						rb.getString("NO_RECORD_FOUND"),
						StatusCodes.NO_RECORD_FOUND.code);
				response.setStatus(status);
			}
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
			e.printStackTrace();
		} catch (ParseException e) {
			log.error(e);
			Status status = new Status(true, StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
			e.printStackTrace();
		}
		return response;
	}

	@POST
	@Path("add/course/log")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertUserCourseLog(@RequestBody User user) {
		log.info("In insertUserCourseLog method ");
		Response response = new Response();
		int returnVal = 0;
		try {
			returnVal = userDao.insertUserCourseLog_V1(user);
			if (returnVal >= 1) {
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
				List<User> userDetails = userDao.getUserFullDetails(user
						.getEmail());
				if (!userDetails.isEmpty()) {
					response.setUser(userDetails.get(0));
				}
			} else {
				log.debug("User not found " + user.getEmail());
				Status status = new Status(false,
						rb.getString("NO_RECORD_FOUND"),
						StatusCodes.NO_RECORD_FOUND.code);
				response.setStatus(status);
			}
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		} catch (ParseException e) {
			log.error(e);
			Status status = new Status(true, StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		}
		return response;
		/*
		 * log.info("In insertUserCourseLog method "); Response response = new
		 * Response(); int returnVal = 0; try { returnVal =
		 * userDao.insertUserCourseLog(user); if (returnVal >= 1) { Status
		 * status = new Status(true, StatusCodes.SUCCESS.code);
		 * status.setSuccess(true); response.setStatus(status); List<User>
		 * userDetails = userDao.getUserFullDetails(user .getEmail()); if
		 * (!userDetails.isEmpty()) { response.setUser(userDetails.get(0)); } }
		 * else { log.debug("User not found " + user.getEmail()); Status status
		 * = new Status(false, rb.getString("NO_RECORD_FOUND"),
		 * StatusCodes.NO_RECORD_FOUND.code); response.setStatus(status); } }
		 * catch (DataAccessException e) { log.error(e); Status status = new
		 * Status(true, StatusCodes.INTERNAL_ERROR.code);
		 * status.setSuccess(false); response.setStatus(status); } catch
		 * (ParseException e) { log.error(e); Status status = new Status(true,
		 * StatusCodes.INTERNAL_ERROR.code); status.setSuccess(false);
		 * response.setStatus(status); } return response;
		 */
	}

	@POST
	@Path("add/course/review")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertCourseReview(@RequestBody User user) {
		log.info("In insertCourseReview method ");
		Response response = new Response();
		int returnVal = 0;
		try {
			returnVal = userDao.insertCourseReview(user);
			if (returnVal == 1) {
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
			} else {
				log.debug("User not found " + user.getEmail());
				Status status = new Status(false,
						rb.getString("NO_RECORD_FOUND"),
						StatusCodes.NO_RECORD_FOUND.code);
				response.setStatus(status);
			}
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		} catch (ParseException e) {
			log.error(e);
			Status status = new Status(true, StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		}
		return response;
	}

	/**
//	 * @param user
	 * @return
	 * @throws ParseException
	 * @throws DataAccessException
	 */
	@GET
	@Path("courses/{email}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getCorses(@PathParam("email") String email) {
		Response response = new Response();

		List<User> userList = userDao.getUserByEmail(email);
		if (userList == null || userList.isEmpty()) {
			Status status = new Status(false, "User Not found",
					StatusCodes.NO_RECORD_FOUND.code);
			response.setStatus(status);
			return response;
		}
		User currUser = userList.get(0);

		// 1. Get the current level and module for the user
		if (currUser == null || currUser.getCurrentLevel() == null
				|| currUser.getCurrentModule() == null) {
			Status status = new Status(false,
					"Invalid User - Level/Module missing",
					StatusCodes.NO_RECORD_FOUND.code);
			response.setStatus(status);
			return response;
		}

		System.err.println(currUser.getCurrentLevel() + " - "
				+ currUser.getCurrentModule());

		// 2. Get the health conditions for the user from userhc table
		List<HealthCondition> userHealthConditionList = userDao
				.getUserHealthConditions(email);

		// 3. For each #2 get all the breathing techniques from hc bt map table
		List<Integer> healthConditionList = new ArrayList<Integer>();
		for (HealthCondition healthCondition : userHealthConditionList) {
			healthConditionList.add(healthCondition.getId());
		}

		if (healthConditionList.isEmpty()) {
			Status status = new Status(false, "No User Health Condition Found",
					StatusCodes.NO_RECORD_FOUND.code);
			response.setStatus(status);
			return response;
		}

		List<HCBTMap> hcbtMapList = userDao
				.getHealthConditionBtMap(healthConditionList);

		if (hcbtMapList.isEmpty()) {
			Status status = new Status(false, "No Breathing technique found",
					StatusCodes.NO_RECORD_FOUND.code);
			response.setStatus(status);
			return response;
		}

		// 4. for each #2 get the exclusion from exclusion map table
		List<String> exclusionList = userDao.getExclusionBtCodes(
				healthConditionList, currUser.getCurrentModule(),
				currUser.getCurrentLevel());

		// 5 - #3 - #4
		Iterator<HCBTMap> iterator = hcbtMapList.iterator();
		System.err.println("Before - " + hcbtMapList.size());
		List<String> allowedMorningBtIds = new ArrayList<String>();
		List<String> allowedEveningBtIds = new ArrayList<String>();
		List<String> allowedAfternoonBtIds = new ArrayList<String>();
		while (iterator.hasNext()) {
			HCBTMap hCBTMap = iterator.next();
			if (exclusionList.contains(hCBTMap.getBtCode())) {
				iterator.remove();
			} else {
				if (hCBTMap.getTimeOfDay().equalsIgnoreCase("M")) {
					allowedMorningBtIds.add(hCBTMap.getBtCode());
				}
				if (hCBTMap.getTimeOfDay().equalsIgnoreCase("A")) {
					allowedAfternoonBtIds.add(hCBTMap.getBtCode());
				}
				if (hCBTMap.getTimeOfDay().equalsIgnoreCase("E")) {
					allowedEveningBtIds.add(hCBTMap.getBtCode());
				}
			}
		}
		System.err.println("After - " + hcbtMapList.size());
		System.err.println(allowedMorningBtIds.size() + " "
				+ allowedAfternoonBtIds.size() + " "
				+ allowedEveningBtIds.size());

		// 6 - Fetch the breathing techniques
		List<Courses> selectedCourses = new ArrayList<Courses>();
		if (!allowedMorningBtIds.isEmpty()) {
			List<Courses> courses = userDao.getCourses(allowedMorningBtIds,
					currUser.getCurrentModule(), currUser.getCurrentLevel());
			if (!courses.isEmpty()) {
				Courses currCourse = courses
						.get(randInt(0, courses.size() - 1));
				currCourse.setCourseDay("M");
				currCourse.setBreathCycle(currCourse.getBreathSequence());

				String nameBT = (currCourse.getName() != null && !currCourse
						.getName().equalsIgnoreCase("")) ? currCourse.getName()
						: "";
				String nameModuleBT = (currCourse.getNameOfTech() != null && !currCourse
						.getNameOfTech().equalsIgnoreCase("")) ? currCourse
						.getNameOfTech() : "";

				if (!nameBT.equalsIgnoreCase("")
						&& !nameModuleBT.equalsIgnoreCase(""))
					currCourse.setName(nameBT + ": " + nameModuleBT);
				else {
					currCourse.setName(nameBT + "" + nameModuleBT);
				}

				currCourse
						.setDescription((currCourse.getBtDesc() != null ? currCourse
								.getBtDesc() : "")
								+ " "
								+ (currCourse.getDescription() != null ? currCourse
										.getDescription() : ""));
				currCourse.setAnimationLink(currCourse.getVideoLink());
				selectedCourses.add(currCourse);
			}
		}

		if (!allowedAfternoonBtIds.isEmpty()) {
			List<Courses> courses = userDao.getCourses(allowedAfternoonBtIds,
					currUser.getCurrentModule(), currUser.getCurrentLevel());
			if (!courses.isEmpty()) {
				Courses currCourse = courses
						.get(randInt(0, courses.size() - 1));
				currCourse.setCourseDay("A");

				String nameBT = (currCourse.getName() != null && !currCourse
						.getName().equalsIgnoreCase("")) ? currCourse.getName()
						: "";
				String nameModuleBT = (currCourse.getNameOfTech() != null && !currCourse
						.getNameOfTech().equalsIgnoreCase("")) ? currCourse
						.getNameOfTech() : "";

				if (!nameBT.equalsIgnoreCase("")
						&& !nameModuleBT.equalsIgnoreCase(""))
					currCourse.setName(nameBT + ": " + nameModuleBT);
				else {
					currCourse.setName(nameBT + "" + nameModuleBT);
				}
				currCourse
						.setDescription((currCourse.getBtDesc() != null ? currCourse
								.getBtDesc() : "")
								+ " "
								+ (currCourse.getDescription() != null ? currCourse
										.getDescription() : ""));
				currCourse.setAnimationLink(currCourse.getVideoLink());
				currCourse.setBreathCycle(currCourse.getBreathSequence());
				selectedCourses.add(currCourse);
			}
		}

		if (!allowedEveningBtIds.isEmpty()) {
			List<Courses> courses = userDao.getCourses(allowedEveningBtIds,
					currUser.getCurrentModule(), currUser.getCurrentLevel());
			if (!courses.isEmpty()) {
				Courses currCourse = courses
						.get(randInt(0, courses.size() - 1));
				currCourse.setCourseDay("E");

				String nameBT = (currCourse.getName() != null && !currCourse
						.getName().equalsIgnoreCase("")) ? currCourse.getName()
						: "";
				String nameModuleBT = (currCourse.getNameOfTech() != null && !currCourse
						.getNameOfTech().equalsIgnoreCase("")) ? currCourse
						.getNameOfTech() : "";

				if (!nameBT.equalsIgnoreCase("")
						&& !nameModuleBT.equalsIgnoreCase(""))
					currCourse.setName(nameBT + ": " + nameModuleBT);
				else {
					currCourse.setName(nameBT + "" + nameModuleBT);
				}
				currCourse
						.setDescription((currCourse.getBtDesc() != null ? currCourse
								.getBtDesc() : "")
								+ " "
								+ (currCourse.getDescription() != null ? currCourse
										.getDescription() : ""));
				currCourse.setAnimationLink(currCourse.getVideoLink());
				currCourse.setBreathCycle(currCourse.getBreathSequence());
				selectedCourses.add(currCourse);
			}
		}

		/*
		 * try { List<Courses> courses = userDao.getCourses(email); if (courses
		 * != null && courses.size() > 0) { List<Courses> courseList = new
		 * ArrayList<Courses>(); courseList.addAll(courses); Status status = new
		 * Status(true, StatusCodes.SUCCESS.code); status.setSuccess(true);
		 * response.setStatus(status); response.setCourses(courseList); } else {
		 * log.debug("User not found " + email); Status status = new
		 * Status(false, rb.getString("NO_COURSE"),
		 * StatusCodes.NO_RECORD_FOUND.code); response.setStatus(status); } }
		 * catch (DataAccessException e) { log.error(e); Status status = new
		 * Status(true, rb.getString("NO_COURSE"),
		 * StatusCodes.INTERNAL_ERROR.code); status.setSuccess(false);
		 * response.setStatus(status); } catch (ParseException e) {
		 * log.error(e); Status status = new Status(true,
		 * StatusCodes.INTERNAL_ERROR.code); status.setSuccess(false);
		 * response.setStatus(status); }
		 */
		Status status = new Status(true, StatusCodes.SUCCESS.code);
		status.setSuccess(true);
		response.setStatus(status);
		response.setCourses(selectedCourses);
		return response;
	}

	/**
//	 * @param user
	 * @return
	 * @throws ParseException
	 * @throws DataAccessException
	 */
	@GET
	@Path("course/description/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getCorsesDesc(@PathParam("id") String id) {
		Response response = new Response();
		try {
			List<Courses> courses = userDao.getCoursesDesc(id);
			log.info("id " + id + " Courses : " + courses.size());
			if (courses != null && courses.size() > 0) {
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
				response.setCourses(courses);
			} else {
				Status status = new Status(false, rb.getString("NO_COURSE"),
						StatusCodes.NO_RECORD_FOUND.code);
				response.setStatus(status);
			}
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		} catch (ParseException e) {
			log.error(e);
			Status status = new Status(true, StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		}
		return response;
	}

	/**
//	 * @param user
	 * @return
	 * @throws ParseException
	 * @throws DataAccessException
	 */
	@GET
	@Path("course/reviews/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCourseReviews(@PathParam("id") String id)
			throws DataAccessException, ParseException {
		log.info("In getCourseReviews method ");
		Response response = new Response();
		List<CourseReview> reviews = userDao.getCourseReview(id);
		if (reviews != null && reviews.size() > 0) {
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
			response.setCourseReviews(reviews);
		} else {
			Status status = new Status(false, rb.getString("NO_COURSE"),
					StatusCodes.NO_RECORD_FOUND.code);
			response.setStatus(status);
		}
		return response;
	}

	public UserDao getUserInfo() {
		return userDao;
	}

	public void setUserInfo(UserDao userInfo) {
		this.userDao = userInfo;
	}

	@POST
	@Path("update/paymenthistory")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPaymentInformation(@RequestBody PaymentInfo payment) {
		Response response = new Response();
		log.info("In payment add method ");
		int returnVal = 0;
		try {
			returnVal = userDao.addPaymentInformation(payment);
			if (returnVal == 1) {
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
			}
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, e.getLocalizedMessage(),
					StatusCodes.DATA_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		} catch (ParseException e) {
			log.error(e);
			Status status = new Status(true, e.getMessage(),
					StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		}
		return response;
	}

	@POST
	@Path("giftPurchase")
	public Response addGiftPurchaseInfo(
			@RequestBody GiftPurchaseInfoHistory giftInfo) {
		Response response = new Response();
		log.info("In gift add method ");
		int returnVal = 0;
		try {
			returnVal = userDao.addGiftPurchaseInformation(giftInfo);
			if (returnVal == 1) {
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
			}
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, e.getLocalizedMessage(),
					StatusCodes.DATA_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		} catch (ParseException e) {
			log.error(e);
			Status status = new Status(true, e.getMessage(),
					StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		}
		return response;
	}

	@POST
	@Path("payment/history")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPaymentHistory(@RequestBody User user)
			throws DataAccessException, ParseException {
		log.info("In get payment history method ");
		Response response = new Response();
		List<PaymentInfo> paymentInfo = userDao.getPaymentHistory(user);
		if (paymentInfo != null && paymentInfo.size() > 0) {
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
			response.setPaymentInfo(paymentInfo);
		} else {
			Status status = new Status(false,
					rb.getString("NO_PAYMENT_HISTORY"),
					StatusCodes.NO_RECORD_FOUND.code);
			response.setStatus(status);
		}
		return response;
	}

	@POST
	@Path("gifts/send")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendGifts(@RequestBody GiftUserInfo giftInfo)
			throws DataAccessException, ParseException {
		Response response = new Response();
		util = Util.getInstance();
		String sendTo = null;
		Iterator<String> iterator = giftInfo.getSentTo().iterator();
		List<String> errorList = new ArrayList<String>();
		while (iterator.hasNext()) {
			// Check if the email is already registered
			sendTo = iterator.next();
			List<User> user = userDao.getUserByEmail(sendTo);
			if (user.size() > 0) {
				errorList.add(sendTo);
			} else {
				String token = util.generateToken();
				userDao.sendUserGift(sendTo, giftInfo.getSentFrom(), token);
				// send email to the user
				String GIFT_REGISTER = rb.getString("WEB_URL")
						+ rb.getString("REGISTER");
				String body = "Your friend " + giftInfo.getSentFromEmail()
						+ " has sent a gift. Click <a href=\"" + GIFT_REGISTER
						+ token + "\">here</a>  to redeem.";
				new Thread(new SMTP(sendTo, "101 Years Gift send from - "
						+ giftInfo.getSentFromEmail(), body)).start();
			}
		}
		if (errorList.size() == 0) {
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
		} else {
			Status status = new Status(false, rb.getString("GIFT_SEND_ERROR")
					+ " " + errorList, StatusCodes.VALIDATION_ERROR.code);
			response.setStatus(status);
		}
		return response;
	}

	@GET
	@Path("gift/available/{id}")
	public Response getAvailableGiftForUser(@PathParam("id") int id) {
		log.info("In get available gift ");
		Response response = new Response();
		Status status = new Status(true, StatusCodes.SUCCESS.code);
		status.setSuccess(true);
		response.setStatus(status);
		response.setAvailableUserGift(userDao.getAvailableUserGift(id));
		return response;
	}

	@GET
	@Path("gift/pending/{id}")
	public Response getPendingGiftForUser(@PathParam("id") int id) {
		log.info("In get available gift ");
		Response response = new Response();
		Status status = new Status(true, StatusCodes.SUCCESS.code);
		status.setSuccess(true);
		response.setStatus(status);
		response.setAvailableUserGift(userDao.getPendingUserGift(id));
		return response;
	}

	@GET
	@Path("gift/processed/{id}")
	public Response getProcessedGiftForUser(@PathParam("id") int id) {
		log.info("In get available gift ");
		Response response = new Response();
		Status status = new Status(true, StatusCodes.SUCCESS.code);
		status.setSuccess(true);
		response.setStatus(status);
		response.setAvailableUserGift(userDao.getProcessedUserGift(id));
		return response;
	}

	@POST
	@Path("resetPassword")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response resetPassword(@RequestBody ResetPassword resetPassword)
			throws DataAccessException, ParseException {
		log.info("In reset password method ");
		Response response = new Response();
		int returnVal;

		List<User> userList = userDao.getUserByEmail(resetPassword.getEmail());
		if (userList.size() == 0) {
			Status status = new Status(true, rb.getString("EMAIL_NOT_FOUND"),
					StatusCodes.NO_RECORD_FOUND.code);
			status.setSuccess(false);
			response.setStatus(status);
		} else {
			User user = userList.get(0);
			List<ResetPassword> resetPwdInfoList = userDao
					.getPendingResetPassword(user.getId());
			util = Util.getInstance();
			String token = util.generateToken();
			if (resetPwdInfoList.size() == 0) {
				returnVal = userDao.addResetPwdToken(user.getId(), token);
			} else {
				ResetPassword resetPwdInfo = resetPwdInfoList.get(0);
				token = resetPwdInfo.getResetToken();
			}
			// send email to the user
			String RESET_PWD = rb.getString("WEB_URL")
					+ rb.getString("RESET_PWD");
			String body = "Click  <a href=\"" + RESET_PWD + token
					+ "\">here</a> to reset your password. ";
			new Thread(new SMTP(user.getEmail(), "101 Years - Reset Password",
					body)).start();

			Status status = new Status(true, rb.getString("RESET_PWD_INFO"),
					StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
		}
		return response;
	}

	@POST
	@Path("resetMyPassword")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response resetMyPassword(@RequestBody ResetPassword resetPassword)
			throws DataAccessException, ParseException {
		log.info("In reset my password method ");
		Response response = new Response();

		int returnVal = userDao.updatePasswordToken(resetPassword);
		Status status = null;
		if (returnVal > 0) {
			status = new Status(true, rb.getString("PWD_RESET"),
					StatusCodes.SUCCESS.code);
			status.setSuccess(true);
		} else {
			status = new Status(true, rb.getString("INVALID_RESET_TOKEN"),
					StatusCodes.NO_RECORD_FOUND.code);
			status.setSuccess(false);
		}
		response.setStatus(status);
		return response;
	}

	@GET
	@Path("/{email}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserInfo(@PathParam("email") String email) {
		log.info("In getUserInfo method ");
		Response response = new Response();
		List<User> userDetails = userDao.getUserByEmail(email);
		if (userDetails != null && userDetails.size() > 0) {
			response.setUser(userDetails.get(0));
		} else {
			Status status = new Status(false, rb.getString("NO_RECORD_FOUND"),
					StatusCodes.NO_RECORD_FOUND.code);
			response.setStatus(status);
		}
		return response;
	}

	@POST
	@Path("processPayment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response processPayment(@RequestBody PaymentRequest paymentRequest)
			throws DataAccessException, ParseException, Exception {
		log.info("In process payment method ");
		Response response = new Response();
		PaymentProcessImpl paymentProcessImpl = PaymentProcessImpl
				.getInstance();
		PaymentResponse paymentResponse = paymentProcessImpl
				.processPayment(paymentRequest);
		Status status = new Status(true, "", StatusCodes.SUCCESS.code);
		status.setSuccess(true);
		response.setPaymentResponse(paymentResponse);
		response.setStatus(status);
		return response;
	}

	@GET
	@Path("stats/{email}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserStats(@PathParam("email") String email) {
		log.info("In getUserStats method ");
		Response response = new Response();
		List<Statistics> userStats = userDao.getUserStats(email);
		if (userStats != null && userStats.size() > 0) {
			response.setUserStats(userStats);
		} else {
			Status status = new Status(false, rb.getString("NO_RECORD_FOUND"),
					StatusCodes.NO_RECORD_FOUND.code);
			response.setStatus(status);
		}
		return response;
	}

	/*
	 * @GET
	 * 
	 * @Path("healthconditions/{email}")
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON) public Response
	 * getUserHealthCondition(@PathParam("email") String email) {
	 * log.info("In get user health condition "); Response response = new
	 * Response(); Status status = new Status(true, StatusCodes.SUCCESS.code);
	 * status.setSuccess(true); response.setStatus(status);
	 * response.setHealthCondition(userDao.getUserHealthConditions(email));
	 * return response; }
	 */

	/*
	 * This returns all the health conditions with a flag denoting if the user
	 * has that health condition or not
	 */
	@GET
	@Path("healthconditions/{email}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserHealthCondition(@PathParam("email") String email) {
		log.info("In get user health condition ");
		Response response = new Response();

		List<User> userDetails = userDao.getUserByEmail(email);
		if (userDetails != null && userDetails.size() > 0) {
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
			response.setBmi(userDetails.get(0).getBmi());
			response.setHealthCondition(userDao
					.getUserHealthConditions(userDetails.get(0).getId()));
		} else {
			Status status = new Status(false, rb.getString("NO_RECORD_FOUND"),
					StatusCodes.NO_RECORD_FOUND.code);
			response.setStatus(status);
		}
		return response;
	}

	@POST
	@Path("healthconditions/{email}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response processPayment(@PathParam("email") String email,
			@RequestBody String healthConditionIds) throws DataAccessException,
			ParseException, Exception {
		Response response = new Response();
		List<User> userDetails = userDao.getUserByEmail(email);
		if (userDetails != null && userDetails.size() > 0) {
			// Delete all the existing user health conditions
			userDao.deleteUserHealthConditions(userDetails.get(0).getId());
			// Add the new user health conditions
			// If the healthConditionIds is empty it means the user has no
			// health condition. So just add the default value
			String[] hIds = null;
			if (healthConditionIds == null
					|| healthConditionIds.trim().equals("")) {
				hIds = new String[1];
				hIds[0] = Integer.toString(userDao
						.getDefaultHealthConditionId());
			} else {
				hIds = healthConditionIds.split(",");
			}
			for (String id : hIds) {
				userDao.addUserHealthConditions(userDetails.get(0).getId(),
						Integer.parseInt(id.trim()));
			}
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
		} else {
			Status status = new Status(false, rb.getString("NO_RECORD_FOUND"),
					StatusCodes.NO_RECORD_FOUND.code);
			response.setStatus(status);
		}
		return response;
	}

	@POST
	@Path("sendmail")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response processPayment(@RequestBody Email emailInfo) {
		Response response = new Response();
		Status status = null;
		List<User> userDetails = userDao.getUserByEmail(emailInfo
				.getUserEmail());
		if (userDetails != null && userDetails.size() > 0) {
			new Thread(new SMTP(getEmailIds(emailInfo.getEmailType()),
					emailInfo.getSubject(), emailInfo.getBody())).start();
			this.userDao.addEmailArchive(userDetails.get(0).getId(),
					getEmailIds(emailInfo.getEmailType()),
					emailInfo.getSubject(), emailInfo.getBody(),
					emailInfo.getEmailType());
			status = new Status(true, StatusCodes.SUCCESS.code);
			response.setStatus(status);
		} else {
			status = new Status(false, rb.getString("NO_RECORD_FOUND"),
					StatusCodes.NO_RECORD_FOUND.code);
			response.setStatus(status);
		}
		return response;
	}

	private String getEmailIds(EmailTypeEnums emailType) {
		String emailIds = "sivakumarcs@yahoo.com,101years1@gmail.com";
		switch (emailType) {
		case GENERAL:
			emailIds = "sivakumarcs@yahoo.com,101years1@gmail.com";
			break;
		case PURCHASE:
			emailIds = "sivakumarcs@yahoo.com,101years1@gmail.com";
			break;
		case FEEDBACK:
			emailIds = "sivakumarcs@yahoo.com,101years1@gmail.com";
			break;
		}
		return emailIds;
	}

	public static int randInt(int min, int max) {
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	/**
	 * Fetching content feed data by category type and order by category order
	 * id and favorite based on email id
	 */
	@GET
	@Path("getContentFeedByCategory/{email}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getContentFeedByCategory(@PathParam("email") String email) {
		log.info("In get content feed ");
		Response response = new Response();

		if (email != null) {

			List<User> userList = userDao.getUserByEmail(email);
			if (userList == null || userList.isEmpty()) {
				Status status = new Status(false, "User Not found", StatusCodes.NO_RECORD_FOUND.code);
				response.setStatus(status);
				return response;
			}

			List<ContentFeedANDFavourrite> resultlist = userDao.getContentFeedByCategoryDAO(email);
			List<ContentFeedANDFavourriteVO> contentFeedList = new ArrayList<ContentFeedANDFavourriteVO>();
			ContentFeedANDFavourriteMapper contentFeedMapper = new ContentFeedANDFavourriteMapper();
			List<ContentFeedANDFavourriteMapper> contentFeedMapperList = new ArrayList<ContentFeedANDFavourriteMapper>();

			try {
				if (resultlist != null && resultlist.size() > 0) {
//					String catname = "";
//					Integer categoryOrderId = null;
//					int sizeComp = 0;

					for (ContentFeedANDFavourrite contentFeed : resultlist) {
						ContentFeedANDFavourriteVO contentFeedVO = new ContentFeedANDFavourriteVO();
						BeanUtils.convertBeanToBeanWithDeepCopy(contentFeed, contentFeedVO, "com.hc", true);


						contentFeedMapper.setCategory(contentFeed.getCategory());
						contentFeedMapper.setCategoryOrderId(contentFeed.getCategoryOrderId());
						contentFeedList.add(contentFeedVO);
						contentFeedMapper.setContentFeedList(contentFeedList);
						contentFeedMapperList.add(contentFeedMapper);

						contentFeedMapper = new ContentFeedANDFavourriteMapper();
						contentFeedList = new ArrayList<ContentFeedANDFavourriteVO>();

//						if (contentFeed.getCategory() != null && !catname.equalsIgnoreCase(contentFeed.getCategory())) {
//							String oldCatName = catname;
//							Integer categoryOrderIdNew = categoryOrderId;
//							catname = contentFeed.getCategory();
//
//							if (contentFeedList.size() > 0) {
//								contentFeedMapper.setCategory(oldCatName);
//								contentFeedMapper.setCategoryOrderId(categoryOrderIdNew);
//								contentFeedMapper.setContentFeedList(contentFeedList);
//								contentFeedMapperList.add(contentFeedMapper);
//
//								contentFeedMapper = new ContentFeedANDFavourriteMapper();
//								contentFeedList = new ArrayList<ContentFeedANDFavourriteVO>();
//							}
//							contentFeedMapper.setCategory(contentFeed.getCategory());
//						}
//						catname = contentFeed.getCategory();
//						categoryOrderId = contentFeed.getCategoryOrderId();
//						contentFeedList.add(contentFeedVO);
//						if (sizeNew == sizeComp) {
//							contentFeedMapper.setCategory(catname);
//							contentFeedMapper.setContentFeedList(contentFeedList);
//							contentFeedMapperList.add(contentFeedMapper);
//						}
					}

//					/**
//					 * Favorite Category
//					 **/
//					List<ContentFeedANDFavourrite> contentFeedListFavorite = userDao.getContentFeedByFavoriteDAO(email);
//					if (contentFeedListFavorite != null
//							&& contentFeedListFavorite.size() > 0) {
//						ContentFeedANDFavourriteMapper contentFeedMapperFavorite = new ContentFeedANDFavourriteMapper();
//						List<ContentFeedANDFavourriteVO> contentFeedListFavoriteVO = new ArrayList<ContentFeedANDFavourriteVO>();
//						for (ContentFeedANDFavourrite contentFeedANDFavourrite : contentFeedListFavorite) {
//							ContentFeedANDFavourriteVO contentFeedVO = new ContentFeedANDFavourriteVO();
//							BeanUtils.convertBeanToBeanWithDeepCopy(
//									contentFeedANDFavourrite, contentFeedVO,
//									"com.hc", true);
//							contentFeedListFavoriteVO.add(contentFeedVO);
//						}
//						contentFeedMapperFavorite.setCategory("FAVORITE");
//						contentFeedMapperFavorite.setCategoryOrderId(100);
//						contentFeedMapperFavorite
//								.setContentFeedList(contentFeedListFavoriteVO);
//						contentFeedMapperList.add(contentFeedMapperFavorite);
//					}

					Status status = new Status(true, StatusCodes.SUCCESS.code);
					status.setSuccess(true);
					response.setStatus(status);
					response.setContentFeedANDFavourriteMappers(contentFeedMapperList);
					return response;
				} else {
					Status status = new Status(false,
							rb.getString("NO_RECORD_FOUND"),
							StatusCodes.NO_RECORD_FOUND.code);
					response.setStatus(status);
					return response;
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			}

		}

		Status status = new Status(false, rb.getString("INTERNAL_ERROR"),
				StatusCodes.INTERNAL_ERROR.code);
		response.setStatus(status);
		return response;
	}

	@GET
	@Path("saveFavorite/{email}/{contentFeedTypeId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveFavorite(@PathParam("email") String email,
			@PathParam("contentFeedTypeId") Integer contentFeedTypeId) {
		Response response = new Response();

		int result = userDao.saveFavoriteDAO(email, contentFeedTypeId);
		System.out.println("inside saveFavorite :email :" + email
				+ " :contentFeedTypeId : " + contentFeedTypeId + "  result -->"
				+ result);

		if (result >= 1) {
			Status status = new Status(true, "" + result,
					StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
			return response;
		} else if (result == 0) {
			Status status = new Status(true, rb.getString("FAVORITE_EXISTS"),
					StatusCodes.DATA_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
			return response;
		}

		Status status = new Status(false, rb.getString("INTERNAL_ERROR"),
				StatusCodes.INTERNAL_ERROR.code);
		response.setStatus(status);
		return response;
	}

	@GET
	@Path("deleteFavorite/{contentFeedFavouriteId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveFavorite(
			@PathParam("contentFeedFavouriteId") Integer contentFeedFavouriteId) {
		Response response = new Response();

		int result = userDao.deleteFavoriteDAO(contentFeedFavouriteId);
		System.out.println("inside deleteFavorite:: contentFeedFavouriteId "
				+ contentFeedFavouriteId + " : result -->" + result);

		if (result >= 1) {
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
			return response;
		}

		Status status = new Status(false, rb.getString("INTERNAL_ERROR"),
				StatusCodes.INTERNAL_ERROR.code);
		response.setStatus(status);
		return response;
	}

	@POST
	@Path("saveContentFeedComment")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveContentFeedComment(
			@RequestBody ContentFeedComment contentFeedComment) {
		log.info("In insertCourseReview method ");
		Response response = new Response();
		int returnVal = 0;
		try {
			returnVal = userDao.saveContentFeddCommentDAO(contentFeedComment);
			if (returnVal == 1) {
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
			} else {
				log.debug("User not found " + contentFeedComment.getEmailId());
				Status status = new Status(false,
						rb.getString("NO_RECORD_FOUND"),
						StatusCodes.NO_RECORD_FOUND.code);
				response.setStatus(status);
			}
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		} catch (ParseException e) {
			log.error(e);
			Status status = new Status(true, StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		}
		return response;
	}

	@GET
	@Path("getContentFeedCommentID/{contentFeedCommentID}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getContentFeedCommentID(
			@PathParam("contentFeedCommentID") Integer contentFeedCommentID) {
		Response response = new Response();

		if (contentFeedCommentID != null && contentFeedCommentID > 0) {
			try {
				List<ContentFeedCommentVO> commentVOs = userDao
						.getContentFeedCommentByIdDAO(contentFeedCommentID);
				System.out
						.println("inside getContentFeedCommentID:: contentFeedCommentID "
								+ contentFeedCommentID
								+ " : result -->"
								+ commentVOs.size());

				if (commentVOs.size() > 0) {
					Status status = new Status(true, ""
							+ commentVOs.get(0).getLikes(),
							StatusCodes.SUCCESS.code);// in
														// "message"
														// param
														// will
														// get
														// the
														// likes
														// count,
														// based
														// on
														// list
														// size
														// will
														// get
														// total
														// comment
														// count
														// .
														// dislike
														// count
														// =
														// comment
														// count-likes
														// count

					status.setSuccess(true);
					response.setContentFeedCommentVOs(commentVOs);
					response.setStatus(status);
					return response;
				}
			} catch (DataAccessException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		Status status = new Status(false, rb.getString("NO_RECORD_FOUND"),
				StatusCodes.NO_RECORD_FOUND.code);
		response.setStatus(status);
		return response;
	}

	/**
	 * @since 2015-08-30 Used to load generic.properties file
	 **/
	@GET
	@Path("/loadProperties")
	public Response loadProperties() {
		log.info("UserInfoImpl: Method loadProperties called");
		Response response = new Response();
		try {
			GenericProperties genericProperties = new GenericProperties();
			if (genericProperties.loadPropWS()) {
				// return createSuccessResponse("Success");
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
				return response;
			}
		} catch (Exception e) {
			log.error("Exception: Error while loading the properties : ", e);
		}

		Status status = new Status(false, rb.getString("NO_RECORD_FOUND"),
				StatusCodes.NO_RECORD_FOUND.code);
		response.setStatus(status);

		return response;
	}

	/**
	 * Used to save users energy, every time when user complete the video or
	 * some other(for now we are concentrating on video)
	 ***/
	@POST
	@Path("saveContentFeedUserLog")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveContentFeedUserLog(
			@RequestBody ContentFeedUserLog contentFeedUserLog) {
		System.out.println("In saveContentFeedUserLog method :email id: "
				+ contentFeedUserLog.getUserEmail());
		Response response = new Response();
		int returnVal = 0;
		try {
			if (contentFeedUserLog != null
					&& contentFeedUserLog.getUserEmail() != null) {
				returnVal = userDao
						.saveContentFeedUserLogDAO(contentFeedUserLog);
				if (returnVal == 1) {
					Status status = new Status(true, StatusCodes.SUCCESS.code);
					status.setSuccess(true);
					response.setStatus(status);
					/**
					 * Need to send latest energy score i think --to do
					 */
					return response;
				}
			}

			System.out.println("User not found "
					+ contentFeedUserLog.getUserEmail());
			Status status = new Status(false, rb.getString("NO_RECORD_FOUND"),
					StatusCodes.NO_RECORD_FOUND.code);
			response.setStatus(status);

		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		} catch (ParseException e) {
			log.error(e);
			Status status = new Status(true, StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		}
		return response;
	}

	/**
	 * Used to get uses energy score in %
	 */
	@GET
	@Path("getContentFeedUserScore/{userEmail}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getContentFeedUserScore(
			@PathParam("userEmail") String userEmail) {
		Response response = new Response();

		System.out.println("inside getContentFeedUserScore:: userEmail "
				+ userEmail);
		if (userEmail != null && userEmail.length() > 2) {
			try {

				String maxDaysEnergyCountString = GenericProperties
						.getProperty("MAX_DAYS_LOOK_BACK_FOR_ENERGY");
				String maxScoreForEnergyString = GenericProperties
						.getProperty("MAX_SCORE_FOR_ENERGY");

				String maxDaysRelaxCountString = GenericProperties
						.getProperty("MAX_DAYS_LOOK_BACK_FOR_RELAX");
				String maxScoreForRelaxString = GenericProperties
						.getProperty("MAX_SCORE_FOR_RELAX");

				System.out.println("maxScoreForRelaxString-->"
						+ maxScoreForRelaxString + ":maxDaysRelaxCountString:"
						+ maxDaysRelaxCountString);

				Double finalEnergyScorePercentage = getScoreAlgo(
						maxDaysEnergyCountString, maxScoreForEnergyString,
						userEmail, "energy");
				Double finalRelaxScorePercentage = getScoreAlgo(
						maxDaysRelaxCountString, maxScoreForRelaxString,
						userEmail, "relax");

				System.out.println(finalEnergyScorePercentage
						+ "<-Energy-<--Scores-->-Relax-->"
						+ finalRelaxScorePercentage);
				// Double finalScorePercentage =
				// getScoreAlgo(maxDaysEnergyCountString,
				// maxDaysRelaxCountString, maxScoreForEnergyString,
				// maxScoreForRelaxString, ,toDay, contentFeedUserLogs,
				// dateFormat, maxScoreForEnergy);

				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);

				response.setEnergyScore(finalEnergyScorePercentage);
				response.setRelaxScore(finalRelaxScorePercentage);

				response.setStatus(status);
				return response;

			} catch (DataAccessException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		Status status = new Status(false, rb.getString("NO_RECORD_FOUND"),
				StatusCodes.NO_RECORD_FOUND.code);
		response.setStatus(status);
		return response;
	}

	private Double getScoreAlgo(String maxDaysEnergyCountString,
			String maxScoreForEnergyString, String userEmail, String flag)
			throws ParseException {

		Integer maxDaysCount = maxDaysEnergyCountString != null ? Integer
				.parseInt(maxDaysEnergyCountString) : 0;
		Double maxScoreForEnergy = maxScoreForEnergyString != null ? Double
				.parseDouble(maxScoreForEnergyString) : 0;

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Calendar cal = Calendar.getInstance();
		String toDay = dateFormat.format(cal.getTime());
		cal.add(Calendar.DATE, -maxDaysCount);
		System.out.println(flag + "-<flag--<" + toDay
				+ "<--Current Date Time : " + dateFormat.format(cal.getTime()));

		List<ContentFeedUserLog> contentFeedUserLogs = userDao
				.getContentFeedUserScoreDAO(userEmail,
						dateFormat.format(cal.getTime()));
		System.out.println(flag
				+ "<--flag--<--inside getScoreAlgo:: contentFeedUserLogs "
				+ userEmail + " : result -->" + contentFeedUserLogs.size());

		if (contentFeedUserLogs.size() > 0) {

			Double totalRawScore = 0.0;
			Double totalNormalizedScore = 0.0;

			Double oneDayScore = 0.0;

			/**************/
			Calendar calTemp = Calendar.getInstance();
			calTemp.add(Calendar.DATE, -1000);
			toDay = dateFormat.format(calTemp.getTime());

			int countRows = 0;

			for (ContentFeedUserLog contentFeedUserLog : contentFeedUserLogs) {

				if (toDay.compareTo(dateFormat.format(contentFeedUserLog
						.getCreatedDttm())) != 0) {

					/**
					 * Need to write for different days condition
					 */
					if (countRows > 0) {
						String dayEnergyWeightString = getDayEnergyWeight(toDay);
						// GenericProperties.getProperty(maxDaysCount+"_DAY_ENERGY_WEIGHT");
						Double dayEnergyWeight = dayEnergyWeightString != null ? Double
								.parseDouble(dayEnergyWeightString) : 10.0;
						totalRawScore += dayEnergyWeight * oneDayScore / 100;
						oneDayScore = 0.0;
					}
					toDay = dateFormat.format(contentFeedUserLog
							.getCreatedDttm());
				}

				oneDayScore += flag.equalsIgnoreCase("energy") ? contentFeedUserLog
						.getEnergyScore().doubleValue() : contentFeedUserLog
						.getRelaxScore().doubleValue();
				countRows++;

				if (toDay.compareTo(dateFormat.format(contentFeedUserLog
						.getCreatedDttm())) == 0
						&& contentFeedUserLogs.size() == countRows) { // starting(if
																		// having
																		// only
																		// one
																		// record)
																		// or
																		// final
																		// it
																		// will
																		// come
																		// here..

					String dayEnergyWeightString = getDayEnergyWeight(toDay);
					Double dayEnergyWeight = dayEnergyWeightString != null ? Double
							.parseDouble(dayEnergyWeightString) : 10.0;
					totalRawScore += dayEnergyWeight * oneDayScore / 100;
				}
			}

			totalNormalizedScore = (totalRawScore >= maxScoreForEnergy) ? maxScoreForEnergy
					: totalRawScore;
			Double finalScorePercentage = totalNormalizedScore * 100
					/ maxScoreForEnergy;

			System.out.println(flag + "-<flag--<totalRawScore-->"
					+ totalRawScore + "<---totalNormalizedScore-->"
					+ totalNormalizedScore + " :: finalScorePercentage:: "
					+ finalScorePercentage);

			return finalScorePercentage;
		}
		return 0.0;
	}

	private String getDayEnergyWeight(String toDay) throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Date passwdDate = dateFormat.parse(toDay);
		Date currentDate = new Date();
		long dayCount = (dateFormat.parse(dateFormat.format(currentDate))
				.getTime() - passwdDate.getTime()) / (24 * 60 * 60 * 1000);
		String dayCountString = GenericProperties.getProperty(dayCount
				+ "_DAY_ENERGY_WEIGHT");
		System.out.println("dayCount-->" + dayCount + "--dayCountString>"
				+ dayCountString);

		return dayCountString;
	}

	/**
	 * Used to get uses energy score in %
	 */
	@GET
	@Path("getUserJourneyForDashboard/{userEmail}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserJourneyForDashboard(
			@PathParam("userEmail") String userEmail) {
		Response response = new Response();

		System.out.println("inside getContentFeedUserScore:: userEmail "
				+ userEmail);
		if (userEmail != null && userEmail.length() > 2) {
			try {
				Map<String, Integer> cycles = userDao
						.getUserJourneyForDashboardDAO(userEmail);

				if (cycles != null) {

					Status status = new Status(true, StatusCodes.SUCCESS.code);
					status.setSuccess(true);

					response.setJourneyStart(cycles.get("startCycle") != null ? cycles
							.get("startCycle") : 0);
					response.setJourneyCurrent(cycles.get("currentCycle") != null ? cycles
							.get("currentCycle") : 0);
					response.setJourneyFinal(cycles.get("finalCycle") != null ? cycles
							.get("finalCycle") : 0);

					response.setStatus(status);
					return response;
				}

			} catch (DataAccessException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Status status = new Status(false, rb.getString("NO_RECORD_FOUND"),
				StatusCodes.NO_RECORD_FOUND.code);
		response.setStatus(status);
		return response;
	}

	/**
	 * 
	 * 1 . Check user email is availble in our db or not 2 . if available just
	 * send response same as login api reposnse 3 . if not available create the
	 * user with email and fname, lanem . (password not decide yet)
	 * 
	 * Doubts : subscription date?
	 */
	@POST
	@Path("registerUserByFB")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerUserByFB(@RequestBody User user) {
		log.info("In registerUserByFB method " + user.getEmail());

		Response response = new Response();

		if (user.getEmail() != null) {
			List<User> userDetails = userDao.getUserByEmail(user.getEmail());

			if (userDetails != null && userDetails.size() > 0) {
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);

				response.setUser(userDetails.get(0));
				return response;
			} else {

				List<User> userDetailsFB = userDao.registerFbByEmail(user);
				if (userDetailsFB != null) {
					Status status = new Status(true, StatusCodes.SUCCESS.code);
					status.setSuccess(true);
					response.setStatus(status);
					response.setUser(userDetailsFB.get(0));
					return response;
				}
			}
		}

		Status status = new Status(false, rb.getString("DATA_ERROR"),
				StatusCodes.DATA_ERROR.code);
		response.setStatus(status);

		return response;

	}

	@GET
	@Path("getAllPlans")
	@Scope("request")
	public Response getAllPlans() {
		Response response = new Response();
		try {
			List<Plan> plans = userDao.getAllPlans();
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
			response.setPlans(plans);
		} catch (DuplicateKeyException e) {
			log.error(e);
			Status status = new Status(true, rb.getString("NO_PLAN"),
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
	@Path("getAllPlanCategories/{planCatId}/{UserId}")
	@Scope("request")
	public Response getAllPlanCategories(@PathParam("planCatId") int planCatId,@PathParam("UserId") int UserId) {
		Response response = new Response();
		try {
			List<Category> plans = new  ArrayList<Category>();
			if(planCatId!=15){
			plans = userDao.getAllPlanCategories(planCatId);
			}else{
				
				List<Category> plans1 = userDao.getAllPlanCategories(planCatId);
				for (Category category : plans1) {
					int cat=category.getId();
					int coutcat=userDao.getcoursecountofCat(cat,UserId);
					if(coutcat>0){
						plans.add(category);
					}
					
					
				}
			}
			List<OnDemandContent> demand = userDao
					.getOnDemandContent(planCatId);
			if (demand != null && demand.size() == 1) {
				response.setScreenName(demand.get(0).getScreenName());
				response.setOnDemandtitle(demand.get(0).getTitle());
			}
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
			response.setCats(plans);
		} catch (DuplicateKeyException e) {
			log.error(e);
			Status status = new Status(true, rb.getString("NO_PLAN"),
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
	@Path("getPlanStructure/{planId}/{fintNessLev}")
	@Scope("request")
	public Response getPlanStructure(@PathParam("planId") int planId,
			@PathParam("fintNessLev") int fintNessLev) {
		Response response = new Response();
		try {
			List<PlanStructure> planStruct = userDao.getPlanStructure(planId,
					fintNessLev);
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
			response.setPlanStruct(planStruct);
		} catch (DuplicateKeyException e) {
			log.error(e);
			Status status = new Status(true, rb.getString("NO_PLAN"),
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

	@POST
	@Path("ondemandMindfulldata")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response onDemand(@RequestBody VideoReqObj request) {
		Response response = new Response();
		log.info("In Start work out method ");
		try {
			List<VideoResObj> videos = new ArrayList<VideoResObj>();
			List<VideoResObj> videoList = new ArrayList<VideoResObj>();
			// 1. Get videos by above categories and number of videos.
			videos = userDao.getVideosListOnDemans(request,
					Integer.parseInt(request.getFitnessLevel()),
					Integer.parseInt(request.getFlexiblityType()));
			videoList.addAll(videos);
			// videos = userDao.getVideosListByCriteria(request,
			// Integer.parseInt(request.getStrengthnings()));
			// videoList.addAll(videos);
			if (videoList.size() != 0) {
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
				response.setSetVideoResList(videoList);
			} else {
				Status status = new Status(true,
						StatusCodes.NO_RECORD_FOUND.code);
				status.setSuccess(true);
				response.setStatus(status);
			}
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
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@POST
	@Path("startWorkOut")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response startWorkOut(@RequestBody VideoReqObj request) {
		Response response = new Response();
		log.info("In Start work out method ");
		try {

			int weekNo = 0;
			List<MaxVideoWeekNo> maxVideo = userDao.getMaxVideoAndWeekNo(Integer.parseInt(request.getUserId()));
			List<PlanStructure> planStructs = userDao.getPlanStructure(Integer.parseInt(request.getPlanId()), Integer.parseInt(request.getFitnessLevel()));
			Map<Integer, Integer> catMap = new HashMap<Integer, Integer>();
			List<PlanDetails> catList = new ArrayList<PlanDetails>();
			for (PlanStructure p : planStructs) {
				if (p.getFirstCatId() != 0) {

					if (catMap.get(p.getFirstCatId()) != null)
						catMap.put(p.getFirstCatId(), catMap.get(p.getFirstCatId()) + p.getFirstCatCount());
					else
						catMap.put(p.getFirstCatId(), p.getFirstCatCount());

					for (int i = 0; i < p.getFirstCatCount(); i++) {
						PlanDetails pd = new PlanDetails();
						pd.setDayId(p.getDay());
						pd.setCatId(p.getFirstCatId());
						catList.add(pd);
					}
				}
				if (p.getSecondCatId() != 0) {
					if (catMap.get(p.getSecondCatId()) != null)
						catMap.put(p.getSecondCatId(), catMap.get(p.getSecondCatId()) + p.getSecondCatCount());
					else
						catMap.put(p.getSecondCatId(), p.getSecondCatCount());
					for (int i = 0; i < p.getSecondCatCount(); i++) {
						PlanDetails pd = new PlanDetails();
						pd.setDayId(p.getDay());
						pd.setCatId(p.getSecondCatId());
						catList.add(pd);
					}
				}
				if (p.getThirdCatId() != 0) {
					if (catMap.get(p.getThirdCatId()) != null)
						catMap.put(p.getThirdCatId(), catMap.get(p.getThirdCatId()) + p.getThirdCatCount());
					else
						catMap.put(p.getThirdCatId(), p.getThirdCatCount());
					for (int i = 0; i < p.getThirdCatCount(); i++) {
						PlanDetails pd = new PlanDetails();
						pd.setDayId(p.getDay());
						pd.setCatId(p.getThirdCatId());
						catList.add(pd);
					}
				}
			}
			// convert catList to map to set to video attributes.
			Map<Integer, List<Integer>> catMap1 = new HashMap<Integer, List<Integer>>();
			for (PlanDetails pd : catList) {
				List<Integer> dayList = catMap1.get(pd.getCatId());
				if (dayList == null) {
					dayList = new ArrayList<Integer>();
				}
				dayList.add(pd.getDayId());
				catMap1.put(pd.getCatId(), dayList);
			}

			List<VideoResObj> videoList = new ArrayList<VideoResObj>();
			List<VideoResObj> videos = new ArrayList<VideoResObj>();
			// List previous week max video Number and catId
			Map<Integer, Integer> videoByCatMap = new HashMap<Integer, Integer>();
			if (maxVideo != null && maxVideo.size() > 0) {
				for (MaxVideoWeekNo videoByCat : maxVideo) {
					videoByCatMap.put(videoByCat.getCatId(), videoByCat.getMaxVideoNo());
				}
				weekNo = maxVideo.get(0).getWeekNo();
			}

			// 2. Get videos by above categories and number of videos.
			for (Integer cat : catMap.keySet()) {
				// if(cat!=105)
				// {
				int maxVideoNumber = 0;
				if (weekNo != 0 && maxVideo != null && maxVideo.size() > 0) {
					if (videoByCatMap.containsKey(cat)) {
						maxVideoNumber = videoByCatMap.get(cat);
					}
				}
				videos = userDao.getVideosList(request, cat, catMap.get(cat), maxVideoNumber);

				if (weekNo != 0 && videos.size() == 0) {
					videos = userDao.getVideosList(request, cat, catMap.get(cat), 0);
				} else if (weekNo != 0 && videos.size() < catMap.get(cat) && maxVideoNumber != 0) {
					videoList.addAll(videos);
					videos = userDao.getVideosList(request, cat, catMap.get(cat) - videos.size(), 0);
				}
				videoList.addAll(videos);
				// }
			}

			// Update the previous work out done.
			if (videoList.size() > 0) {
				userDao.setDoneToCurrentWorkOut(Integer.parseInt(request.getUserId()), weekNo);
			}
			// 3. Insert video details into
			for (VideoResObj video : videoList) {

				video.setPlanId(request.getPlanId());
				List<Integer> dayList = catMap1.get(Integer.parseInt(video.getCatId()));
				video.setDay("" + dayList.get(0));
				dayList.remove(dayList.get(0));
				catMap1.put(Integer.parseInt(video.getCatId()), dayList);

				int insertRows = userDao.insertWorkOutVideo(video, weekNo + 1, Integer.parseInt(request.getUserId()), request);
				video.setWorkOutId("" + insertRows);
				System.out.println("Inserted:" + insertRows + " Video ID" + video.getVideoId());

			}
			Collections.sort(videoList, new SortVideos());
			FilterByDay dayVideos = new FilterByDay();
			FilterByCat catVideos = new FilterByCat();
			List<VideoResObj> dayWiseVideos;
			List<VideoResObj> allVideos = new ArrayList<VideoResObj>();
			List<InsufficentCount> icList = new ArrayList<InsufficentCount>();
			for (PlanStructure p : planStructs) {
				InsufficentCount ic = new InsufficentCount();
				ic.setDayId(p.getDay());
				dayWiseVideos = dayVideos.meetCriteria(videoList, p.getDay());
				List<VideoResObj> firstCatVideos = catVideos.meetCriteria(
						dayWiseVideos, p.getFirstCatId());
				allVideos.addAll(firstCatVideos);
				if (p.getFirstCatCount() != firstCatVideos.size())
					ic.setFirstCountDiff(-1);
				List<VideoResObj> secondCatVideos = catVideos.meetCriteria(
						dayWiseVideos, p.getSecondCatId());
				allVideos.addAll(secondCatVideos);
				if (p.getSecondCatCount() != secondCatVideos.size())
					ic.setSecondCountDiff(-1);
				List<VideoResObj> thirdCatVideos = catVideos.meetCriteria(
						dayWiseVideos, p.getThirdCatId());
				allVideos.addAll(thirdCatVideos);
				if (p.getThirdCatCount() != thirdCatVideos.size())
					ic.setThirdCountDiff(-1);

				icList.add(ic);
			}
			response.setIcList(icList);
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
			response.setSetVideoResList(allVideos);
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
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@GET
	@Path("getCurrentWorkOut/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getCurrentWorkOut(@PathParam("userId") Integer userId) {
		log.info("Get Current work out method ");
		Response response = new Response();
		log.info("Get Current work out method ");
		try {
			List<WeeklyWorkOut> videoList = new ArrayList<WeeklyWorkOut>();
			videoList = userDao.getCurrentWorkOut(userId);
			if (videoList != null && videoList.size() > 0) {
				int currentDay = 1;
				String lastUpdate = videoList.get(0).getLastUpdated();
				String created = videoList.get(0).getCreated();
				if (created.equals(lastUpdate)) {
					currentDay = 1;
				} else {
					currentDay = videoList.get(0).getDayId();
				}
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date startDate = null;
				startDate = df.parse(lastUpdate);
				Calendar c1 = Calendar.getInstance();
				Date d1 = c1.getTime();
				Date d2 = startDate;
				int wholeDays = (int) diffDays(d2, d1);

				if (wholeDays >= 2) {
					Status status = new Status(true,
							StatusCodes.RESET_WORKOUT.code);
					// Update the previous work out done.
					userDao.setDoneToCurrentWorkOut(userId, videoList.get(0)
							.getWeekNumber());
					// userDao.resetCurrentWorkOut(userId,videoList.get(0).getWeekNumber());
					status.setSuccess(true);
					response.setStatus(status);
				} else {
					if (wholeDays != 0) {
						if (currentDay == 2)
							currentDay += 2;
						else
							currentDay += 1;
					}
					Collections.sort(videoList, new SortVideos1());
					FilterByDay dayVideos = new FilterByDay();
					FilterByCat catVideos = new FilterByCat();
					List<WeeklyWorkOut> dayWiseVideos;
					List<WeeklyWorkOut> allVideos = new ArrayList<WeeklyWorkOut>();
					List<Criteria> criteriaList = new ArrayList<Criteria>();
					criteriaList = userDao.getCurrentWorkOutCriteria(userId);
					List<PlanStructure> planStruct = userDao.getPlanStructure(
							criteriaList.get(0).getPlanId(), criteriaList
									.get(0).getFitnessLevel());
					List<InsufficentCount> icList = new ArrayList<InsufficentCount>();
					for (PlanStructure p : planStruct) {

						InsufficentCount ic = new InsufficentCount();
						ic.setDayId(p.getDay());
						dayWiseVideos = dayVideos.meetCriteria1(videoList, p.getDay());
						List<WeeklyWorkOut> firstCatVideos = catVideos.meetCriteria1(dayWiseVideos, p.getFirstCatId());
						allVideos.addAll(firstCatVideos);
						if (p.getFirstCatCount() != firstCatVideos.size())
							ic.setFirstCountDiff(-1);
						List<WeeklyWorkOut> secondCatVideos = catVideos
								.meetCriteria1(dayWiseVideos,
										p.getSecondCatId());
						allVideos.addAll(secondCatVideos);
						if (p.getSecondCatCount() != secondCatVideos.size())
							ic.setSecondCountDiff(-1);
						List<WeeklyWorkOut> thirdCatVideos = catVideos
								.meetCriteria1(dayWiseVideos, p.getThirdCatId());
						allVideos.addAll(thirdCatVideos);
						if (p.getThirdCatCount() != thirdCatVideos.size())
							ic.setThirdCountDiff(-1);

						icList.add(ic);
					}
					response.setWeeklyWorkOut(allVideos);
					response.setIcList(icList);
					response.setCurrentDay(currentDay);
					Status status = new Status(true, StatusCodes.SUCCESS.code);
					status.setSuccess(true);
					response.setStatus(status);
				}
			} else {
				Status status = new Status(true,
						StatusCodes.NO_CURRENT_WORKOUT.code);
				status.setSuccess(true);
				response.setStatus(status);
			}
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
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;

	}

	@GET
	@Path("getCurrentWorkOutCriteria/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getCurrentWorkOutCriteria(
			@PathParam("userId") Integer userId) {
		log.info("Get Current work criteria method ");
		Response response = new Response();
		log.info("Get Current work criteria method ");
		try {
			List<Criteria> criteriaList = new ArrayList<Criteria>();
			criteriaList = userDao.getCurrentWorkOutCriteria(userId);
			response.setCriteria(criteriaList);
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);

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
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;

	}

	@POST
	@Path("updateVideoDuration")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateVideoDuration(@RequestBody UpdateVideoDurInfo request) {
		Response response = new Response();
		log.info("Update Video Duration ");
		try {

			for (WeeklyWorkOut video : request.getVideoList()) {
				userDao.updateVideoDurationMinutes(request.getUserId(),
						video.getDuration_time(), video.getWorkOutId());
			}
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
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
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	private static final double DAY_MILLIS = 1000.0 * 24.0 * 60.0 * 60.0;

	public static final double diffDays(Date from, Date to) {
		return (to.getTime() - from.getTime()) / DAY_MILLIS;
	}

	@GET
	@Path("getWeekGoalAndWatchTime/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getWeekGoalAndWatchTime(@PathParam("userId") Integer userId) {

		log.info("Get Current work out method ");

		// SELECT datediff(lastUpdated,now()) FROM ebdb.weekly_work_out w join
		// content_feed c on w.videoId=c.content_feed_id and w.userId=1 and
		// w.weekNumber in (SELECT MAX(weekNumber) from weekly_work_out) and
		// watchedTime is null
		Response response = new Response();
		log.info("Get Current work out method ");
		try {
			List<WeekDetails> weekList = new ArrayList<WeekDetails>();
			weekList = userDao.getWeekGoalAndWatchTime(userId);
			response.setWeekList(weekList);
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
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
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@GET
	@Path("getWeekWatchedMinutesDetails/{userId}/{weekNumber}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getWeekWatchedMinutesDetails(
			@PathParam("userId") Integer userId,
			@PathParam("weekNumber") Integer weekNumber) {
		log.info("Get Current work out method ");
		// SELECT datediff(lastUpdated,now()) FROM ebdb.weekly_work_out w join
		// content_feed c on w.videoId=c.content_feed_id and w.userId=1 and
		// w.weekNumber in (SELECT MAX(weekNumber) from weekly_work_out) and
		// watchedTime is null
		Response response = new Response();
		log.info("Get Current work out method ");
		try {
			List<WeekDetails2> weekList = new ArrayList<WeekDetails2>();
			weekList = userDao.getWeekWatchedMinutesDetails(userId, weekNumber);
			response.setWeekList2(weekList);
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);

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
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return response;
	}

	@POST
	@Path("getVideosByCriteria")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getVideosByCriteria(@RequestBody VideoReqObj request) {
		Response response = new Response();
		log.info("In getVideosByCriteria method ");
		try {
			List<VideoResObj> videos = new ArrayList<VideoResObj>();
			List<VideoResObj> videoList = new ArrayList<VideoResObj>();
			// 1. Get videos by above categories and number of videos.
			videos = userDao.getVideosListByCriteria(request,
					Integer.parseInt(request.getFlexiblityType()));
			videoList.addAll(videos);
			// videos = userDao.getVideosListByCriteria(request,
			// Integer.parseInt(request.getStrengthnings()));
			// videoList.addAll(videos);
			if (videoList.size() != 0) {
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
				response.setSetVideoResList(videoList);
			} else {
				Status status = new Status(true,
						StatusCodes.NO_RECORD_FOUND.code);
				status.setSuccess(true);
				response.setStatus(status);
			}
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, e.getLocalizedMessage(),
					StatusCodes.DATA_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@POST
	@Path("user/userInfoByEmail")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserInfoData(@RequestBody User user) {
		log.info("In updateUserMetrics method ");
		Response response = new Response();
		int returnVal = 3;
		try {
			// TODO 03/16/2014 Cycle & Ratio hardcoded as on now
			/*
			 * Removed default value on 02172015 user.setCycle("20");
			 * user.setRatio("2:2");
			 */
			List<User> userList = userDao.getUserByEmail(user.getEmail());
			User userData = userList.get(0);
			Gson gson = new Gson();

			List<Metrics> metricsInfo = (List<Metrics>) gson.fromJson(
					userData.getMetrics(), new TypeToken<List<Metrics>>() {
					}.getType());

			int totalInhale = 0, totalExhale = 0;
			if (metricsInfo != null) {
				for (Metrics metrics : metricsInfo) {
					if (metrics.getInHaleTime() != null
							&& !metrics.getInHaleTime().equals("")) {
						totalInhale += Integer
								.parseInt(metrics.getInHaleTime());
					}
					if (metrics.getExHaleTime() != null
							&& !metrics.getExHaleTime().equals("")) {
						totalExhale += Integer
								.parseInt(metrics.getExHaleTime());
					}
				}
			}

			user = userData;
			String zoneName = "";
			int defaultCycle = Integer.parseInt(user.getCycle());
			if (defaultCycle <= 28 && defaultCycle >= 16) {
				zoneName = "Transition Zone";
			} else if (defaultCycle == 14) {
				zoneName = "Positive Energy Zone";
			} else if (defaultCycle == 12) {
				zoneName = "Improved Cognition Zone";
			} else if (defaultCycle == 10) {
				zoneName = "Enhanced Mood and Wellbeing Zone";
			} else if (defaultCycle == 8) {
				zoneName = "Better Stress Adaptation Zone";
			} else if (defaultCycle == 6) {
				zoneName = "The Zen Zone";
			}
			user.setZoneName(zoneName);
			if (returnVal >= 1) {
				Status status = new Status(true, StatusCodes.SUCCESS.code);
				status.setSuccess(true);
				response.setStatus(status);
				response.setUser(user);
			} else {
				log.debug("User not found " + user.getEmail());
				Status status = new Status(false,
						rb.getString("NO_RECORD_FOUND"),
						StatusCodes.NO_RECORD_FOUND.code);
				response.setStatus(status);
			}
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, StatusCodes.INTERNAL_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		}
		return response;
	}
	
	@GET
	@Path("getDashBoardData/chart/{userId}/{selectType}")
	//'2017-03-23 19:43:04 - 2017-03-29 19:43:04'
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getDashBoardDataInChart(@PathParam("userId") Integer userId,@PathParam("selectType") String selectType) {

		Response response = new Response();
		log.info("Get DashBoard data in Chart ");
		try {
			DashBoardData dbd=new DashBoardData();
			dbd.setDataType(selectType);
			dbd.setItem(userDao.getDashBoardDataInChart(userId,selectType));
			response.setDashBoardData(dbd);
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
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
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	@GET
	@Path("getQuarterDataByYear/{userId}/{yearNo}")
	//'2017-03-23 19:43:04 - 2017-03-29 19:43:04'
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getWeekDataByQuarter(@PathParam("userId") Integer userId,@PathParam("yearNo") String yearNo) {

		Response response = new Response();
		log.info("Get DashBoard data. ");
		try {
			DashBoardData dbd=new DashBoardData();
			DashBoardItem dbi=new DashBoardItem();
			dbi.setWorkOutdata(userDao.getDashBoardQuarterDataByYear(userId,yearNo));
			dbd.setItem(dbi);
			response.setDashBoardData(dbd);
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
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
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	
	@GET
	@Path("getWeekDataByQuarter/{userId}/{fromDate}/{toDate}")
	//'2017-03-23 19:43:04 - 2017-03-29 19:43:04'
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getWeekDataByQuarter(@PathParam("userId") Integer userId,@PathParam("fromDate") String fromDate,@PathParam("toDate") String toDate) {

		Response response = new Response();
		log.info("Get DashBoard data. ");
		try {
			DashBoardData dbd=new DashBoardData();
			DashBoardItem dbi=new DashBoardItem();
			dbi.setWorkOutdata(userDao.getDashBoardWeekWiseByQuarter(userId,fromDate,toDate));
			dbd.setItem(dbi);
			response.setDashBoardData(dbd);
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
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
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	@GET
	@Path("getDashBoardData/{userId}/{selectType}")
	//'2017-03-23 19:43:04 - 2017-03-29 19:43:04'
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getDashBoardData(@PathParam("userId") Integer userId,@PathParam("selectType") String selectType) {

		Response response = new Response();
		log.info("Get DashBoard data. ");
		try {
			DashBoardData dbd=new DashBoardData();
			dbd.setDataType(selectType);
			DashBoardItem dbi=new DashBoardItem();
			dbi.setWorkOutdata(userDao.getDashBoardData(userId,selectType));
			dbd.setItem(dbi);
			response.setDashBoardData(dbd);
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
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
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@GET
	@Path("getDashBoardDataRangeData/{userId}/{fromDate}/{endDate}")
	//'2017-03-23 19:43:04 - 2017-03-29 19:43:04'
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getDashBoardDataWeekWise(@PathParam("userId") Integer userId,@PathParam("fromDate") String fromDate,@PathParam("endDate") String endDate) {

		Response response = new Response();
		log.info("Get DashBoard data. ");
		try {
			DashBoardDataWeekWise dbd=new DashBoardDataWeekWise();
			DashBoardItem dbi=new DashBoardItem();
			dbi.setWorkOutdata(userDao.getDashBoardRangeData(userId,fromDate,endDate));
			dbd.setItem(dbi);
			response.setDashBoardDataWeekWise(dbd);
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
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
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@GET
	@Path("getSearchData")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getSearchData(@QueryParam("searchText") String searchText){
		Response response = new Response();
		log.info("Get DashBoard data. ");
		try {
			List<SearchData> result = userDao.getSearchData(searchText);
			response.setSearchDatas(result);
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, e.getLocalizedMessage(),
					StatusCodes.DATA_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;

	}

	@GET
	@Path("getFavourites")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getFavourites(@QueryParam("email") String email){
		Response response = new Response();
		log.info("Get DashBoard data. ");
		try {
			List<FavouritesData> result = userDao.getFavourites(email);
			response.setFavouritesData(result);
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
		} catch (DataAccessException e) {
			log.error(e);
			Status status = new Status(true, e.getLocalizedMessage(),
					StatusCodes.DATA_ERROR.code);
			status.setSuccess(false);
			response.setStatus(status);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;

	}

	@POST
	@Path("addFavourites")
	public Response addVideoFavourites(@QueryParam("email") String email,@QueryParam("id") Integer id,@QueryParam("favourId") Integer favourId) {
		Response response = new Response();
		log.info("Add to favourities");
		try {
			userDao.addToFavourities(email,id,favourId);
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
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
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

		
	
	@POST
	@Path("updateOnDemandVideoDuration")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateOnDemandVideoDuration(@RequestBody UpdateVideoDurInfo1 request) {
		Response response = new Response();
		log.info("Update Video Duration For ONDEMAND WORKOUT!!");
		try {

			for (OnDemandWorkOut video : request.getVideoList()) {
				userDao.updateOndemandVideoDurationMinutes(request.getUserId(),
						video);
			}
			Status status = new Status(true, StatusCodes.SUCCESS.code);
			status.setSuccess(true);
			response.setStatus(status);
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
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}


	public Response getRes(Integer userId){
		UserDao userDao = new UserDao();
		log.info("Get Current work out method ");
		Response response = new Response();
		log.info("Get Current work out method ");
		try {
			List<WeeklyWorkOut> videoList = new ArrayList<WeeklyWorkOut>();
			videoList = userDao.getCurrentWorkOut(userId);
			if (videoList != null && videoList.size() > 0) {
				int currentDay = 1;
				String lastUpdate = videoList.get(0).getLastUpdated();
				String created = videoList.get(0).getCreated();
				if (created.equals(lastUpdate)) {
					currentDay = 1;
				} else {
					currentDay = videoList.get(0).getDayId();
				}
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date startDate = null;
				startDate = df.parse(lastUpdate);
				Calendar c1 = Calendar.getInstance();
				Date d1 = c1.getTime();
				Date d2 = startDate;
				int wholeDays = (int) diffDays(d2, d1);

				if (wholeDays >= 2) {
					Status status = new Status(true,
							StatusCodes.RESET_WORKOUT.code);
					// Update the previous work out done.
					userDao.setDoneToCurrentWorkOut(userId, videoList.get(0)
							.getWeekNumber());
					// userDao.resetCurrentWorkOut(userId,videoList.get(0).getWeekNumber());
					status.setSuccess(true);
					response.setStatus(status);
				} else {
					if (wholeDays != 0) {
						if (currentDay == 2)
							currentDay += 2;
						else
							currentDay += 1;
					}
					Collections.sort(videoList, new SortVideos1());
					FilterByDay dayVideos = new FilterByDay();
					FilterByCat catVideos = new FilterByCat();
					List<WeeklyWorkOut> dayWiseVideos;
					List<WeeklyWorkOut> allVideos = new ArrayList<WeeklyWorkOut>();
					List<Criteria> criteriaList = new ArrayList<Criteria>();
					criteriaList = userDao.getCurrentWorkOutCriteria(userId);
					List<PlanStructure> planStruct = userDao.getPlanStructure(
							criteriaList.get(0).getPlanId(), criteriaList
									.get(0).getFitnessLevel());
					List<InsufficentCount> icList = new ArrayList<InsufficentCount>();
					for (PlanStructure p : planStruct) {

						InsufficentCount ic = new InsufficentCount();
						ic.setDayId(p.getDay());
						dayWiseVideos = dayVideos.meetCriteria1(videoList, p.getDay());
						List<WeeklyWorkOut> firstCatVideos = catVideos.meetCriteria1(dayWiseVideos, p.getFirstCatId());
						allVideos.addAll(firstCatVideos);
						if (p.getFirstCatCount() != firstCatVideos.size())
							ic.setFirstCountDiff(-1);
						List<WeeklyWorkOut> secondCatVideos = catVideos
								.meetCriteria1(dayWiseVideos,
										p.getSecondCatId());
						allVideos.addAll(secondCatVideos);
						if (p.getSecondCatCount() != secondCatVideos.size())
							ic.setSecondCountDiff(-1);
						List<WeeklyWorkOut> thirdCatVideos = catVideos
								.meetCriteria1(dayWiseVideos, p.getThirdCatId());
						allVideos.addAll(thirdCatVideos);
						if (p.getThirdCatCount() != thirdCatVideos.size())
							ic.setThirdCountDiff(-1);

						icList.add(ic);
					}
					response.setWeeklyWorkOut(allVideos);
					response.setIcList(icList);
					response.setCurrentDay(currentDay);
					Status status = new Status(true, StatusCodes.SUCCESS.code);
					status.setSuccess(true);
					response.setStatus(status);
				}
			} else {
				Status status = new Status(true,
						StatusCodes.NO_CURRENT_WORKOUT.code);
				status.setSuccess(true);
				response.setStatus(status);
			}
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
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;

	}

}