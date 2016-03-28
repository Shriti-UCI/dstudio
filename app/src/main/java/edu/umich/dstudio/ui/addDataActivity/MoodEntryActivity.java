package edu.umich.dstudio.ui.addDataActivity;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.maps.model.LatLng;

import java.text.DecimalFormat;

import edu.umich.dstudio.R;
import edu.umich.dstudio.model.Mood;
import edu.umich.dstudio.ui.BaseActivity;
import edu.umich.dstudio.ui.customview.MoodEntry;

/**
 * Created by neera_000 on 3/26/2016.
 */
public class MoodEntryActivity extends BaseActivity {

    private float DEVICE_DENSITY = 0;
    private int DEVICE_WIDTH = 0;

    private float tapX = 0, tapY = 0;
    private float tap_X = 0, tap_Y = 0;
    float firstMoodX = 0, firstMoodY = 0, secondMoodX = 0, secondMoodY = 0;
    float scale;

    Mood moodFirst = new Mood();
    Mood moodSecond = new Mood();

    MoodEntry cv;
    private Button btnTrends;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        scale = this.getResources().getDisplayMetrics().density;
        setContentView(R.layout.activity_mood_entry);

        // Add click listeners for buttons
        ImageView acceptButton = (ImageView) findViewById(R.id.acceptButton);
        ImageView rejectButton = (ImageView) findViewById(R.id.rejectButton);

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acceptResults();
            }
        });
        rejectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rejectResults();
            }
        });

        getDeviceWidth();
        initUi();
    }

    private void getDeviceWidth() {
        DEVICE_DENSITY = getResources().getDisplayMetrics().density;
        DEVICE_WIDTH = getResources().getDisplayMetrics().widthPixels;
        Log.v("HomeActivity", "**Device Density=" + DEVICE_DENSITY + " " + "DEVICE_WIDTH="
                + DEVICE_WIDTH);
    }

    private void initUi() {
        android.widget.LinearLayout.LayoutParams lp = new android.widget.LinearLayout.LayoutParams(
                DEVICE_WIDTH, DEVICE_WIDTH);
        cv = (MoodEntry) findViewById(R.id.graphCustomView);
        cv.setLayoutParams(lp);
        cv.setOnTouchListener(cvOncliClickListener);
    }

    View.OnTouchListener cvOncliClickListener = new View.OnTouchListener()
    {
        @Override
        public boolean onTouch(View v, MotionEvent event)
        {
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                // is first mood selected
                if (event.getX() - 25 * scale < moodFirst.X
                        && event.getX() + 25 * scale > moodFirst.X
                        && event.getY() - 25 * scale < moodFirst.Y
                        && event.getY() + 25 * scale > moodFirst.Y)
                {
                    Log.v("First Mood", "Selected");
                    moodFirst.isSelected = true;
                    moodSecond.isSelected = false;
                }

                // is second mood selected
                else if (event.getX() - (25 * scale) < moodSecond.X
                        && event.getX() + (25 * scale) > moodSecond.X
                        && event.getY() - (25 * scale) < moodSecond.Y
                        && event.getY() + (25 * scale) > moodSecond.Y)
                {
                    Log.v("Second Mood", "Selected");
                    moodFirst.isSelected = false;
                    moodSecond.isSelected = true;
                }
                // else no mood is selected
                else
                {
                    Log.v("No Mood", "Selected");
                    moodFirst.isSelected = false;
                    moodSecond.isSelected = false;
                }

                /** Choice first or second mood creating */
                if (!moodFirst.isCreated && moodSecond.isSelected == false)
                {
                    moodFirst.X = event.getX();
                    moodFirst.Y = event.getY();
                    moodFirst.isCreated = true;
                    moodFirst.isSelected = true;
                    setFirstMood(moodFirst);
                }

                //showOrHideArrowButton();
            }

            if (event.getAction() == MotionEvent.ACTION_UP)
            {

                float X, Y;
                X = event.getX();
                Y = event.getY();

                float viewWidth = cv.getWidth();
                float rectSize = viewWidth / 23;
                // float rectSize = viewWidth/23;
                Log.v("X* *,Y***", "==" + X + " , " + Y);

                if (X < ((viewWidth / 2) - 10 * scale) && (Y < (viewWidth / 2)))
                {
                    tapX = (float) ((Math.floor((viewWidth / 2) - X) / rectSize) * -1);// X
                    // should
                    // (-ve)
                    // in
                    // first
                    // quadrant
                    tapY = (float) (Math.floor((viewWidth / 2) - Y) / rectSize);
                    Log.v("Q", "1");
                }
                if ((X > (viewWidth / 2)) && (Y < (viewWidth / 2)))
                {
                    X = X - (viewWidth / 2);

                    /*
                     * tapX =(float)(Math.floor((X/rectSize))); tapY =
                     * (float)(Math.floor(((viewWidth/2)-Y)/rectSize)) ;
                     */
                    tapX = (X / rectSize);
                    tapY = ((viewWidth / 2) - Y) / rectSize;
                    Log.v("Q", "2");
                }
                if ((X > (viewWidth / 2)) && (Y > (viewWidth / 2)))
                {
                    X = X - (viewWidth / 2);
                    Y = Y - (viewWidth / 2);
                    /*
                     * tapX =(float)(Math.floor((X/rectSize))); tapY
                     * =(float)((Math.floor((Y/rectSize)))*-1);//Y should (-ve)
                     * in third quadrant
                     */
                    tapX = (X / rectSize);
                    tapY = (Y / rectSize) * (-1);// Y should (-ve) in third
                    // quadrant

                    Log.v("Q", "3");
                }
                if ((X < (viewWidth / 2)) && (Y > (viewWidth / 2)))
                {
                    /*
                     * tapX =(float)(Math.floor(((X-(viewWidth/2))/rectSize)));
                     * tapY =(float)(Math.floor(((viewWidth/2)-Y)/rectSize));
                     */
                    tapX = (X - (viewWidth / 2)) / rectSize;
                    tapY = ((viewWidth / 2) - Y) / rectSize;
                    Log.v("Q", "4");
                }

                if (tapX > 10.0)
                    tapX = (float) 10.0;
                else if (tapX < -10.0)
                    tapX = (float) -10.0;

                if (tapY > 10.0)
                    tapY = (float) 10.0;
                else if (tapY < -10.0)
                    tapY = (float) -10.0;

                Log.v("TAPX,TAPY", "" + tapX + " , " + tapY);

                DecimalFormat df = new DecimalFormat("#.#");
                String tapx = df.format(tapX);
                String tapy = df.format(tapY);
                tap_X = Float.parseFloat(tapx);
                tap_Y = Float.parseFloat(tapy);
                if (moodFirst.isSelected)
                {
                    moodFirst.X = event.getX();
                    moodFirst.Y = event.getY();
                    moodFirst.moodLevel = tap_X;
                    moodFirst.energyLevel = tap_Y;

                }
                if (moodSecond.isSelected)
                {
                    moodSecond.X = event.getX();
                    moodSecond.Y = event.getY();
                    moodSecond.moodLevel = tap_X;
                    moodSecond.energyLevel = tap_Y;
                }
                /** If mood drags */
                if (event.getX() < 10 * scale || event.getX() > cv.getWidth() - 10 * scale
                        || event.getY() < 10 * scale || event.getY() > cv.getWidth() - 10 * scale)
                {
                    if (moodFirst.isSelected)
                    {
                        moodFirst.X = -50 * scale;
                        moodFirst.Y = -50 * scale;
                        setFirstMood(moodFirst);
                    }


                    cv.invalidate();
                    Log.v("Action", "Out of Bond");
                }
                moodFirst.isSelected = false;
                moodSecond.isSelected = false;
                //showOrHideArrowButton();
            }

            if (event.getAction() == MotionEvent.ACTION_MOVE)
            {
                Log.v("Action", "Move");
                if (moodFirst.isSelected)
                {
                    Log.v("first Mood ", "Moving");
                    moodFirst.X = event.getX() - 10 * scale;
                    moodFirst.Y = event.getY() - 10 * scale;
                    setFirstMood(moodFirst);
                }
                else
                {
                    Log.v("NoMood", "X=" + event.getX() + " Y=" + event.getY());
                }

                /** Delete the mood entry */
                if (event.getX() < 20 * scale || event.getX() > cv.getWidth() - 20 * scale
                        || event.getY() < 20 * scale || event.getY() > cv.getWidth() - 20 * scale)
                {
                    if (moodFirst.isSelected)
                    {
                        moodFirst.X = -20 * scale;
                        moodFirst.Y = -20 * scale;
                        moodFirst.isCreated = false;
                        setFirstMood(moodFirst);
                    }

                    cv.invalidate();
                    Log.v("Action", "Out of Bond");
                }
            }

            Log.v("TAPX formated ,TAPY", "" + tap_X + " , " + tap_Y);
            return true;
        }
    };

    /**
     * Called each time the user touches anywhere on the mood map.
     * @param mood
     */
    void setFirstMood(Mood mood) {
        cv.setFirstMood(mood.X, mood.Y);
    }


    /**
     * This is called when the user pressed "Tick" button on the screen.
     */
    public void acceptResults() {

        // Confirm that a mood was indeed selected.
        if(!moodFirst.isCreated) {
            showToast("Please select a mood on the map above first.");
            return;
        }

        LatLng l = getCurrentLocation();
        moodFirst.latitude = (float) l.latitude;
        moodFirst.longitude = (float) l.longitude;


        mFirebaseWrapper.uploadMood(moodFirst);
        showToast("Your mood has been recorded");

        finish();
    }


    /**
     * This is called when the user presses the "X" button the screen.
     */
    public void rejectResults() {
        showToast("Going back to home screen");
        finish();
    }
}
