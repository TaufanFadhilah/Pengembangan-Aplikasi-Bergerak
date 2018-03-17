package com.example.android.whowroteitloader;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

/**
 * Created by Taufan Fadhilah on 3/17/2018.
 */

public class BookLoader extends AsyncTaskLoader<String> {

    String mQueryString;
    public BookLoader(Context context, String query) {
        super(context);
        mQueryString = query;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public String loadInBackground() {
        return NetworkUtils.getBookInfo(mQueryString);
    }
}
