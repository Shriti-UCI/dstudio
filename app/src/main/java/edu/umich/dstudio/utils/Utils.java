package edu.umich.dstudio.utils;

/**
 * Created by neera_000 on 3/26/2016.
 */
public class Utils {
    public static final String encodeEmail(String unencodedEmail) {
        if (unencodedEmail == null) return null;
        return unencodedEmail.replace(".", ",");
    }
}

