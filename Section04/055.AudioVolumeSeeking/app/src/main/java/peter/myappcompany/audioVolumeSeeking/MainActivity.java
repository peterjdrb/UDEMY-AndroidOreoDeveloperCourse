package peter.myappcompany.audioVolumeSeeking;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.vandoor);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar volumeControl = (SeekBar) findViewById(R.id.volumeController);
        volumeControl.setMax(maxVolume);
        volumeControl.setProgress(currentVolume);

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final SeekBar scrubSeekBar = (SeekBar) findViewById(R.id.scrubSeekBar);
        scrubSeekBar.setMax( mediaPlayer.getDuration());
        scrubSeekBar.setProgress(currentVolume);

        scrubSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                Log.i("SeekBar2 Changed", Integer.toString(i));
                mediaPlayer.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrubSeekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,300);
    }

    public void playAudio (View view) {
        mediaPlayer.start();
    }

    public void pauseAudio (View view) {
        mediaPlayer.pause();
    }
}
