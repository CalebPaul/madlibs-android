package com.mad.libs.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MadLibsActivity extends AppCompatActivity {
    @Bind(R.id.nounLine) TextView mNounLine;
    @Bind(R.id.verbLine) TextView mVerbLine;
    @Bind(R.id.nameLine) TextView mNameLine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_libs);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String noun = intent.getStringExtra("noun");
        String verb = intent.getStringExtra("verb");
        String name = intent.getStringExtra("name");
        verb = verb + "s";

        mNounLine.setText("The body of a " + noun);
        mVerbLine.setText("With a soul that " + verb);
        mNameLine.setText("This is the essence of " + name);

    }
}
