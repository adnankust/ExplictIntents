package com.example.explictintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Class name for log tag
    private  static final String LOG_TAG = MainActivity.class.getSimpleName();
    //Unique tag required for the intent extra
    public static final String EXTRA_MESSAGE = "com.example.explictintents.extra.MESSAGE";
    //Unique tag for the intent reply
    public static final int TEXT_REQUEST = 1;

    private EditText mMessageEditText;
    private TextView mReplyHeaderTextView;
    private TextView mReplayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize all the view variables
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeaderTextView = findViewById(R.id.text_header_reply);
        mReplayTextView = findViewById(R.id.text_message_reply);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    /**
     * Handles the data in the return intent from SecondActivity
     * @param requestCode Code for the secondActivity request
     * @param resultCode Code that comes back from SecondActivity
     * @param data Intent data sent back from SecondActivity
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Test for the reight intent reply.
        if(requestCode == TEXT_REQUEST) {
            //TEXT TO MAKE SURE THE INTENT REPLY RESULT WAS GOOD
            if(resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                //Make the reply head visible
                mReplyHeaderTextView.setVisibility(View.VISIBLE);
                //Set the reply and make it visible
                mReplayTextView.setText(reply);
                mReplayTextView.setVisibility(View.VISIBLE);
            }

        }
    }
}