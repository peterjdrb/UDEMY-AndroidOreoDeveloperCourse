package peter.myappcompany.basicphrases;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playTranslation (View view) {
        Button b = (Button) view;
        String fileName = b.getTag().toString();
        mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(fileName, "raw", getPackageName()));
        mediaPlayer.start();
    }
}