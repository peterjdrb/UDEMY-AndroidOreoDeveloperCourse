package peter.myappcompany.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SeekBar multiplyBar;
    ListView timeTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeTable = findViewById(R.id.timesTable);

        multiplyBar = findViewById(R.id.multiplyBar);
        multiplyBar.setMin(1);
        multiplyBar.setMax(20);
        multiplyBar.setProgress(10);

        populateTimeTable();

        multiplyBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                populateTimeTable();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    protected void populateTimeTable() {
        final ArrayList<String> timesTable = new ArrayList<String>();
        int intTimesTable = multiplyBar.getProgress();
        int lowerRange = 1;
        int uppeRange = 100;

        timeTable.setAdapter(null);
        for (int i = lowerRange; i<=uppeRange; i++) {
            timesTable.add(Integer.toString(i*intTimesTable));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTable);
        timeTable.setAdapter(arrayAdapter);
    }
}
