package com.hc.util;

public class Query {

	public static String UPDATE_DONE_WORKOUT = "Update weekly_work_out set done=1,lastUpdated=now() where userId=? and weekNumber=?";
	public static String UPDATE_BtStastus_WORKOUT = "Update weekly_work_out set bt_status=1,lastUpdated=now() where userId=?";

	// public static String GET_WEEK_DETAILS =
	// "SELECT u.score,TIME_FORMAT(sum(w.watchedTime), '%H:%i') AS
	// WatchedTime,w.weekNumber,p.duration as Goal,p.name as planName FROM
	// weekly_work_out w join users u on u.id=w.userid join workoutplan p on
	// w.planid=p.id where userid=? group by w.weekNumber,duration";
	public static String GET_WEEK_DETAILS = "select * from (	select 0 as completedWorkOut ,pw.workOutCount as goalWorkOut,u.score,w.weekNumber,w.fitnessLevel,p.duration as Goal,p.name as planName from weekly_work_out w "
			+ "join plan_work_out pw on  pw.planId=w.planId and pw.fitnessLevel=w.fitnessLevel  "
			+ "           join users u on u.id=w.userid join workoutplan p on w.planid=p.id and userid=? "
			+ "where weeknumber not in ( SELECT ww.weekNumber as id FROM content_feed cf join weekly_work_out ww on ww.videoId=cf.content_feed_id and ww.watchedTime=cf.duration_time "
			+ "join users u on u.id=ww.userid  and u.Id=? GROUP BY ww.weekNumber	 )  " + "group by weekNumber  "
			+ "union  " + "select t1 as completedWorkOut,pw.workOutCount as goalWorkOut,u.score,w.weekNumber, "
			+ "w.fitnessLevel,p.duration as Goal,p.name as planName FROM weekly_work_out w  "
			+ "join plan_work_out pw on  pw.planId=w.planId and pw.fitnessLevel=w.fitnessLevel "
			+ " join users u on u.id=w.userid join workoutplan p on w.planid=p.id and userid=?   "
			+ "join (SELECT ww.weekNumber as id,COALESCE(count(weekNumber), 0) AS t1  "
			+ "FROM content_feed cf join weekly_work_out ww on ww.videoId=cf.content_feed_id and ww.watchedTime=cf.duration_time "
			+ "join users u on u.id=ww.userid  and u.Id=?          GROUP BY ww.weekNumber	 ) AS b       ON b.id = w.weekNumber 	 "
			+ "group by w.weekNumber  " + ") as a order by a.weekNumber";

	// public static String GET_WEEK_DETAILS_INDEPTH =
	// "SELECT TIME_FORMAT(sum(w.watchedTime), '%H:%i') as
	// watchedTime,w.planId,w.catId,c.name,p.duration as goal,p.name as planName
	// FROM weekly_work_out w join workoutplan p on p.id=w.planId join
	// plan_cat_list c on w.catId=c.id where w.userid=? and w.weekNumber=? group
	// by w.catId";
	public static String GET_WEEK_DETAILS_INDEPTH = "select * from ( select ps.day_desc,ww.catId,ww.planId,wop.name as planName,0 as completedWorkOut,u.cycle,ps.day as dayId,ps.FirstCatCount+ps.SecondCatCount+ps.ThirdCatCount as goalWorkOut from weekly_work_out ww "
			+ "join users u on ww.userId=u.id and ww.userId=? and ww.weekNumber=?  "
			+ "join plan_structure ps on ps.plan_id=ww.planId and ps.fitnessLevel=ww.fitnessLevel "
			+ "join workoutplan wop on wop.id=ww.planId  "
			+ "where ps.day not in (SELECT ww.dayId FROM weekly_work_out ww "
			+ "join content_feed cf on ww.videoId=cf.content_feed_id  and cf.duration_time=ww.watchedTime "
			+ "join users u on u.id=ww.userid  and u.Id=? and ww.weekNumber=?  "
			+ "GROUP BY ww.dayId ) group by ps.day  " + "union  "
			+ "select ps.day_desc,ww.catId,ww.planId,wop.name as planName,b.t1 as completedWorkOut,u.cycle,ps.day as dayId,ps.FirstCatCount+ps.SecondCatCount+ps.ThirdCatCount as goalWorkOut from weekly_work_out ww "
			+ "join users u on ww.userId=u.id and ww.userId=? and ww.weekNumber=?  "
			+ "join plan_structure ps on ps.plan_id=ww.planId and ps.fitnessLevel=ww.fitnessLevel "
			+ "join workoutplan wop on wop.id=ww.planId   "
			+ "join (SELECT ww.dayId as id,COALESCE(count(*), 0) AS t1 FROM weekly_work_out ww "
			+ "join content_feed cf on ww.videoId=cf.content_feed_id  and cf.duration_time=ww.watchedTime "
			+ "join users u on u.id=ww.userid  and u.Id=? and ww.weekNumber=? "
			+ "GROUP BY ww.dayId) AS  b on b.id=ps.day   " + "group by ps.day ) as x order by x.dayId ";
	public static String UPDATE_VIDEO_DURATION = "Update weekly_work_out set watchedTime=?,lastUpdated=? where userId=? and id=?";

