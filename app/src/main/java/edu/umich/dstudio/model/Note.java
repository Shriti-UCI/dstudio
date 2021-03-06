package edu.umich.dstudio.model;

import java.util.Date;

/**
 * Created by neera_000 on 3/26/2016.
 */
public class Note {
    public String note;
    public float latitude;
    public float longitude;
    String createdTime;

    public Note() {

    }

    public Note(String note, float latitude, float longitude) {
        this.note = note;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdTime = new Date().toString();
    }

    public String getNote() {
        return note;
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
