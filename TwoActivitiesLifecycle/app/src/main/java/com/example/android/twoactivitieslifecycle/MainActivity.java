package com.example.android.twoactivitieslifecycle;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESAAGE";
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView, mReplyTextView;
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG,"------");
        Log.d(LOG_TAG,"onCreate"); // ketika layout tercipta

        mMessageEditText = (EditText)findViewById(R.id.editText_main);
        mReplyHeadTextView = (TextView)findViewById(R.id.text_header_reply);
        mReplyTextView = (TextView)findViewById(R.id.text_message_reply);

        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            if (isVisible) {
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(savedInstanceState.getString("reply_text"));
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
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

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mReplyHeadTextView.getVisibility() == View.VISIBLE){
            outState.putBoolean("reply_visible",true);
            outState.putString("reply_text", mReplyTextView.getText().toString());
        }

    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        String message = mMessageEditText.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent,TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if (resultCode == RESULT_OK){
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}