	// public static String UPDATE_ONDEMAND_VIDEO_DURATION="Update
	// ondemand_work_out set watchedTime=?,lastUpdated=? where userId=? and
	// id=?";

	public static String VERIFY_ONDEMAND_VIDEO_EXIST = "select count(*) from ondemand_work_out ww join content_feed cf on ww.videoId=cf.content_feed_id and ww.watchedTime=cf.duration_time and ww.videoId=?";

	public static String INSERT_ONDEMAND_VIDEO_DURATION = "insert into ondemand_work_out(videoId,userId,watchedTime,done,created,lastUpdated) values(?,?,?,?,now(),now()) ";

	public static String UPDATE_ONDEMAND_VIDEO_DURATION = "update ondemand_work_out set watchedTime=? and done= ? where videoId=? ";

	public static String RESET_CURRENT_WORK_OUT = "delete from weekly_work_out where userId=? and weekNumber = ? and done is null  ";

	public static String GET_USER_SQL_FB = "Select a.id, a.currentModule, a.currentLevel,a.height,a.weight,a.bmi, a.score, a.cycle, a.email, a.fname, a.lname, a.dob, a.gender, a.userType, a.trialBeginDate, a.trialEndDate, a.subsBeginDate, a.subsEndDate, case when a.calibration IS NULL then 0 else 1 end CalibFlag, case when (select 1 from userhc b  where b.userid= a.id limit 1) is not null then 1 else 0 end hcFlag, (select count(*) from usergift ug where ug.userId = a.id and ug.token is null) availableGiftCount, btMorning, btAfternoon, btEvening from users a where a.email = ? ";

	public static String GET_USER_SQL = "Select a.id, a.currentModule, a.currentLevel, a.score,a.height,a.weight,a.bmi, a.cycle, a.email, a.fname,a.height,a.weight,a.bmi, a.lname, a.dob, a.gender, a.userType, a.trialBeginDate, a.trialEndDate, a.subsBeginDate, a.subsEndDate, case when a.calibration IS NULL then 0 else 1 end CalibFlag, case when (select 1 from userhc b  where b.userid= a.id limit 1) is not null then 1 else 0 end hcFlag, (select count(*) from usergift ug where ug.userId = a.id and ug.token is null) availableGiftCount, btMorning, btAfternoon, btEvening from users a where a.email = ? and  pwd = SHA1(?) ";

	public static String GET_USER_SQL_BY_EMAIL = "Select a.id, a.score, a.cycle, a.email, a.fname,a.height,a.weight,a.bmi,a.lname, a.dob, a.gender, a.userType, a.trialBeginDate, a.trialEndDate, a.currentLevel, a.currentModule, a.subsBeginDate, a.subsEndDate, case when a.calibration IS NULL then 0 else 1 end CalibFlag, case when (select 1 from userhc b  where b.userid= a.id limit 1) is not null then 1 else 0 end hcFlag, (select count(*) from usergift ug where ug.userId = a.id and ug.token is null) availableGiftCount, btMorning, btAfternoon, btEvening from users a where a.email = ? ";

	public static String ADD_USER_SQL = "Insert into users (pwd, email, fname, mname, lname, dob, gender, score,btMorning,btAfternoon,btEvening, created, lastupdated, userType, trialBeginDate, trialEndDate,height,weight,bmi) values (SHA1(?),?,?,?,?,?,?,?,1,1,1,?,?,?,?,?,?,?,?)";

