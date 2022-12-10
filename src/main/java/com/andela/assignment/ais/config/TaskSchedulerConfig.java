package com.andela.assignment.ais.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.EnableScheduling;

// the below annotation is not working and required to move up to the main application  
@EnableScheduling
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
public class TaskSchedulerConfig {

}
/*
 * public class TaskSchedulerConfig implements SchedulingConfigurer {
 * 
 * private IrrigationService irrigationService;
 * 
 * @Bean public Executor taskExecutor() { return
 * Executors.newSingleThreadScheduledExecutor(); }
 * 
 * @Override public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
 * 
 * 
 * taskRegistrar.setScheduler(taskExecutor()); taskRegistrar.addTriggerTask( ()
 * -> irrigationService.pumpWater(), context -> { Optional<Date>
 * lastCompletionTime = Optional.ofNullable(context.lastCompletionTime());
 * Instant nextExecutionTime =
 * lastCompletionTime.orElseGet(Date::new).toInstant()
 * .plusMillis(irrigationService.getDelay()); return
 * Date.from(nextExecutionTime); } );
 * 
 * 
 * } }
 */
