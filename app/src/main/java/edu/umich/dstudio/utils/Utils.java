package edu.umich.dstudio.utils;

import java.util.Calendar;

/**
 * Created by neera_000 on 3/26/2016.
 */
public class Utils {

    /**
     * Given an email Id as string, encodes it so that it can go into the firebase object without
     * any issues.
     * @param unencodedEmail
     * @return
     */
    public static final String encodeEmail(String unencodedEmail) {
        if (unencodedEmail == null) return null;
        return unencodedEmail.replace(".", ",");
    }

    /**
     * (TODO shriti): Implement this to get times as per the settings.
     * Returns a list of integers, where each integer represent the # of seconds since midnight
     * at which the notification needs to be shown.
     * E.g. if the notification should be shown at noon, 4 PM and 8 PM, this method would return
     * 43200 (i.e. number of seconds between midnight and noon),
     * 57600 (i.e. number of seconds between midnight and 4 PM),
     * 72000 (i.e. you get what I'm saying)
     * @return
     */
    public static int[] getTimesForNotification() {
        return new int[] {
            43200, 57600, 72000, 79200, 81000, 83400
        };
    }


    /**
     * Gets all the times at which a notification needs to be shown, and check if the current time
     * is within a window of 15 minutes from that time. Returns true if that is the case, false
     * otherwise.
     * @return true if current time is within a 15 minutes window of a time at which a notification
     * needs to be shown. False otherwise.
     */
    public static boolean shouldShowNotification() {
        Calendar c = Calendar.getInstance();
        long now = c.getTimeInMillis();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        long passed = now - c.getTimeInMillis();
        long secondsPassed = passed / 1000;

        for(int i:getTimesForNotification()) {
            if(secondsPassed - i > 0 && secondsPassed - i < 899) {
                return true;
            }
        }
        return false;
    }


}