	public static String GET_ALL_PLAN_SQL = "select * from workoutplan; ";

	public static String GET_ALL_PLANCAT_BY_ID_SQL = "select * from plan_cat_list where catId=? and disable=0; ";

	public static String GET_ON_DEMAND_CONTENT = "select * from on_demand_content where id=?";
	public static String GET_PLAN_STRUCT_BY_ID = "SELECT *,(select description from plan_cat_list where id=e.firstCatId) AS firstCatName, (select approxMinutes from plan_cat_list where id=e.firstCatId) AS firstCatMinutes, (select description from plan_cat_list where id=e.secondCatId) AS secondCatName,  (select approxMinutes from plan_cat_list where id=e.secondCatId) AS secondCatMinutes, (select approxMinutes from plan_cat_list where id=e.thirdCatId) AS thirdCatMinutes,"
			+ "(select description from plan_cat_list where id=e.thirdCatId) AS thirdCatName FROM plan_structure AS e where e.plan_id=? and e.fitnessLevel=? ";

	public static String GET_VIDEO_BY_PARAM = "SELECT * from content_feed where levelId in (?) and catId in (?) and bodyFocusId=? and equipmentId=? and prenatal=? and pickAplan=? and content_feed_id > ? and enable=1 order by content_feed_id limit ?";

	public static String GET_VIDEO_BY_CRITERIA = "SELECT * from content_feed c join instructor i on i.id=c.instructorId and c.levelId=? and c.catId in (?) and c.bodyFocusId=? and c.equipmentId=? and c.prenatal=? order by c.content_feed_id ";

	public static String GET_MAXVIDEO_WEEKNUM = "select a.* from weekly_work_out a inner join (select catId, max(id) as maxid from weekly_work_out where userId= ? group by catId) as b on a.id = b.maxid and a.userId=? order by weekNumber desc";

	public static String GET_GOAL_BASE_ON_PLAN = "select goalId,duration from weeklygoalmin where planId= ? ";

	public static String GET_WORKTYPE_BASE_ON_PLAN = "select typeId,name from workouttypes where planId= ? ";

	public static String GET_BODYPARTS = "select * from bodyparts";

	public static String GET_EQUIPMENTS = "select * from equipments";

	public static String ADD_GIFT_USER_SQL = "Insert into users (pwd, email, fname, mname, lname, dob, gender, score,btMorning,btAfternoon,btEvening, created, lastupdated, userType, subsBeginDate, subsEndDate) values (SHA1(?),?,?,?,?,?,?,?,1,1,1,?,?,?,?,?)";

	public static String CHG_PWD_SQL = "Update users set pwd = SHA1(?), lastupdated = ? where email = ? and pwd = SHA1(?) ";

	public static String FGT_PWD_SQL = "Select id, SHA1(pwd) from users where email = ? ";

	public static String UPD_USER_SQL = "Update users set ";

	public static String UPD_USER_SUBSCRIPTION_SQL = "Update users set userType = ?, lastupdated = ?, subsBeginDate = ?, subsEndDate = ? where email = ?";

	public static String GET_HC_SQL = "Select id, des,link,hcode from hc";

	public static String GET_ELIGIBILITY_SQL = "Select id, startinglevel, score,cycle, ratio from users where email = ?";

	public static String USER_ID_SQL = "Select id from users where email = ? ";

	public static String UPRT_HC_SQL = "INSERT INTO userhc (userid,hcid,created,lastupdated) VALUES (?,?,now(),now()) ON DUPLICATE KEY UPDATE userid = values(userid), hcid=values(hcid), lastupdated=now()";

	public static String UPD_USR_CYC_SQL = "Update users set cycle=?, metrics = ?, calibration = '1', lastupdated = now() where email = ?";

	public static String ADD_USERLOG_SQL = "INSERT INTO userCourseLog (userid,loginDateTime,logoutDateTime, startTime,endTime,courseId,courseDuration,ipAddress,inhaleTime,exhaleTime,retentionTime,courseBucket,deviceName,created,lastUpdated,score,courseModule, currentLevel)values(?,?,?,?,?,?,?,?,?,?,?,?,?,now(),now(),?,?,?)";

