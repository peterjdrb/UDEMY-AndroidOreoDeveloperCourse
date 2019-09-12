package peter.myappcompany.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;;

public class MainActivity extends AppCompatActivity {

    //0 = red, 1 = yellow
    int currentPlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};

    //Possible winning combinations (referring to tag values)
    int [][] winningCombinations = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test (View view) {
        //Make buttons and text invisible
        TextView txtWinner = (TextView) findViewById(R.id.txtWinner);
        Button playAgainButton = (Button) findViewById(R.id.btnPlayAgain);

        txtWinner.setVisibility(View.INVISIBLE);
        playAgainButton.setVisibility(View.INVISIBLE);

        //Reset all ImagesView
        androidx.gridlayout.widget.GridLayout board = (androidx.gridlayout.widget.GridLayout) findViewById(R.id.grdBoard);

        for (int i=0; i<board.getChildCount(); i++) {
            ImageView counter = (ImageView) board.getChildAt(i);
            counter.setImageDrawable(null);
        }

        currentPlayer = 0;

        for (int i=0; i<gameState.length; i++) {
            gameState[i] = 2;
        }
    }

    public void counterDroppedIn (View view) {
        ImageView counter = (ImageView) view;
        int winner = checkForResult();
        if (gameState[Integer.parseInt(counter.getTag().toString())] == 2 && checkForResult() == -1) {
            animateCounter(counter);
            updateGameState(counter);
            winner = checkForResult();
            if (winner > -1) {
                displayWinner(winner);
                displayContent();
            }
        }
    }

    private void displayContent() {
        TextView txtWinner = (TextView) findViewById(R.id.txtWinner);
        Button playAgainButton = (Button) findViewById(R.id.btnPlayAgain);

        txtWinner.setVisibility(View.VISIBLE);
        playAgainButton.setVisibility(View.VISIBLE);
    }

    private int checkForResult() {
        /* Winner is classified as follows:
            -1 = game in progress (atleast one state is still at 2)
            0 = red won
            1 = yellow won
            2 = draw
         */
        int winner = 2;
        for (int[] winningCombination : winningCombinations) {
            int counterA = gameState[winningCombination[0]];
            int counterB = gameState[winningCombination[1]];
            int counterC = gameState[winningCombination[2]];
            //If all of the current values are the same and they don't equal 2 then someone has won
            if (counterA == counterB && counterB == counterC && counterA != 2) {
                return counterA;
            }
        }

        for (int i : gameState) {
            if (i == 2) {
                winner = -1;
            }
        }
        return winner;

    }
    
    private void displayWinner (int winner) {
        //The winner is the opposite to the active player
        TextView txtWinner = (TextView) findViewById(R.id.txtWinner);

        if (winner == 0) {
            txtWinner.setText("Yellow has won!");
        } else if (winner == 1) {
            txtWinner.setText("Red has won!");
        } else {
            txtWinner.setText("It's a draw. One more game?");
        }
    }
    
    private void updateGameState(ImageView counter) {
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        gameState[tappedCounter] = currentPlayer;
    }

    public void animateCounter (ImageView counter) {

        counter.setTranslationY(-1000);

        if (currentPlayer == 0) {
            counter.setImageResource(R.drawable.red);
            currentPlayer = 1;
        } else {
            counter.setImageResource(R.drawable.yellow);
            currentPlayer = 0;
        }
        counter.animate().translationYBy(1000).setDuration(300);
    }
}
