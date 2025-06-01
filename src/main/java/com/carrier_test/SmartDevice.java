package com.carrier_test;

import java.util.Random;

public class SmartDevice {
    public static void main(String[] args) {
        Random random = new Random();

        while (true) {
            int temperature = 20 + random.nextInt(10); // Simulating sensor data
            System.out.println("Temperature: " + temperature + "°C");
            
            // Send data to cloud
            sendToCloud(temperature);
            
            try {
                Thread.sleep(5000); // Send data every 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
/*
* 📌 Communication Protocols – Modbus, MQTT, OPC-UA
Carrier’s smart devices use different protocols to send data from HVAC sensors to the cloud. Let's understand each one.

1️⃣ Modbus (Used in Industrial Systems)
📌 What is it?
Modbus is an old but widely used protocol for communication between industrial devices like HVAC controllers, sensors, and PLCs (Programmable Logic Controllers).

🔹 How it works:

Devices use a Master-Slave model (e.g., a central controller asks sensors for data).

Modbus transmits data over RS-485, TCP/IP, or serial communication.

Used in HVAC, power grids, and factories.

🔹 Example: Reading Temperature Data via Modbus in Java

java
-----
ModbusMaster master = new ModbusMaster("192.168.1.100", 502); // Modbus TCP/IP
int temperature = master.readHoldingRegisters(1, 0, 1)[0]; // Read register
System.out.println("Temperature: " + temperature + "°C");
📌 Use case: Controlling industrial HVAC units remotely.

2️⃣ MQTT (Used in IoT & Smart Homes)
📌 What is it?
MQTT (Message Queuing Telemetry Transport) is a lightweight protocol used in IoT applications for sending sensor data efficiently.

🔹 How it works:

Publish/Subscribe Model → Devices send data to a "broker" (server), and apps subscribe to receive updates.

Uses low bandwidth (good for remote IoT devices).

Secure & reliable.

🔹 Example: Sending Temperature Data via MQTT in Java

MqttClient client = new MqttClient("tcp://broker.hivemq.com:1883", "hvac-sensor");
client.connect();
client.publish("hvac/temperature", new MqttMessage("25°C".getBytes()));
System.out.println("Temperature sent to cloud.");
📌 Use case: Smart home air conditioning controlled from a mobile app.

3️⃣ OPC-UA (Used in Secure Industrial Systems)
📌 What is it?
OPC-UA (Open Platform Communications - Unified Architecture) is an advanced industrial protocol used in factories, HVAC automation, and energy management.

🔹 How it works:

Secure communication (unlike Modbus, which is unencrypted).

Standardized data model for complex industrial devices.

Used in large manufacturing systems.

🔹 Example: Fetching Sensor Data Using OPC-UA in Java

OpcUaClient client = OpcUaClient.create("opc.tcp://192.168.1.200:4840");
client.connect().get();
DataValue value = client.readValue(0, TimestampsToReturn.Both, nodeId);
System.out.println("OPC-UA Temperature: " + value.getValue().getValue() + "°C");
📌 Use case: Secure monitoring of HVAC performance in smart buildings.

📌 Summary: When to Use Which Protocol?
Protocol	Used For	Example Use Case
Modbus	Industrial control (old tech)	HVAC controller in a power plant
MQTT	IoT & Smart Homes	Sending AC temperature data to the cloud
OPC-UA	Secure industrial automation	Monitoring HVAC units in a factory
📌 Final Thoughts
For Carrier Corporation, you should understand:
✅ How HVAC sensors send data to the cloud
✅ When to use Modbus (legacy), MQTT (IoT), or OPC-UA (secure industrial use)
✅ How to implement real-time monitoring in Java
* */

    }

    private static void sendToCloud(int temperature) {
        System.out.println("Sending data to cloud: " + temperature);
        // Logic to send data via MQTT or HTTP API
    }
}
