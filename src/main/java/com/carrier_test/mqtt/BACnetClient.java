//package com.test.demo.carrier_test.mqtt;
//
//import com.serotonin.bacnet4j.LocalDevice;
//import com.serotonin.bacnet4j.RemoteDevice;
//import com.serotonin.bacnet4j.service.confirmed.ReadPropertyRequest;
//import com.serotonin.bacnet4j.type.primitive.ObjectIdentifier;
//
//public class BACnetClient {
//    public static void main(String[] args) throws Exception {
//        LocalDevice localDevice = new LocalDevice(12345, "192.168.1.100");
//        RemoteDevice hvacController = new RemoteDevice(67890, "192.168.1.101");
//
//        ReadPropertyRequest readRequest = new ReadPropertyRequest(
//            new ObjectIdentifier(1, 0), // Object Type (Analog Input)
//            com.serotonin.bacnet4j.type.enumerated.PropertyIdentifier.presentValue
//        );
//
//        System.out.println("Temperature Reading: " + readRequest);
//        localDevice.terminate();
//    }
//}
