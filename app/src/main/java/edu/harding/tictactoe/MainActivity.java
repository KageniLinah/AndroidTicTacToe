package edu.harding.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TicTacToeGame mGame;
    private Button[] mBoardButtons;
    private TextView mInfoTextView;
    private TextView mWinsTextView, mTiesTextView, mComputerWinsTextView;
    private boolean mGameOver;


    private int mHumanWins = 0;
    private int mComputerWins = 0;
    private int mTies = 0;
    private boolean mIsHumanTurn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGame = new TicTacToeGame();

        mBoardButtons = new Button[9];
        mBoardButtons[0] = findViewById(R.id.one);
        mBoardButtons[1] = findViewById(R.id.two);
        mBoardButtons[2] = findViewById(R.id.three);
        mBoardButtons[3] = findViewById(R.id.four);
        mBoardButtons[4] = findViewById(R.id.five);
        mBoardButtons[5] = findViewById(R.id.six);
        mBoardButtons[6] = findViewById(R.id.seven);
        mBoardButtons[7] = findViewById(R.id.eight);
        mBoardButtons[8] = findViewById(R.id.nine);

        mInfoTextView = findViewById(R.id.information);
        mWinsTextView = findViewById(R.id.wins_count);
        mTiesTextView = findViewById(R.id.ties_count);
        mComputerWinsTextView = findViewById(R.id.computer_wins_count);

        mGameOver = false;

        startNewGame();
    }

    private void startNewGame() {
        mGame.clearBoard();


        for (int i = 0; i < mBoardButtons.length; i++) {
            mBoardButtons[i].setText("");
            mBoardButtons[i].setEnabled(true);
            mBoardButtons[i].setOnClickListener(new ButtonClickListener(i));
        }

        mGameOver = false;
        mInfoTextView.setText(getString(R.string.you_go_first));


        mWinsTextView.setText("Wins: " + mHumanWins);
        mTiesTextView.setText("Ties: " + mTies);
        mComputerWinsTextView.setText("Computer Wins: " + mComputerWins);
    }

    private void setMove(char player, int location) {
        mGame.setMove(player, location);
        mBoardButtons[location].setEnabled(false);
        mBoardButtons[location].setText(String.valueOf(player));

        if (player == TicTacToeGame.HUMAN_PLAYER) {
            mBoardButtons[location].setTextColor(Color.GREEN);
        } else {
            mBoardButtons[location].setTextColor(Color.RED);
        }
    }

    private class ButtonClickListener implements View.OnClickListener {
        private int location;

        public ButtonClickListener(int location) {
            this.location = location;
        }

        @Override
        public void onClick(View view) {
            if (!mGameOver && mBoardButtons[location].isEnabled()) {

                if (mIsHumanTurn) {
                    setMove(TicTacToeGame.HUMAN_PLAYER, location);
                    mIsHumanTurn = false;

                    int winner = mGame.checkForWinner();
                    if (winner == 0) {
                        mInfoTextView.setText(getString(R.string.computer_turn));
                        int move = mGame.getComputerMove();
                        setMove(TicTacToeGame.COMPUTER_PLAYER, move);
                        winner = mGame.checkForWinner();
                    }


                    if (winner == 1) {
                        mInfoTextView.setText(getString(R.string.draw_game));
                        mTies++;
                        mGameOver = true;
                    } else if (winner == 2) {
                        mInfoTextView.setText(getString(R.string.you_win));
                        mHumanWins++;
                        mGameOver = true;
                    } else if (winner == 3) {
                        mInfoTextView.setText(getString(R.string.computer_wins));
                        mComputerWins++;
                        mGameOver = true;
                    }

                    mWinsTextView.setText("Wins: " + mHumanWins);
                    mTiesTextView.setText("Ties: " + mTies);
                    mComputerWinsTextView.setText("Computer Wins: " + mComputerWins);
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_new_game) {
            startNewGame();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
