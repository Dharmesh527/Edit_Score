package com.score.editscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public DatabaseReference reff;
    Timer timer;
    private EditText mEditTextInput;
    private TextView mTextViewCountDown;
    private Button mButtonSet;
    private Button mButtonStartPause;
    private Button mButtonReset;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mStartTimeInMillis;
    private long mTimeLeftInMillis;
    private long mEndTime;
    public void onClickTeam1(View v) {
        Intent intent = new Intent(this, Team1.class);
        startActivity(intent);
    }
    public void onClickTeam2(View v) {
        Intent intent = new Intent(this, Team2.class);
        startActivity(intent);
    }

//    public void onClickView(View view){

//        String tag=view.getTag().toString();
//        String jno="",name="",score="";
//        String redcnt="",yellowcnt="",twocnt="";
//        String redswth="NO",yellowswth="NO",twoswitch="NO";
//        switch (tag){
//            case "1a":
//                jno=((EditText)findViewById(R.id.jessyNo1a)).getText().toString();
//                name=((EditText)findViewById(R.id.playerName1a)).getText().toString();
//                score=((EditText)findViewById(R.id.playerScore1a)).getText().toString();
//                redcnt=((EditText)findViewById(R.id.redCount1a)).getText().toString();
//                yellowcnt=((EditText)findViewById(R.id.yellowCount1a)).getText().toString();
//                twocnt=((EditText)findViewById(R.id.twoCount1a)).getText().toString();
//                redswth = ((ToggleButton) findViewById(R.id.redSwitch1a)).getText().toString();
//                yellowswth = ((ToggleButton) findViewById(R.id.yellowSwitch1a)).getText().toString();
//                twoswitch = ((ToggleButton) findViewById(R.id.twoSwitch1a)).getText().toString();
//                break;
//            case "2a":
//                jno=((EditText)findViewById(R.id.jessyNo2a)).getText().toString();
//                name=((EditText)findViewById(R.id.playerName2a)).getText().toString();
//                score=((EditText)findViewById(R.id.playerScore2a)).getText().toString();
//                redcnt=((EditText)findViewById(R.id.redCount2a)).getText().toString();
//                yellowcnt=((EditText)findViewById(R.id.yellowCount2a)).getText().toString();
//                twocnt=((EditText)findViewById(R.id.twoCount2a)).getText().toString();
//                redswth = ((ToggleButton) findViewById(R.id.redSwitch2a)).getText().toString();
//                yellowswth = ((ToggleButton) findViewById(R.id.yellowSwitch2a)).getText().toString();
//                twoswitch = ((ToggleButton) findViewById(R.id.twoSwitch2a)).getText().toString();
//                break;
//            case "3a":
//                jno=((EditText)findViewById(R.id.jessyNo3a)).getText().toString();
//                name=((EditText)findViewById(R.id.playerName3a)).getText().toString();
//                score=((EditText)findViewById(R.id.playerScore3a)).getText().toString();
//                redcnt=((EditText)findViewById(R.id.redCount3a)).getText().toString();
//                yellowcnt=((EditText)findViewById(R.id.yellowCount3a)).getText().toString();
//                twocnt=((EditText)findViewById(R.id.twoCount3a)).getText().toString();
//                redswth = ((ToggleButton) findViewById(R.id.redSwitch3a)).getText().toString();
//                yellowswth = ((ToggleButton) findViewById(R.id.yellowSwitch3a)).getText().toString();
//                twoswitch = ((ToggleButton) findViewById(R.id.twoSwitch3a)).getText().toString();
//                break;
//            case "4a":
//                jno=((EditText)findViewById(R.id.jessyNo4a)).getText().toString();
//                name=((EditText)findViewById(R.id.playerName4a)).getText().toString();
//                score=((EditText)findViewById(R.id.playerScore4a)).getText().toString();
//                redcnt=((EditText)findViewById(R.id.redCount4a)).getText().toString();
//                yellowswth=((EditText)findViewById(R.id.yellowCount4a)).getText().toString();
//                twocnt=((EditText)findViewById(R.id.twoCount4a)).getText().toString();
//                redswth = ((ToggleButton) findViewById(R.id.redSwitch4a)).getText().toString();
//                yellowcnt = ((ToggleButton) findViewById(R.id.yellowSwitch4a)).getText().toString();
//                twoswitch = ((ToggleButton) findViewById(R.id.twoSwitch4a)).getText().toString();
//                break;
//            case "5a":
//                jno=((EditText)findViewById(R.id.jessyNo5a)).getText().toString();
//                name=((EditText)findViewById(R.id.playerName5a)).getText().toString();
//                score=((EditText)findViewById(R.id.playerScore5a)).getText().toString();
//                redcnt=((EditText)findViewById(R.id.redCount5a)).getText().toString();
//                yellowcnt=((EditText)findViewById(R.id.yellowCount5a)).getText().toString();
//                twocnt=((EditText)findViewById(R.id.twoCount5a)).getText().toString();
//                redswth = ((ToggleButton) findViewById(R.id.redSwitch5a)).getText().toString();
//                yellowcnt = ((ToggleButton) findViewById(R.id.yellowSwitch5a)).getText().toString();
//                twoswitch = ((ToggleButton) findViewById(R.id.twoSwitch5a)).getText().toString();
//                break;
//            case "6a":
//                jno=((EditText)findViewById(R.id.jessyNo6a)).getText().toString();
//                name=((EditText)findViewById(R.id.playerName6a)).getText().toString();
//                score=((EditText)findViewById(R.id.playerScore6a)).getText().toString();
//                redcnt=((EditText)findViewById(R.id.redCount6a)).getText().toString();
//                yellowcnt=((EditText)findViewById(R.id.yellowCount6a)).getText().toString();
//                twocnt=((EditText)findViewById(R.id.twoCount6a)).getText().toString();
//                redswth = ((ToggleButton) findViewById(R.id.redSwitch6a)).getText().toString();
//                yellowcnt = ((ToggleButton) findViewById(R.id.yellowSwitch6a)).getText().toString();
//                twoswitch = ((ToggleButton) findViewById(R.id.twoSwitch6a)).getText().toString();
//                break;
//            case "7a":
//                jno=((EditText)findViewById(R.id.jessyNo7a)).getText().toString();
//                name=((EditText)findViewById(R.id.playerName7a)).getText().toString();
//                score=((EditText)findViewById(R.id.playerScore7a)).getText().toString();
//                redcnt=((EditText)findViewById(R.id.redCount7a)).getText().toString();
//                yellowcnt=((EditText)findViewById(R.id.yellowCount7a)).getText().toString();
//                twocnt=((EditText)findViewById(R.id.twoCount7a)).getText().toString();
//                redswth = ((ToggleButton) findViewById(R.id.redSwitch7a)).getText().toString();
//                yellowcnt = ((ToggleButton) findViewById(R.id.yellowSwitch7a)).getText().toString();
//                twoswitch = ((ToggleButton) findViewById(R.id.twoSwitch7a)).getText().toString();
//                break;
//            case "8a":
//                jno=((EditText)findViewById(R.id.jessyNo8a)).getText().toString();
//                name=((EditText)findViewById(R.id.playerName8a)).getText().toString();
//                score=((EditText)findViewById(R.id.playerScore8a)).getText().toString();
//                redcnt=((EditText)findViewById(R.id.redCount8a)).getText().toString();
//                yellowcnt=((EditText)findViewById(R.id.yellowCount8a)).getText().toString();
//                twocnt=((EditText)findViewById(R.id.twoCount8a)).getText().toString();
//                redswth = ((ToggleButton) findViewById(R.id.redSwitch8a)).getText().toString();
//                yellowcnt = ((ToggleButton) findViewById(R.id.yellowSwitch8a)).getText().toString();
//                twoswitch = ((ToggleButton) findViewById(R.id.twoSwitch8a)).getText().toString();
//                break;
//            case "9a":
//                jno=((EditText)findViewById(R.id.jessyNo9a)).getText().toString();
//                name=((EditText)findViewById(R.id.playerName9a)).getText().toString();
//                score=((EditText)findViewById(R.id.playerScore9a)).getText().toString();
//                redcnt=((EditText)findViewById(R.id.redCount9a)).getText().toString();
//                yellowcnt=((EditText)findViewById(R.id.yellowCount9a)).getText().toString();
//                twocnt=((EditText)findViewById(R.id.twoCount9a)).getText().toString();
//                redswth = ((ToggleButton) findViewById(R.id.redSwitch9a)).getText().toString();
//                yellowcnt = ((ToggleButton) findViewById(R.id.yellowSwitch9a)).getText().toString();
//                twoswitch = ((ToggleButton) findViewById(R.id.twoSwitch9a)).getText().toString();
//                break;
//            case "10a":
//                jno=((EditText)findViewById(R.id.jessyNo10a)).getText().toString();
//                name=((EditText)findViewById(R.id.playerName10a)).getText().toString();
//                score=((EditText)findViewById(R.id.playerScore10a)).getText().toString();
//                redcnt=((EditText)findViewById(R.id.redCount10a)).getText().toString();
//                yellowcnt=((EditText)findViewById(R.id.yellowCount10a)).getText().toString();
//                twocnt=((EditText)findViewById(R.id.twoCount10a)).getText().toString();
//                redswth = ((ToggleButton) findViewById(R.id.redSwitch10a)).getText().toString();
//                yellowcnt = ((ToggleButton) findViewById(R.id.yellowSwitch10a)).getText().toString();
//                twoswitch = ((ToggleButton) findViewById(R.id.twoSwitch10a)).getText().toString();
//                break;
//            case "11a":
//                jno=((EditText)findViewById(R.id.jessyNo11a)).getText().toString();
//                name=((EditText)findViewById(R.id.playerName11a)).getText().toString();
//                score=((EditText)findViewById(R.id.playerScore11a)).getText().toString();
//                redcnt=((EditText)findViewById(R.id.redCount11a)).getText().toString();
//                yellowcnt=((EditText)findViewById(R.id.yellowCount11a)).getText().toString();
//                twocnt=((EditText)findViewById(R.id.twoCount11a)).getText().toString();
//                redswth = ((ToggleButton) findViewById(R.id.redSwitch11a)).getText().toString();
//                yellowcnt = ((ToggleButton) findViewById(R.id.yellowSwitch11a)).getText().toString();
//                twoswitch = ((ToggleButton) findViewById(R.id.twoSwitch11a)).getText().toString();
//                break;
//            case "12a":
//                jno=((EditText)findViewById(R.id.jessyNo12a)).getText().toString();
//                name=((EditText)findViewById(R.id.playerName12a)).getText().toString();
//                score=((EditText)findViewById(R.id.playerScore12a)).getText().toString();
//                redcnt=((EditText)findViewById(R.id.redCount12a)).getText().toString();
//                yellowcnt=((EditText)findViewById(R.id.yellowCount12a)).getText().toString();
//                twocnt=((EditText)findViewById(R.id.twoCount12a)).getText().toString();
//                redswth = ((ToggleButton) findViewById(R.id.redSwitch12a)).getText().toString();
//                yellowcnt = ((ToggleButton) findViewById(R.id.yellowSwitch12a)).getText().toString();
//                twoswitch = ((ToggleButton) findViewById(R.id.twoSwitch12a)).getText().toString();
//                break;
//            case "13a":
//                jno=((EditText)findViewById(R.id.jessyNo13a)).getText().toString();
//                name=((EditText)findViewById(R.id.playerName13a)).getText().toString();
//                score=((EditText)findViewById(R.id.playerScore13a)).getText().toString();
//                redcnt=((EditText)findViewById(R.id.redCount13a)).getText().toString();
//                yellowcnt=((EditText)findViewById(R.id.yellowCount13a)).getText().toString();
//                twocnt=((EditText)findViewById(R.id.twoCount13a)).getText().toString();
//                redswth = ((ToggleButton) findViewById(R.id.redSwitch13a)).getText().toString();
//                yellowcnt = ((ToggleButton) findViewById(R.id.yellowSwitch13a)).getText().toString();
//                twoswitch = ((ToggleButton) findViewById(R.id.twoSwitch13a)).getText().toString();
//                break;
//            case "14a":
//                jno=((EditText)findViewById(R.id.jessyNo14a)).getText().toString();
//                name=((EditText)findViewById(R.id.playerName14a)).getText().toString();
//                score=((EditText)findViewById(R.id.playerScore14a)).getText().toString();
//                redcnt=((EditText)findViewById(R.id.redCount14a)).getText().toString();
//                yellowcnt=((EditText)findViewById(R.id.yellowCount14a)).getText().toString();
//                twocnt=((EditText)findViewById(R.id.twoCount14a)).getText().toString();
//                redswth = ((ToggleButton) findViewById(R.id.redSwitch14a)).getText().toString();
//                yellowcnt = ((ToggleButton) findViewById(R.id.yellowSwitch14a)).getText().toString();
//                twoswitch = ((ToggleButton) findViewById(R.id.twoSwitch14a)).getText().toString();
//                break;
//            case "15a":
//                jno=((EditText)findViewById(R.id.jessyNo15a)).getText().toString();
//                name=((EditText)findViewById(R.id.playerName15a)).getText().toString();
//                score=((EditText)findViewById(R.id.playerScore15a)).getText().toString();
//                redcnt=((EditText)findViewById(R.id.redCount15a)).getText().toString();
//                yellowcnt=((EditText)findViewById(R.id.yellowCount15a)).getText().toString();
//                twocnt=((EditText)findViewById(R.id.twoCount15a)).getText().toString();
//                redswth = ((ToggleButton) findViewById(R.id.redSwitch15a)).getText().toString();
//                yellowcnt = ((ToggleButton) findViewById(R.id.yellowSwitch15a)).getText().toString();
//                twoswitch = ((ToggleButton) findViewById(R.id.twoSwitch15a)).getText().toString();
//                break;
//            case "16a":
//                jno=((EditText)findViewById(R.id.jessyNo16a)).getText().toString();
//                name=((EditText)findViewById(R.id.playerName16a)).getText().toString();
//                score=((EditText)findViewById(R.id.playerScore16a)).getText().toString();
//                redcnt=((EditText)findViewById(R.id.redCount16a)).getText().toString();
//                yellowcnt=((EditText)findViewById(R.id.yellowCount16a)).getText().toString();
//                twocnt=((EditText)findViewById(R.id.twoCount16a)).getText().toString();
//                redswth = ((ToggleButton) findViewById(R.id.redSwitch16a)).getText().toString();
//                yellowcnt = ((ToggleButton) findViewById(R.id.yellowSwitch16a)).getText().toString();
//                twoswitch = ((ToggleButton) findViewById(R.id.twoSwitch16a)).getText().toString();
//                break;
//        }
//        reff.child("team").child("player"+tag).child("jno").setValue(jno);
//        reff.child("team").child("player"+tag).child("name").setValue(name);
//        reff.child("team").child("player"+tag).child("score").setValue(score);
//        reff.child("team").child("player"+tag).child("redcnt").setValue(redcnt);
//        reff.child("team").child("player"+tag).child("yellowcnt").setValue(yellowcnt);
//        reff.child("team").child("player"+tag).child("twocnt").setValue(twocnt);
//        reff.child("team").child("player"+tag).child("redswth").setValue(redswth);
//        reff.child("team").child("player"+tag).child("yellowswth").setValue(yellowswth);
//        reff.child("team").child("player"+tag).child("twoswitch").setValue(twoswitch);
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditTextInput = findViewById(R.id.edit_text_input);
        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        timer =new Timer();
        mButtonSet = findViewById(R.id.button_set);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);


        mButtonSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = mEditTextInput.getText().toString();
                if (input.length() == 0) {
                    Toast.makeText(MainActivity.this, "Field can't be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                long millisInput = Long.parseLong(input) * 60000;
                if (millisInput == 0) {
                    Toast.makeText(MainActivity.this, "Please enter a positive number", Toast.LENGTH_SHORT).show();
                    return;
                }

                setTime(millisInput);
                mEditTextInput.setText("");
            }
        });
        reff= FirebaseDatabase.getInstance().getReference();
        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
    }

    private void setTime(long milliseconds) {
        mStartTimeInMillis = milliseconds;
        resetTimer();
        closeKeyboard();
    }

    private void startTimer() {
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;

        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                updateWatchInterface();
            }
        }.start();

        mTimerRunning = true;
        updateWatchInterface();
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        updateWatchInterface();
    }

    private void resetTimer() {
        mTimeLeftInMillis = mStartTimeInMillis;
        updateCountDownText();
        updateWatchInterface();
    }

    private void updateCountDownText() {
        int hours = (int) (mTimeLeftInMillis / 1000) / 3600;
        int minutes = (int) ((mTimeLeftInMillis / 1000) % 3600) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted;
        if (hours > 0) {
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%d:%02d:%02d", hours, minutes, seconds);
        } else {
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%02d:%02d", minutes, seconds);
        }

        mTextViewCountDown.setText(timeLeftFormatted);

        String t=timeLeftFormatted;
        Map<String,String>mp=new HashMap<>();
        timer.setTime(timeLeftFormatted.toString());
        reff.child("timer").setValue(timeLeftFormatted.toString());

    }

    private void updateWatchInterface() {
        if (mTimerRunning) {
            mEditTextInput.setVisibility(View.INVISIBLE);
            mButtonSet.setVisibility(View.INVISIBLE);
            mButtonReset.setVisibility(View.INVISIBLE);
            mButtonStartPause.setText("Pause");
        } else {
            mEditTextInput.setVisibility(View.VISIBLE);
            mButtonSet.setVisibility(View.VISIBLE);
            mButtonStartPause.setText("Start");

            if (mTimeLeftInMillis < 1000) {
                mButtonStartPause.setVisibility(View.INVISIBLE);
            } else {
                mButtonStartPause.setVisibility(View.VISIBLE);
            }

            if (mTimeLeftInMillis < mStartTimeInMillis) {
                mButtonReset.setVisibility(View.VISIBLE);
            } else {
                mButtonReset.setVisibility(View.INVISIBLE);
            }
        }
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putLong("startTimeInMillis", mStartTimeInMillis);
        editor.putLong("millisLeft", mTimeLeftInMillis);
        editor.putBoolean("timerRunning", mTimerRunning);
        editor.putLong("endTime", mEndTime);

        editor.apply();

        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);

        mStartTimeInMillis = prefs.getLong("startTimeInMillis", 600000);
        mTimeLeftInMillis = prefs.getLong("millisLeft", mStartTimeInMillis);
        mTimerRunning = prefs.getBoolean("timerRunning", false);

        updateCountDownText();
        updateWatchInterface();

        if (mTimerRunning) {
            mEndTime = prefs.getLong("endTime", 0);
            mTimeLeftInMillis = mEndTime - System.currentTimeMillis();

            if (mTimeLeftInMillis < 0) {
                mTimeLeftInMillis = 0;
                mTimerRunning = false;
                updateCountDownText();
                updateWatchInterface();
            } else {
                startTimer();
            }
        }
    }
}