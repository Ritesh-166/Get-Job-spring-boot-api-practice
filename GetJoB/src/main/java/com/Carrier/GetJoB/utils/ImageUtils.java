package com.Carrier.GetJoB.utils;

public class ImageUtils {
    public static byte[] stringToBytes(String imageData) {
        byte[] decodedBytes = java.util.Base64.getDecoder().decode(imageData);
        return decodedBytes;
    }

    public static String bytesToString(byte[] encodedData){
        String data = java.util.Base64.getEncoder().encodeToString(encodedData);
        return data;
    }
}
