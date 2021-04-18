package com.example.explictintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    //Unique tag for the intent replay
    public static final String EXTRA_REPLY = "com.example.explictintents.extra.REPLY";

    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mReply = findViewById(R.id.editText_second);

        //Get the intent that lanched this activity, and the message in the intent extra.
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);


    }

    /**
     * Handles the onClick for the "Reply button. Gets the message from the
     * second EditText, creates an intent, and returns that message back to the main Activity
     */

    public void returnReply(View view) {
        String reply = mReply.getText().toString();

        //Create a new intent fro the reply, add the reply message to it
        //as an extra, set the intent result, and close the activity
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}