	public static String ADD_COURSEREV_SQL = "INSERT INTO userCourseReview (userid,courseId,fName,lName,feedback, ratings,created,lastUpdated)values(?,?,?,?,?,?,now(),now())";

	// public static String
	// ADD_VIDEO_INTO_WORK_OUT_SQL="INSERT INTO weekly_work_out
	// (weekNumber,videoId,userId,dayId,catId,planId,created,lastUpdated)values(?,?,?,?,?,?,now(),now())";

	public static String GET_CURRENT_WORKOUT_VIDEOS = "SELECT w.btm_code,w.bt_status,w.id,w.weekNumber,w.videoId,w.userId,w.watchedTime,w.done,w.dayId,w.catId,w.planId,c.title,c.image_url,c.content_url,c.content_text,c.feed_type,c.comment_count,c.energy_score,c.relax_score,i.pic,i.name,i.bio,c.duration_time,w.lastUpdated,w.created,p.name as planName FROM ebdb.weekly_work_out w join content_feed c on w.videoId=c.content_feed_id join instructor i on i.id=c.instructorId join workoutplan p on w.planId=p.id and w.userId=? and w.weekNumber in (SELECT MAX(weekNumber) from ebdb.weekly_work_out where userid=?) and w.catId not in (61,62) and w.done is null order by w.lastUpdated desc";

	public static String GET_CURRENT_WORKOUT_VIDEOS1 = "SELECT c.audioLink AS audioUrl, 'Video' AS feed_type, '' AS comment_count, '' AS energy_score,'' AS relax_score, '' AS duration_time, w.btm_code,w.bt_status,w.id,w.weekNumber,w.videoId,w.userId,w.watchedTime,w.done,w.dayId,w.catId,w.planId,c.nameOfTech AS title,c.image_url,c.videoLink AS content_url,c.description AS content_text,i.pic,i.name,i.bio,w.lastUpdated,w.created,p.name as planName FROM ebdb.weekly_work_out w join btmodule c on w.videoId=c.id join instructor i on i.id=c.instructor_id join workoutplan p on w.planId=p.id and w.userId=? and w.weekNumber in (SELECT MAX(weekNumber) from ebdb.weekly_work_out where userid=?) and w.catId  in (61,62) and w.done is null order by w.lastUpdated desc";

	public static String GET_CURRENT_WORKOUT_CRITERIA = "select distinct planId,fitnessLevel,flexiblityType,bodyFocus,equipment,strengthnings,lastUpdated from weekly_work_out where userId=? and  weekNumber in (SELECT MAX(weekNumber) from ebdb.weekly_work_out where userid=?) and done is null order by lastUpdated desc";

	public static String GET_COURSE_DTS_SQL = "SELECT distinct f.breathTechnique as name,case when b.mSequence != 0 then 'M' when b.aSequence != 0 then 'A' when b.eSequence != 0 then 'E' end courseDay, e.id,e.description,e.audioLink,e.animationLink,e.courseDuration,e.breathCycle FROM users a,hcbtmap b,hc c,userlevel d,btmodule e,bt f WHERE b.hcId in (select uhc1.hcId from userhc uhc1 where uhc1.userId = a.id)  and b.hcId = c.id and d.userid = a.id and e.breathTechnique = b.btCode and (b.mSequence = a.btMorning or b.aSequence = a.btAfternoon or b.eSequence = a.btEvening) and e.module = case when a.score >=50 then d.nextModule else d.currentModule end and e.level=  case when a.score >=50 then d.nextLevel else d.currentLevel end and f.code = e.breathTechnique and e.breathTechnique not in (select emap.btCode from exclusionmap emap where emap.hcId=b.hcId and (strcmp('M1', emap.moduleLimit) > 0  or (strcmp('M1', emap.moduleLimit) =0 and strcmp('L1', emap.levelLimit) >= 0)) ) "
			+ " and d.id =? and email = ? group by courseDay order by d.created desc";

	public static String GET_COURSES_SQL = "select id, breathTechnique, module, level,sublevel,audiolink,breathSequence, breathcycle, ratio, courseduration, description,nextModule,nextLevel from btmodule a where a.id=?";

	public static String GET_REVIEWS_SQL = "select fName,lName,feedback, ratings from userCourseReview where courseId = ?";

	public static String UPD_USER_PRI_HC_DEF = "update users set primaryhealthcondition = 0, lastupdated=now() where email=?";

