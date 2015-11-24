package com.simone.mqtt.client;


import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Publisher {

	  MqttClient client;
	  
	  public Publisher() {}

	  public static void main(String[] args) {
	    new Publisher().doDemo();
	  }

	  public void doDemo() {
	    try {
	      client = new MqttClient("tcp://localhost:1883", "pahomqttpublish1");
	      client.connect();
	      MqttMessage message = new MqttMessage();
	      message.setPayload("A single message".getBytes());
	      System.out.println("messaggio inviato");
	      client.publish("pahodemo/test", message);
	      client.disconnect();
	    } catch (MqttException e) {
	      e.printStackTrace();
	    }
	  }
}

