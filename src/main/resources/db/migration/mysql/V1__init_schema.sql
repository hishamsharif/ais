-- create database ais; -- Creates the new database 
-- create user "aisapp" identified by '123'; -- Creates the user
-- grant all on ais.* to "aisapp"; -- Gives all privileges to the new user 


CREATE TABLE IF NOT EXISTS ais.land_plots (
    id BIGINT NOT NULL AUTO_INCREMENT,
    latitude DOUBLE DEFAULT NULL,
    longitude DOUBLE DEFAULT NULL,
    plot_area DOUBLE DEFAULT NULL,
    region VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS ais.iot_device_type (
    id BIGINT NOT NULL,
    name VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS ais.iot_devices (
    id BIGINT NOT NULL,
    device_type_id BIGINT DEFAULT NULL,
    land_plot_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    KEY FKnuxj59iltvf2wk8cqp5wpdmq7 (device_type_id),
    KEY FKgov9y642bw6jnnkb9ijx18cpp (land_plot_id),
    CONSTRAINT FKgov9y642bw6jnnkb9ijx18cpp FOREIGN KEY (land_plot_id)
        REFERENCES land_plots (id)
        ON DELETE CASCADE,
    CONSTRAINT FKnuxj59iltvf2wk8cqp5wpdmq7 FOREIGN KEY (device_type_id)
        REFERENCES iot_device_type (id)
)  ENGINE=INNODB;


CREATE TABLE IF NOT EXISTS ais.irrigation_schedules (
    id BIGINT NOT NULL,
    from_date DATE DEFAULT NULL,
    to_date DATE DEFAULT NULL,
    land_plot_id BIGINT NOT NULL,
    iot_device_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    KEY FKrtktyhgr2j8g2gsm3uls8ostc (land_plot_id),
    KEY FKtimfqyjyt7kfcxntjnxkwb4a7 (iot_device_id),
    CONSTRAINT FKrtktyhgr2j8g2gsm3uls8ostc FOREIGN KEY (land_plot_id)
        REFERENCES land_plots (id)
        ON DELETE CASCADE,
    CONSTRAINT FKtimfqyjyt7kfcxntjnxkwb4a7 FOREIGN KEY (iot_device_id)
        REFERENCES iot_devices (id)
        ON DELETE CASCADE
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS ais.irrigation_slot_times (
    id BIGINT NOT NULL,
    end_time TIME DEFAULT NULL,
    is_pumping TINYINT(1) DEFAULT '0',
    start_time TIME DEFAULT NULL,
    water_quantity DECIMAL(10 , 2 ) DEFAULT '1.00',
    irrigation_schedule_id BIGINT DEFAULT NULL,
    PRIMARY KEY (id),
    KEY i_irrigation_slot_times_period (start_time , end_time),
    KEY FK8oqo3vqoorrbh6ymq2lo1t6jv (irrigation_schedule_id),
    CONSTRAINT FK8oqo3vqoorrbh6ymq2lo1t6jv FOREIGN KEY (irrigation_schedule_id)
        REFERENCES irrigation_schedules (id)
)  ENGINE=INNODB;



CREATE TABLE IF NOT EXISTS ais.iot_device_sensor_readings (
    id BIGINT NOT NULL,
    read_timestamp TIMESTAMP NULL DEFAULT NULL,
    value DECIMAL(10 , 2 ) DEFAULT '1.00',
    iot_device_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    KEY FKi8kf8kit5ctljyma83h6mierl (iot_device_id),
    CONSTRAINT FKi8kf8kit5ctljyma83h6mierl FOREIGN KEY (iot_device_id)
        REFERENCES iot_devices (id)
        ON DELETE CASCADE
)  ENGINE=INNODB;






 


