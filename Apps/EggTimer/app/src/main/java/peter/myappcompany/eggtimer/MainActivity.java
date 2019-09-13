package peter.myappcompany.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import static java.lang.Math.floor;

public class MainActivity extends AppCompatActivity {

    SeekBar timerBar;
    TextView timerText;
    MediaPlayer sound;
    CountDownTimer timer;

    final int defaultTimeInSeconds = 30; //in seconds
    final int secondsPerMin = 60;
    final int maxMinutes = 60;
    final int minSeconds = 0;
    final int maxSeconds = secondsPerMin * maxMinutes;

    int currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialSetup();
    }

    private void initialSetup() {
        //SetSeekBar with its min, max and progress.
        timerBar = findViewById(R.id.timerBar);
        timerBar.setMin(minSeconds);
        timerBar.setMax(maxSeconds);
        timerBar.setProgress(defaultTimeInSeconds);
        currentTime = timerBar.getProgress();

        timerBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                currentTime = i;
                setTimerText();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Set timerText;
        timerText = findViewById(R.id.txtTimer);
        setTimerText();

        //Set up sound ready to be played once the time is up
        sound = MediaPlayer.create(MainActivity.this, R.raw.alarm);
    }

    private void setTimerText() {
        int minutes = (currentTime / secondsPerMin);
        int seconds = currentTime - (secondsPerMin*minutes);

        String strSeconds = Integer.toString(seconds);
        if (strSeconds.length() == 1) {
            strSeconds = "0" + seconds;
        }

        timerText.setText(Integer.toString(minutes) + ":" + strSeconds);
    }

    public void btnGoPressed (View view){
        Button btn = findViewById(R.id.btnGo);
        int tag = Integer.parseInt(btn.getTag().toString());

        if (tag == 1) {
            timerBar.setEnabled(false);
            btn.setTag(2);
            btn.setText("Stop");

            timer = new CountDownTimer(currentTime*1000,1000){

                @Override
                public void onTick(long millisecondsUntilDone) {
                    currentTime = currentTime - 1;
                    setTimerText();
                }

                @Override
                public void onFinish() {
                    sound.start();
                }
            }.start();

        } else {
            timerBar.setEnabled(true);
            btn.setTag(1);
            btn.setText("Go!");
            timer.cancel();
            timerBar.setProgress(currentTime);

            if (sound.isPlaying()) {
                sound.stop();
            }
        }
    }
}