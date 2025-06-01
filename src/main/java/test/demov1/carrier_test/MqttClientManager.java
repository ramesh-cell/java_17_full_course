//package com.test.demo.carrier_test;
//
//import org.eclipse.paho.client.mqttv3.*;
//
//public class MqttClientManager {
//    private static final String BROKER_URL = "tcp://broker.hivemq.com:1883";
//    private static final String CLIENT_ID = "HVAC_MQTT_Client";
//    private MqttClient client;
//
//    public void connect() {
//        try {
//            client = new MqttClient(BROKER_URL, CLIENT_ID);
//            MqttConnectOptions options = new MqttConnectOptions();
//            options.setCleanSession(true);
//            client.connect(options);
//            System.out.println("Connected to MQTT Broker!");
//
//            client.subscribe("hvac/control", (topic, msg) ->
//                    System.out.println("Received command: " + new String(msg.getPayload())));
//
//        } catch (MqttException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void publishMessage(String topic, String payload) {
//        try {
//            client.publish(topic, new MqttMessage(payload.getBytes()));
//        } catch (MqttException e) {
//            e.printStackTrace();
//        }
//    }
//}
