package edu.umich.dstudio;

import com.firebase.client.Firebase;

import edu.umich.dstudio.utils.GSharedPreferences;

/**
 * Created by neera_000 on 3/26/2016.
 */
public class DStudioApplication extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        GSharedPreferences.getInstance().Initialize(getApplicationContext());
    }
}
