package com.android.example.wordlistsql;

import android.database.Cursor;

/**
 * Created by Taufan Fadhilah on 3/22/2018.
 */

public class WordItem {
    private int mId;
    private String mWord;

    public WordItem(){

    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public void setWord(String mWord) {
        this.mWord = mWord;
    }

    public int getId() {
        return mId;
    }

    public String getWord() {
        return mWord;
    }
}
