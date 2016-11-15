package com.mad.libs.madlibs;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private TextView mAppNameTextView;
    @Bind(R.id.name) EditText mName;
    @Bind(R.id.noun) EditText mNoun;
    @Bind(R.id.verb) EditText mVerb;
    @Bind(R.id.submitWords) Button mSubmitWordsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAppNameTextView = (TextView) findViewById(R.id.textView);
        Typeface fortyTwoFont = Typeface.createFromAsset(getAssets(), "fonts/1942.ttf");
        mAppNameTextView.setTypeface(fortyTwoFont);
        ButterKnife.bind(this);

        mSubmitWordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mName.getText().toString();
                String noun = mNoun.getText().toString();
                String verb = mVerb.getText().toString();
                Intent intent = new Intent(MainActivity.this, MadLibsActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("noun", noun);
                intent.putExtra("verb", verb);
                mName.setText("");
                mNoun.setText("");
                mVerb.setText("");
                startActivity(intent);
            }
        });
    }
}
