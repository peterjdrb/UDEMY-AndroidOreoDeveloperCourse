package peter.myappcompany.audio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.vandoor);
    }

    public void playAudio (View view) {
        mediaPlayer.start();
    }

    public void pauseAudio (View view) {
        mediaPlayer.pause();
    }
}
