package edu.umich.dstudio.model;

/**
 * Created by neera_000 on 3/26/2016.
 */
public class Note {
    public String note;
    public float latitude;
    public float longitude;

    public Note() {

    }

    public Note(String note, float latitude, float longitude) {
        this.note = note;
        this.latitude = latitude;
        this.longitude = longitude;
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
}
