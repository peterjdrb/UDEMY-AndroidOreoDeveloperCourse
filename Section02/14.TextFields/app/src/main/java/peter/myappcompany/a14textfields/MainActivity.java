package peter.myappcompany.a14textfields;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void Login (View view){
        EditText enteredUsername = (EditText) findViewById(R.id.txtUsername);
        EditText enteredPassword = (EditText) findViewById(R.id.txtPassword);

        Log.i("Username", enteredUsername.getText().toString());
        Log.i("Password", enteredPassword.getText().toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}