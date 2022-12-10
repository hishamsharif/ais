package com.andela.assignment.ais.usecase.service;

import org.eclipse.paho.client.mqttv3.MqttException;

public interface IrrigationActivatorService {
	public void pumpWater() throws InterruptedException, MqttException;
}
