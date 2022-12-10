package com.andela.assignment.ais.adaptor.gateway.messaging;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MqttTemplate {

	private IMqttClient mqttClient;

	@Value("${mqtt.topic.prefix:'plots/devices/'}")
	private String topicPrefix;

	@Value("${mqtt.qos:2}")
	private int qos;

	public MqttTemplate(IMqttClient mqttClient) {
		this.mqttClient = mqttClient;

	}

	public void publish(final long deviceId, final String payload) throws MqttPersistenceException, MqttException {
		this.publish(this.topicPrefix.concat(String.valueOf(deviceId)), payload, this.qos, true);
	}

	public void publish(final String topic, final String payload, int qos, boolean retained)
			throws MqttPersistenceException, MqttException {
		MqttMessage mqttMessage = new MqttMessage();
		mqttMessage.setPayload(payload.getBytes());
		mqttMessage.setQos(qos);
		mqttMessage.setRetained(retained);

		mqttClient.publish(topic, mqttMessage);
		mqttClient.disconnect();
	}

	public void subscribe(final String topic) throws MqttException, InterruptedException {
		log.info("Messages received:");

		mqttClient.subscribeWithResponse(topic, (tpic, msg) -> {
			log.info(msg.getId() + " -> " + new String(msg.getPayload()));
		});
	}

}