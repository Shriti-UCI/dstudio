package edu.umich.dstudio.model;

import java.util.Date;

/**
 * Created by neera_000 on 3/27/2016.
 */
public class LastLocation {
    float latitude;
    float longitude;
    String createdTime;

    public LastLocation(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdTime = new Date().toString();
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getCreatedTime() {
        return createdTime;
    }

}
