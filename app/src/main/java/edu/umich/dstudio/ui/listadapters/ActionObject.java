package edu.umich.dstudio.ui.listadapters;

/**
 * Created by neera_000 on 3/26/2016.
 */
public class ActionObject {
    String label;
    String secondaryLabel;
    int imageResourceId;

    public ActionObject(String label, String secondaryLabel, int imageResourceId) {
        this.label = label;
        this.secondaryLabel = secondaryLabel;
        this.imageResourceId = imageResourceId;
    }
}
