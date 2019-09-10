package peter.myappcompany.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    protected int intTarget;
    protected TextView txtInstructions;
    protected int intLowerBound = 1;
    protected int intUpperBound = 20;
    
    protected void resetTarget (){
        //Generate random number between 1 and 20
        intTarget = new Random().nextInt(20)+1;
        txtInstructions.setText("I am thinking of a number between 1 and 20");
        intLowerBound = 1;
        intUpperBound = 20;
    }

    private void updateInstructions () {
        txtInstructions.setText("I am thinking of a nubmer between " + intLowerBound + " and " + intUpperBound + ".");
    }
    
    public void userGuessed (View view){

        //Get user guess
        EditText txtUserGuess = (EditText) findViewById(R.id.txtUserGuess);
        Integer intUserGuess = Integer.parseInt(txtUserGuess.getText().toString());
        String strToastText;

        //Check user guess is valid
        if (!(intUserGuess >= intLowerBound && intUserGuess <= intUpperBound)) {
            strToastText = "Please enter a number between " + intLowerBound + " and " + intUpperBound + ".";
            Toast.makeText(this, strToastText, Toast.LENGTH_SHORT).show();
            return;
        }

        //Check if user's guess was:
        //  a. Lower than the correct number
        //  b. Higher than the correct number
        //  c. Equal
        if (intUserGuess < intTarget) {
            strToastText = "Higher!";
            intLowerBound = intUserGuess + 1;
            updateInstructions();
        } else if (intUserGuess > intTarget) {
            strToastText = "Lower!";
            intUpperBound = intUserGuess - 1;
            updateInstructions();
        } else {
            strToastText = "Correct! Lets play again!";
            resetTarget();
        }

        //Display Toast
        Toast.makeText(this, strToastText, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInstructions = (TextView) findViewById(R.id.lblInstructions);
        resetTarget();
    }
}
