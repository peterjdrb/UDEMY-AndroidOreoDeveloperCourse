package peter.myappcompany.otheranimations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean bartIsShowing = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView bartImageView = findViewById(R.id.bartImageView);
        bartImageView.setX(-1000);
        bartImageView.animate().translationXBy(1000).rotation(360*10).setDuration(2000);
//        fade();
    }

    public void fade(View view) {
        Log.i("Info", "Image clicked");

        ImageView bartImageView = findViewById(R.id.bartImageView);

        bartImageView.animate().scaleY(0.5f).scaleX(0.5f).setDuration(1000);
    }
}
