package com.example.findly;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    // Haversine returns distance in KM
    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371.0; // Earth radius km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon/2) * Math.sin(dLon/2);
        return R * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    }

    // check if current time between open and close. format "HH:mm"
    public static boolean isOpenNow(String open, String close) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date now = sdf.parse(sdf.format(new Date()));
            Date o = sdf.parse(open);
            Date c = sdf.parse(close);
            if (o.before(c)) {
                return now.after(o) && now.before(c);
            } else {
                // overnight (e.g., open 22:00 close 05:00)
                return now.after(o) || now.before(c);
            }
        } catch (Exception e) {
            return true; // fail-open
        }
    }
}
