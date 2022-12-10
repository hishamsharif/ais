create database ais; -- Creates the new database 
create user "aisapp" identified by '123'; -- Creates the user
grant all on ais.* to "aisapp"; -- Gives all privileges to the new user 


-- crate tables

CREATE TABLE `land_plots` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `plot_area` double DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB ;

CREATE TABLE `irrigation_schedules` (
  `id` bigint NOT NULL,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `land_plot_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrtktyhgr2j8g2gsm3uls8ostc` (`land_plot_id`),
  CONSTRAINT `FKrtktyhgr2j8g2gsm3uls8ostc` FOREIGN KEY (`land_plot_id`) REFERENCES `land_plots` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB ;

CREATE TABLE `irrigation_slot_times` (
  `id` bigint NOT NULL,
  `duration` int DEFAULT '15',
  `end_time` timestamp NULL DEFAULT NULL,
  `rate_per_slot` int DEFAULT '1',
  `start_time` timestamp NULL DEFAULT NULL,
  `water_quantity` decimal(10,2) DEFAULT '1.00',
  `irrigation_schedule_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8oqo3vqoorrbh6ymq2lo1t6jv` (`irrigation_schedule_id`),
  CONSTRAINT `FK8oqo3vqoorrbh6ymq2lo1t6jv` FOREIGN KEY (`irrigation_schedule_id`) REFERENCES `irrigation_schedules` (`id`)
) ENGINE=InnoDB ;

CREATE TABLE `iot_devices` (
  `id` bigint NOT NULL,
  `device_type_id` bigint DEFAULT NULL,
  `land_plot_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnuxj59iltvf2wk8cqp5wpdmq7` (`device_type_id`),
  KEY `FKgov9y642bw6jnnkb9ijx18cpp` (`land_plot_id`),
  CONSTRAINT `FKgov9y642bw6jnnkb9ijx18cpp` FOREIGN KEY (`land_plot_id`) REFERENCES `land_plots` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKnuxj59iltvf2wk8cqp5wpdmq7` FOREIGN KEY (`device_type_id`) REFERENCES `iot_device_type` (`id`)
) ENGINE=InnoDB ;

CREATE TABLE `iot_device_type` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB ;

CREATE TABLE `iot_device_sensor_readings` (
  `id` bigint NOT NULL,
  `read_timestamp` timestamp NULL DEFAULT NULL,
  `value` decimal(10,2) DEFAULT '1.00',
  `iot_device_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi8kf8kit5ctljyma83h6mierl` (`iot_device_id`),
  CONSTRAINT `FKi8kf8kit5ctljyma83h6mierl` FOREIGN KEY (`iot_device_id`) REFERENCES `iot_devices` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB ;


 


