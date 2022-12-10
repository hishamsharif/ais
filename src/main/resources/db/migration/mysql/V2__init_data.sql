INSERT INTO `ais`.`land_plots` (`id`, `latitude`, `longitude`, `plot_area`, `region`) VALUES ('101', '6.866361', '79.870962', '125', 'colombo-north');
INSERT INTO `ais`.`land_plots` (`id`, `latitude`, `longitude`, `plot_area`, `region`) VALUES ('102', '8.866361', '59.870962', '60', 'kandy');

INSERT INTO `ais`.`iot_device_type` (`id`, `name`) VALUES ('1', 'soil-moisture');
INSERT INTO `ais`.`iot_devices` (`id`, `device_type_id`, `land_plot_id`) VALUES ('201', '1', '101');
INSERT INTO `ais`.`iot_devices` (`id`, `device_type_id`, `land_plot_id`) VALUES ('202', '1', '101');

INSERT INTO `ais`.`irrigation_schedules` (`id`, `from_date`, `to_date`, `land_plot_id`, `iot_device_id`) VALUES ('301', '2023-01-01', '2023-01-31', '101', '201');
INSERT INTO `ais`.`irrigation_schedules` (`id`, `from_date`, `to_date`, `land_plot_id`, `iot_device_id`) VALUES ('302', '2023-01-01', '2023-01-15', '101', '202');

INSERT INTO `ais`.`irrigation_slot_times` (`id`, `end_time`, `is_pumping`, `start_time`, `water_quantity`, `irrigation_schedule_id`) VALUES ('1', '10:30', '0', '10:00', '40', '301');



 