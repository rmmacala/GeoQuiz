package com.bignerdranch.rmaca.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity {

    public static final String EXTRA_ANSWER_IS_TRUE = "com.bignerdranch.android.geoquiz.answer.is.true";
    public static final String EXTRA_ANSWER_SHOWN = "com.bignerdranch.android.geoquiz.answer.shown";
    private static final String TAG = "CheatActivity";
    private static final String KEY_INDEX = "index";
    private boolean mAnswerIsTrue;
    private boolean mAnswerButtonPressed;
    private TextView mAnswerTextView;
    private Button mShowAnswer;

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = findViewById(R.id.answerTextView);

        setAnswerShownResult(false);

        mShowAnswer = findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnswerButtonPressed = true;
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                }
                else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
            }
        });

        if (savedInstanceState != null) {
            mAnswerButtonPressed = savedInstanceState.getBoolean(KEY_INDEX, mAnswerButtonPressed);
        }
        checkShownAnswerClicked();
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putBoolean(KEY_INDEX, mAnswerButtonPressed);
    }

    private void checkShownAnswerClicked() {
        if (mAnswerButtonPressed) {
            if (mAnswerIsTrue) {
                mAnswerTextView.setText(R.string.true_button);
            } else {
                mAnswerTextView.setText(R.string.false_button);
            }
            setAnswerShownResult(true);
        }
    }
}
