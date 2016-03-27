package edu.umich.dstudio.model;

/**
 * Created by neera_000 on 3/26/2016.
 */
public class Mood {
    /** X axis to draw */
    public float X = -50f;
    /** Y axis to draw */
    public float Y = -50f;
    /** Checking flag while drag the mood */
    public boolean isSelected = false;
    /** Checking flag while Inserting and Posting the mood */
    public boolean isCreated = false;
    /** X Possition on 10/10 graph */
    public float moodLevel = -50;
    /** Y Possition on 10/10 graph */
    public float energyLevel = -50;

    public float latitude;
    public float longitude;

    public float getX() {
        return X;
    }

    public float getY() {
        return Y;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public boolean isCreated() {
        return isCreated;
    }

    public float getMoodLevel() {
        return moodLevel;
    }

    public float getEnergyLevel() {
        return energyLevel;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public Mood() {

    }

    public Mood(float x, float y, boolean isSelected, boolean isCreated, float moodLevel, float energyLevel, float latitude, float longitude) {

        X = x;
        Y = y;
        this.isSelected = isSelected;
        this.isCreated = isCreated;
        this.moodLevel = moodLevel;
        this.energyLevel = energyLevel;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
