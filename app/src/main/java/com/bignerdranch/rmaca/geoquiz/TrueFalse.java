package com.bignerdranch.rmaca.geoquiz;

public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;
    private boolean mIsCheater;

    public TrueFalse(int question, boolean trueQuestion, boolean isCheater) {
        mQuestion = question;
        mTrueQuestion = trueQuestion;
        mIsCheater = isCheater;

    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean mTrueQuestion) {
        this.mTrueQuestion = mTrueQuestion;
    }

    public boolean ismIsCheater() {
        return mIsCheater;
    }

    public void setmIsCheater(boolean mIsCheater) {
        this.mIsCheater = mIsCheater;
    }

}
