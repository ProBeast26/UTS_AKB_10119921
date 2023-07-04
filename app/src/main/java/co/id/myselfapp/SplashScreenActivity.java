package co.id.myselfapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;



public class SplashScreenActivity extends AppCompatActivity {
    private Handler mWaitHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        boolean music = sharedPref.getBoolean("isFirstOpen", true);
        mWaitHandler.postDelayed(new Runnable() {

            @Override
            public void run() {

                //The following code will execute after the 5 seconds.

                try {
                    Intent intent = new Intent(getApplicationContext(), OnBoardingActivity.class);
                    startActivity(intent);
//                    if(music){
//                        SharedPreferences.Editor editor = sharedPref.edit();
//                        editor.putBoolean("isFirstOpen", false);
//                        editor.apply();
//                        Intent intent = new Intent(getApplicationContext(), OnBoardingActivity.class);
//                        startActivity(intent);
//                    }else{
//                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                        startActivity(intent);
//                    }
                    //Go to next page i.e, start the next activity.


                    //Let's Finish Splash Activity since we don't want to show this when user press back button.
                    finish();
                } catch (Exception ignored) {
                    ignored.printStackTrace();
                }
            }
        }, 3000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //Remove all the callbacks otherwise navigation will execute even after activity is killed or closed.
        mWaitHandler.removeCallbacksAndMessages(null);
    }
}