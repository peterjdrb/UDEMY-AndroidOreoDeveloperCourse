package peter.myappcompany.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    CountDownTimer timer;

    //List of buttons
    Button btnGo;
    Button btnPlayAgain;
    Button btnAnswer1;
    Button btnAnswer2;
    Button btnAnswer3;
    Button btnAnswer4;

    //List of Text Views
    TextView txtTime;
    TextView txtEquation;
    TextView txtScore;
    TextView txtCheck;

    //Answer grid
    androidx.gridlayout.widget.GridLayout answerGrid;

    //List of constants
    int intTotalTimeAllowed;

    //List of needed data
    int intTimeRemaining;
    int intFirstNumber;
    int intSecondNumber;
    int intCorrectAnswer;
    int intPossibleAnswer;
    int[] intPossibleAnswers;
    int intCorrectAnswerIndex;
    int intQuestionsAnswered;
    int intQuestionsAnsweredCorrectly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialVariableSetup();
    }

    private void initialVariableSetup() {
        btnGo = findViewById(R.id.btnGo);
        btnPlayAgain = findViewById(R.id.btnPlayAgain);
        btnAnswer1 = findViewById(R.id.btnAnswer0);
        btnAnswer2 = findViewById(R.id.btnAnswer1);
        btnAnswer3 = findViewById(R.id.btnAnswer2);
        btnAnswer4 = findViewById(R.id.btnAnswer3);

        txtTime = findViewById(R.id.txtTime);
        txtEquation = findViewById(R.id.txtEquation);
        txtScore = findViewById(R.id.txtScore);
        txtCheck = findViewById(R.id.txtCheck);

        answerGrid = (androidx.gridlayout.widget.GridLayout) findViewById(R.id.answerGrid);
        resetVales();
    }

    private void resetVales() {
        intTotalTimeAllowed = 30;
        intTimeRemaining = intTotalTimeAllowed;
        intFirstNumber = 0;
        intSecondNumber = 0;
        intCorrectAnswer = 0;
        intPossibleAnswers = new int[]{0, 0, 0, 0};
        intQuestionsAnswered = 0;
        intQuestionsAnsweredCorrectly = 0;
    }

    private void setupNextQuestion (){
        //Get a new equation and possible answers
        generateSum();
        intCorrectAnswerIndex = generateRandomNumber(0,3);
        setupAnswerArray();

        //Set all appropriate text
        setupButtonText();
        setTimerText();
        setScoreText();
        setEquationText();

        for (int i : intPossibleAnswers) {
            Log.i("Answer ", Integer.toString(i));
        }

        Log.i("Correct Answer",Integer.toString(intCorrectAnswer));
    }

    public void startGame (View view){
        displayBoard();
        setupNextQuestion();
        startTimer();

    }

    private void setEquationText() {
        txtEquation.setText(Integer.toString(intFirstNumber) + " + " + Integer.toString(intSecondNumber));
    }

    private void setScoreText() {
        txtScore.setText(Integer.toString(intQuestionsAnsweredCorrectly) + "/" + Integer.toString(intQuestionsAnswered));
    }

    private void setTimerText() {
        txtTime.setText(Integer.toString(intTimeRemaining) + "s");
    }

    private void startTimer() {
        intTimeRemaining = intTotalTimeAllowed;
        timer = new CountDownTimer(intTotalTimeAllowed*1000,1000){

            @Override
            public void onTick(long millisecondsUntilDone) {
                intTimeRemaining = intTimeRemaining - 1;
                setTimerText();
            }

            @Override
            public void onFinish() {
                disableButtons();
                txtCheck.setText("Game Over! Play Again?");
                btnPlayAgain.setVisibility(View.VISIBLE);
            }

            private void disableButtons() {
                btnAnswer1.setEnabled(false);
                btnAnswer2.setEnabled(false);
                btnAnswer3.setEnabled(false);
                btnAnswer4.setEnabled(false);
            }
        }.start();
    }

    private void setupButtonText() {
        btnAnswer1.setText(Integer.toString(intPossibleAnswers[0]));
        btnAnswer2.setText(Integer.toString(intPossibleAnswers[1]));
        btnAnswer3.setText(Integer.toString(intPossibleAnswers[2]));
        btnAnswer4.setText(Integer.toString(intPossibleAnswers[3]));
    }

    private void setupAnswerArray() {
        for (int i=0; i<intPossibleAnswers.length; i++) {
            if (i == intCorrectAnswerIndex) {
                intPossibleAnswers[i] = intCorrectAnswer;
            } else {
                intPossibleAnswer = intCorrectAnswer;
                boolean boolNumberExists = false;
                while (intPossibleAnswer == intCorrectAnswer || boolNumberExists == true){
                    intPossibleAnswer = generateRandomNumber(intCorrectAnswer-10,intCorrectAnswer+10);
                    boolNumberExists = false;

                    for (int n : intPossibleAnswers) {
                        if (n == intPossibleAnswer) {
                            boolNumberExists = true;
                            break;
                        }
                    }
                }
                intPossibleAnswers[i] = intPossibleAnswer;
            }
        }
    }

    private void generateSum() {
        intFirstNumber = generateRandomNumber(1,30);
        intSecondNumber = generateRandomNumber(1,30);
        intCorrectAnswer = intFirstNumber + intSecondNumber;
    }

    private int generateRandomNumber(int min, int max) {
        return new Random().nextInt(max + 1 - min) + min;
    }

    private void displayBoard() {
        btnGo.setVisibility(View.INVISIBLE);
        answerGrid.setVisibility(View.VISIBLE);
        txtTime.setVisibility(View.VISIBLE);
        txtEquation.setVisibility(View.VISIBLE);
        txtScore.setVisibility(View.VISIBLE);
    }

    public void answerChosen (View view) {
        Button answerButton = (Button) view;
        checkAnswer(answerButton.getText().toString());
    }

    private void checkAnswer(String answerChosen) {
        intQuestionsAnswered = intQuestionsAnswered + 1;
        txtCheck.setVisibility(View.VISIBLE);
        Log.i("Answer Chosen", answerChosen);
        Log.i("Correct Answer", Integer.toString(intQuestionsAnsweredCorrectly));
        if (Integer.parseInt(answerChosen) == intCorrectAnswer) {
            intQuestionsAnsweredCorrectly = intQuestionsAnsweredCorrectly + 1;
            txtCheck.setText("Correct!");
        } else {
            txtCheck.setText("Try again");
        }

        setupNextQuestion();
    }

    public void newGame (View view) {
        btnPlayAgain.setVisibility(View.INVISIBLE);
        resetVales();
        setupNextQuestion();
        enableButtons();
        startTimer();
    }

    private void enableButtons() {
        btnAnswer1.setEnabled(true);
        btnAnswer2.setEnabled(true);
        btnAnswer3.setEnabled(true);
        btnAnswer4.setEnabled(true);
    }
}
