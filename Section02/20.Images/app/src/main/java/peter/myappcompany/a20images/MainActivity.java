package peter.myappcompany.a20images;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changePicture (View view){
        ImageView pictureShowing = (ImageView) findViewById(R.id.viewPicture);
        pictureShowing.setImageResource(R.drawable.picture2);
    }
}