	public static String UPD_USER_PRI_HC = "update users set primaryhealthcondition =?, lastupdated=now() where email =?";

	public static String GET_USER_FULL_SQL = "select id, email, fname, lname, dob, gender, currentlevel, score, calibration, a.btMorning as btMorning, a.btAfternoon as btAfternoon, a.btEvening as btEvening from users a where email=?";

	public static String ADD_USER_LEVL = "insert into userlevel (userid, currentModule, nextModule, currentLevel, nextLevel, created, lastupdated) select distinct b.id, a.module,a.nextModule, a.level,  a.nextLevel,now(),now() from btmodule a,(select id from users where email = ?) b where a.breathcycle = ? limit 1";

	public static String ADD_USER_LEVL_COUR_UPD = "insert into userlevel (userid, currentModule, nextModule, currentLevel, nextLevel, currentLevelTime,points, created, lastupdated) VALUES (?,?,?,?,?,?,?,now(),now()) ";

	public static String GET_USER_LEVL = "select userid, currentModule, nextModule, currentLevel, nextLevel, created, lastupdated from userlevel where userid=?";

	public static String GET_USER_LEVL_LST = "select a.* from userlevel a, users c where a.created = (select max(created) from userlevel b where b.userid= a.userid) and a.userid= c.id and c.email=? order by a.id desc limit 1";

	public static String GET_USER_BRTH_SEQ = "SELECT b.id as hcMapId, a.btMorning as mSequence, a.btAfternoon as aSequence, a.btEvening as eSequence FROM users a, hcbtmap b, hc c, userlevel d, btmodule e, bt f WHERE a.primaryhealthcondition = b.hcId and 	b.hcId = c.id and d.userid = a.id and	e.breathTechnique = b.btCode and 	(b.mSequence = a.btMorning  or b.aSequence = a.btAfternoon or b.eSequence = a.btEvening) and  e.module = d.currentModule and	e.level = d.currentLevel and  f.code = e.breathTechnique and d.id = ? and a.email = ?";

	public static String GET_HLTH_MAP = "select a.mSequence, a.aSequence, a.eSequence from hcbtmap a, btmodule b where a.btCode=b.breathTechnique and a.hcId=? and b.id=?";

	public static String UPD_USER_SCORE_MSEQ = "update users set score =?, btMorning=?, lastupdated=now() where email =?";

	public static String UPD_USER_SCORE_ASEQ = "update users set score =?, btAfternoon=?, lastupdated=now() where email =?";

	public static String UPD_USER_SCORE_ESEQ = "update users set score =?, btEvening=?, lastupdated=now() where email =?";

	public static String UPD_USER_SCORE_RESET = "update users set score =10, lastupdated=now() where score >50 and email =?";

	public static String ADD_PAYMENT_INFO_SQL = "Insert into paymentHistory (id, purchaseMethod, paymentType, billedAmount, transactionId, otherDetails, created, lastupdated) values ((Select id from users where email = ?),?,?,?,?,?,?,?)";

	public static String GET_PAYMENT_HISTORY_SQL = "select * from paymentHistory where id = (Select id from users where email = ?) order by created desc";

	public static String ADD_GIFT_PURCHASE_INFO_SQL = "Insert into giftPurchaseInfoHistory (id, annualSubscription, noOfOrders, giftSubscription, bonusSubscription, amountDue, created, lastupdated, transactionId) values ((Select id from users where email = ?), ?,?,?,?,?,?,?,?)";

	public static String ADD_USER_GIFT_SQL = "Insert into usergift (userId, amount, created) values ((Select id from users where email = ?),?, ?)";

	public static String UPDATE_USER_GIFT_SQL = "Update usergift set sentTo = ?, sentOn = ?, token = ? where userId = ? and sentTo is null and token is null limit 1";

	public static String GET_GIFT_AVAILABLE = "select * from usergift ug where ug.userId = ? and ug.token is null";

	public static String UPDATE_USER_GIFT_ON_REGIS_SQL = "Update usergift set registeredEmail = ?, registeredDate = ? where token = ?";

	public static String VALID_USER_GIFT_TOKEN_SQL = "select count(*) from usergift where registeredEmail is null and registeredDate is null and token = ?";

