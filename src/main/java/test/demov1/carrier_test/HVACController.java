//package com.test.demo.carrier_test;
//
//import com.iot.hvac.mqtt.MqttClientManager;
//import com.iot.hvac.sensors.TemperatureSensor;
//
//public class HVACController {
//    public static void main(String[] args) {
//        MqttClientManager client = new MqttClientManager();
//        client.connect();
//
//        while (true) {
//            int temp = TemperatureSensor.readTemperature();
//            System.out.println("Current Temp: " + temp + "°C");
//
//            if (temp > 25) {
//                System.out.println("Cooling ON...");
//                client.publishMessage("hvac/control", "COOLING_ON");
//            } else {
//                System.out.println("Heating ON...");
//                client.publishMessage("hvac/control", "HEATING_ON");
//            }
//
//            try {
//                Thread.sleep(5000); // Simulate sensor reading every 5 sec
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
