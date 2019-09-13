package peter.myappcompany.timers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Below commented out method used if it is running into the future for an unknown duration. (e.g. stopwatch)
        //Handler
        final Handler handler = new Handler();

        //Runnable
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.i("runnable", "A second has passed");

                handler.postDelayed(this, 1000);
            }
        };

        handler.post(run);
        */


        //Below method used to countdown to a particular point in time (e.g. exam timer)
        new CountDownTimer(20000,1000){

            @Override
            public void onTick(long millisecondsUntilDone) {
                Log.i("SecondsLeft", String.valueOf(millisecondsUntilDone / 1000));
            }

            @Override
            public void onFinish() {
                Log.i("We're done!", "No more countdown");
            }
        }.start();
    }
}
