package edu.umich.dstudio.prompt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by neera_000 on 3/27/2016.
 * In addition to starting the prompt service after the user logs in, the service also needs to
 * be started each time the phone is rebooted. This class makes sure that regardless of what
 * state the phone is in, the prompt service keeps going.
 */
public class StartPromptServiceOnBootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, PromptService.class));
    }
}
