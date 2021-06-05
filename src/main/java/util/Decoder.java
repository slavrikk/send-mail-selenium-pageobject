package util;

import org.apache.commons.codec.binary.Base64;

public class Decoder {

    public static String decodePassword(String pass) {
        byte[] decodedBytes = Base64.decodeBase64(pass);
        return new String(decodedBytes);
    }
}