	public static String GET_PENDING_GIFT_AVAILABLE = "select * from usergift ug where registeredEmail is null and registeredDate is null and ug.token is not null and ug.userId = ? order by sentOn desc";

	public static String GET_PROCESSED_GIFT_AVAILABLE = "select * from usergift ug where registeredEmail is not null and registeredDate is not null and ug.token is not null and ug.userId = ?  order by sentOn desc";

	public static String GET_SYS_PREFERENCE = "select * from systemPreference";

	public static String UPDATE_TRIAL_USER_BREATHE_LEVEL = "update users set btMorning=?, btAfternoon=?, btEvening=? where email=?";

	public static String ADD_USER_CALIB = "insert into usercalibration (userId, cycle, ratio, metrics, created, lastUpdated) values (?,?,?,?,now(),now())";

	public static String ADD_RESET_PWD_TOKEN_SQL = "Insert into resetPassword (userId, resetRequestOn, resetToken) values (?,?,?)";

	public static String GET_PENDING_RESET_PWD_TOKEN_SQL = "select * from resetPassword where userId=? and resetRequestOn is not null and  resetToken is not null and resetOn is null";

	public static String RESET_PWD_SQL = "update resetPassword set resetOn = ? where resetToken = ? and resetRequestOn is not null and resetOn is null";

	public static String UPDATE_PWD_SQL = "Update users set pwd = SHA1(?), lastupdated = ? where id = ? ";

	public static String GET_USER_ID_RESET_TOKEN_SQL = "select userId from resetPassword where resetToken = ? limit 1";

	public static String GET_USER_STATS = "select c.dailyScore score,c.totalTimeSpent totalTimeSpent,c.dailyPercentage percentage,c.created date,c.maxModule module,c.maxLevel level, c.breathTechnique courseName, (select   avg(d.courseDuration)   from  (select  b.courseDuration, date(created) created  from userCourseLog b  where userid = ?  group by date(created)) d   where  datediff(d.created, c.created) <= c.movingAvg) movingAvg from (select sum(a.score) dailyScore,  sum(a.endTime-a.startTime) totalTimeSpent,  sum(a.courseDuration) / b.courseDuration * 100 dailyPercentage,  Date(a.created) created,  a.userId id,  max(a.courseModule) maxModule,  max(a.currentLevel) maxLevel,b.movingAvg, btt.breathTechnique from   userCourseLog a, systemPreference b, bt btt   where   Date(a.created) <= Date(Date_sub(sysdate(), interval 1 day))  and a.userid = ? group by Date(a.created)) c";

	public static String GET_USER_HEATH_CONDITION_SQL = "SELECT hc.* FROM hc hc, userhc uhc where hc.id = uhc.hcid and uhc.userid  = (select u.id from users u where u.email = ?) order by uhc.id desc";

	public static String GET_USER_BT = "SELECT hbt.* FROM hcbtmap as hbt  where hbt.hcId in (:ids) order by hbt.id ";

	public static String GET_ALL_HEALTH_CONDITIONS = "SELECT  hc.hcode conditions, hc.des description, hc.id code , (select 1 from userhc uhc where uhc.userid = ? and uhc.hcid = hc.id) userHasCondition FROM hc hc where hc.hcode <> 'DEF'";

	public static String DELETE_USER_HEALTH_CONDITINS = "delete from userhc where userid = ?";

	public static String ADD_USER_HC_SQL = "INSERT INTO userhc (userid,hcid, created,lastupdated) VALUES (?,?,now(),now())";

	public static String GET_DEF_HEALTH_CONDITIONS = "SELECT hc.id code FROM hc hc where hc.hcode = 'DEF'";

	public static String ADD_EMAIL_ARCHIVE_SQL = "Insert into emailarchive (userId, recipients, emailType, subject, body, created, lastUpdated) values (?,?,?,?,?,now(),now())";

	// public static String GET_HEALTHCONDITIONS_EXCLUSION =
	// "SELECT * from exclusionmap where hcId in (:ids)";

	public static String GET_HEALTHCONDITIONS_EXCLUSION = "SELECT * FROM exclusionmap em, hc where hcId in (:ids) and em.hcId = hc.id and (hc.modulelimit < :moduleLimit  or (hc.modulelimit = :moduleLimit and hc.levellimit <= :levelLimit ))";

