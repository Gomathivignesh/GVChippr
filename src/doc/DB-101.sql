CREATE TABLE `content_feed` (
  `content_feed_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `category` varchar(100) DEFAULT NULL,
  `category_order_id` int(11) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `image_url` varchar(256) DEFAULT NULL,
  `content_url` varchar(256) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  PRIMARY KEY (`content_feed_id`),
  UNIQUE KEY `content_feed_id` (`content_feed_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



ALTER TABLE `content_feed` CHANGE `content_url` `content_url` VARCHAR(256)  CHARACTER SET latin1  COLLATE latin1_swedish_ci  NULL  DEFAULT NULL  COMMENT 'mp3 or html url';
 ALTER TABLE `content_feed` CHANGE `image_url` `image_url` VARCHAR(256)  CHARACTER SET latin1  COLLATE latin1_swedish_ci  NULL  DEFAULT NULL  COMMENT 'for mp3';
ALTER TABLE `content_feed` ADD `feed_type` VARCHAR(20)  NULL  DEFAULT NULL  COMMENT 'html or audio'  AFTER `content_url`;

ALTER TABLE `content_feed` ADD `content_text` VARCHAR(500)  NULL  DEFAULT NULL  AFTER `content_url`;


CREATE TABLE `content_feed_favourite` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `content_feed_type_id` int(11) DEFAULT NULL,
  `user_email_id` varchar(50) DEFAULT NULL,
  `created_dttm` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


/**
 * 2015-07-26
 * */
ALTER TABLE `content_feed` ADD `comment_count` INT  NULL  DEFAULT NULL  AFTER `feed_type`;
ALTER TABLE `content_feed` ADD `comment_like` INT  NULL  DEFAULT NULL  AFTER `comment_count`;

CREATE TABLE `content_feed_comment` (
  `id` int(1) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `email_id` varchar(45) DEFAULT NULL,
  `content_feed_id` int(11) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `comment_text` text,
  `ratings` varchar(15) DEFAULT NULL,
  `created_dttm` datetime DEFAULT NULL,
  `updated_dttm` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



update hcBTMap set timeOfDay='M' where timeOfDay='A';


/**
 * 2015-08-06
 * ***/
ALTER TABLE `content_feed` ADD `energy_score` INT(11)  NULL  DEFAULT NULL  AFTER `comment_count`;
ALTER TABLE `content_feed` ADD `relax_score` INT(11)  NULL  DEFAULT NULL  AFTER `energy_score`;

update content_feed set energy_score=0, relax_score=0

/** 2015-09-01 */
CREATE TABLE `content_feed_user_log` (
  `content_feed_user_log_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `user_email` varchar(100) DEFAULT NULL,
  `energy_score` int(11) DEFAULT '0',
  `relax_score` int(11) DEFAULT '0',
  `created_dttm` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`content_feed_user_log_id`),
  UNIQUE KEY `content_feed_user_log_id` (`content_feed_user_log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


/** 2016-04-07 ***/
ALTER TABLE `btModule` ADD `nameOfTech` VARCHAR(200)  NULL  DEFAULT NULL  AFTER `nextLevel`;


/** 2015-05-26  **/
ALTER TABLE `content_feed` ADD `trainer_image` VARCHAR(256)  NULL  DEFAULT ''  AFTER `relax_score`;
 ALTER TABLE `content_feed` ADD `trainer_name` VARCHAR(100)  NULL  DEFAULT NULL  AFTER `trainer_image`;
 ALTER TABLE `content_feed` ADD `duration_time` VARCHAR(11)  NULL  DEFAULT NULL  AFTER `trainer_name`;
 ALTER TABLE `content_feed` ADD `trainer_desc` VARCHAR(256)  NULL  DEFAULT NULL  AFTER `trainer_name`;