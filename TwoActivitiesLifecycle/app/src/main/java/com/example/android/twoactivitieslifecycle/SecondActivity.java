package com.example.android.twoactivitieslifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY";
    private EditText mReply;
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d(LOG_TAG,"------");
        Log.d(LOG_TAG,"onCreate"); // ketika layout tercipta

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = (TextView)findViewById(R.id.text_message);
        textView.setText(message);
        mReply = (EditText) findViewById(R.id.editText_second);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"onStart"); // ketika layout siap digunakan
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"onPause"); // ketika keluar dari aplikasi secara sementara
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"onResume"); // ketika aplikasi digunakan kembali setelah dari onPause
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"onStop"); // ketika aplikasi berhenti
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy"); // ketika aplikasi terhapus memorinya
    }

    public void returnReply(View view) {
        Log.d(LOG_TAG, "End SecondActivity");
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY,reply);
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}
