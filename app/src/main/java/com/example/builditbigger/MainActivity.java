package com.example.builditbigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().
                add(R.id.fragment,new JokeFrgment()).commit();
    }
    @SuppressWarnings("unchecked")
    public void tellJoke(View view) {
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
        new EndPointAsyncTask(this, progressBar).execute();
    }
}
