package com.example.myandroidlib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Display extends AppCompatActivity {

    public final static String INTENT_JOKE = "INTENT_JOKE";
    String joke;
    TextView textViewJoke;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        joke = getIntent().getStringExtra(INTENT_JOKE);
        textViewJoke = (TextView) findViewById(R.id.tv);
        textViewJoke.setText(joke);
    }
}
