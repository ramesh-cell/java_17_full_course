package com.carrier_test.mqtt;

public class N2Protocol {
    public static void main(String[] args) {
        byte[] command = {0x01, 0x03, 0x00, 0x01, 0x00, 0x02}; // Read temperature
        System.out.println("Sending N2 Command: " + bytesToHex(command));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) result.append(String.format("%02X ", b));
        return result.toString();
    }
}
