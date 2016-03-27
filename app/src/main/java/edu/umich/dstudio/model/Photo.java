package edu.umich.dstudio.model;

/**
 * Created by neera_000 on 3/26/2016.
 */
public class Photo {
    public float latitude;
    public float longitude;
    public String base64Data;
    public String annotation;

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getBase64Data() {
        return base64Data;
    }

    public String getAnnotation() {
        return annotation;
    }

    public Photo(float latitude, float longitude, String base64Data, String annotation) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.base64Data = base64Data;
        this.annotation = annotation;
    }
}
