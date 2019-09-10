package peter.myappcompany.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertAmount (View view){
        //1.Get amount Entered
        EditText AmountTextbox = (EditText) findViewById(R.id.txtAmount);
        String strAmountEntered = AmountTextbox.getText().toString();

        //2.Calculate conversion
        Double dblConvertedAmount = Double.parseDouble(strAmountEntered) * 1.3;
        String strConvertedAmount = String.format("%.2f", dblConvertedAmount);

        //3. Display conversion in toast
        String strToast = "£" + strAmountEntered + " in US dollars is $" + strConvertedAmount;
        Toast.makeText(this, strToast, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