	// SELECT * FROM btmodule btm left join bt bt on btm.btId = bt.code where
	// btId in ('DRTPRD','PSPREG') and module = 'M2' ;
	public static String GET_BREATHING_MODULES = "SELECT btm.*, bt.breathTechnique as name, bt.desc as btDesc,i.name as trainerName,i.bio as trainerBio,i.pic as trainerImage  FROM btmodule btm left join bt bt on btm.btId = bt.code left join instructor as i on btm.instructor_id=i.id where btId in  (:ids) and module = :module and level = :level order by btm.id desc";

	public static String UPD_USER_SCORE = "update users set score =? where email =?";

	public static String UPD_USER_SCORE_AND_LEVEL = "update users set score =?, currentLevel=?, currentModule=?  where email =?";

	public static String GET_BREATH_CYCLE = "SELECT * FROM breath_cycle_ml_map where current_level = ? and current_module = ?";

	public static String UPD_USR_CALIBRATION_SQL = "Update users set cycle=?, metrics = ?, currentLevel = ?, currentModule = ?, calibration = '1', lastupdated = now() where email = ?";

	public static String GET_BREATH_CYCLE_MODULE_LEVELS = "SELECT * FROM breath_cycle_ml_map where cycle = ?";

	// public static String GET_ALL_CONTENT_FEEDS =
	// "SELECT * FROM content_feed order by category_order_id";
	public static String GET_ALL_CONTENT_FEEDS = "SELECT * FROM content_feed cf join content_feed_favourite cff on cf.content_feed_id = cff.content_feed_type_id  where  isFavour=1 and cff.user_email_id = ? order by category_order_id";

	public static String GET_FAVORITE_CONTENT_FEEDS_BY_EMAIL = "SELECT * FROM content_feed cf right join content_feed_favourite cff on cf.content_feed_id = cff.content_feed_type_id where user_email_id = ? order by category_order_id";

	public static String SAVE_FAVORITE_BY_EMAIL_FID = "INSERT INTO content_feed_favourite (content_feed_type_id,user_email_id,created_dttm )values(?,?,now())";

	public static String DELETE_FAVORITE_BY_EMAIL_FID = "delete from content_feed_favourite where id = ? ";

	public static String SAVE_FAVORITE_BY_EMAIL_FID_VALIDATION = "SELECT * FROM content_feed_favourite where content_feed_type_id = ? and user_email_id = ?";

	public static String SAVE_CONTENT_FEED_COMMENT = "INSERT INTO content_feed_comment (user_id, email_id, content_feed_id, first_name, last_name, comment_text, ratings, created_dttm, updated_dttm ) values(?,?,?,?,?,?,?,?,?)";

	public static String UPDATE_CONTENT_FEED_COMMENT_IN_MAIN_FEED = "update content_feed set comment_count = (comment_count+1), comment_like = (comment_like+?) where content_feed_id = ?";

	public static String GET_CONTENT_FEED_COMMENT_ID = "SELECT *, (select sum(ratings)/5 FROM content_feed_comment cfcinn where cfcinn.content_feed_id = cfc.content_feed_id) as likes FROM content_feed_comment cfc where content_feed_id = ? ;";
	public static String GET_PLAN_STRA_WITH_MB_GR = "SELECT * FROM  `plan_structure` WHERE  `plan_id` =? AND  `fitnessLevel` =? AND (`FirstCatId` IN ( 61, 62 ) OR  `SecondCatId` IN ( 61, 62 ) OR  `ThirdCatId` IN ( 61, 62 )";
	public static String GET_USER_SQL_BY_USER_ID = "Select a.id, a.height,a.weight,a.bmi, a.score, a.cycle, a.email, a.fname, a.lname, a.dob, a.gender, a.userType, a.trialBeginDate, a.trialEndDate, a.currentLevel, a.currentModule, a.subsBeginDate, a.subsEndDate, case when a.calibration IS NULL then 0 else 1 end CalibFlag, case when (select 1 from userhc b  where b.userid= a.id limit 1) is not null then 1 else 0 end hcFlag, (select count(*) from usergift ug where ug.userId = a.id and ug.token is null) availableGiftCount, btMorning, btAfternoon, btEvening from users a where a.id = ? ";
	public static String GET_GUIDED_IMAGERY = "SELECT *  FROM `content_feed` WHERE `catId` BETWEEN 70 AND 80";



}
