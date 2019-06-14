package peter.myappcompany.a15displaymessages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private counter varCount = new counter();

    public void displayToast (View view){

        EditText enteredName = (EditText) findViewById(R.id.txtName);
        String stringToDisplay = "Hi there " + enteredName.getText().toString() + ". You have clicked me ";

        if (varCount.getCounter() > 1){
            stringToDisplay = stringToDisplay + Integer.toString(varCount.getCounter()) + " times.";
        } else {
            stringToDisplay = stringToDisplay + "once.";
        }

        Toast.makeText(this, stringToDisplay, Toast.LENGTH_SHORT).show();
        varCount.setCounter(varCount.getCounter() + 1);
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        varCount.setCounter(0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
