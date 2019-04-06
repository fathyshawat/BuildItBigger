package com.example.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;


import com.example.backend.myApi.MyApi;
import com.example.backend.myApi.model.JokeBean;
import com.example.myandroidlib.Display;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

public class EndPointAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi mJokeApi = null;
    private Context context;
    private String mResult;
    private ProgressBar mProgressBar;

    public EndPointAsyncTask(Context context, ProgressBar progressBar) {
        this.context = context;
        this.mProgressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (mJokeApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/");
            mJokeApi = builder.build();
        }
        try {
            return mJokeApi.putJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
        }
        mResult = result;
        startJokeDisplayActivity();
    }

    private void startJokeDisplayActivity() {
        Intent intent = new Intent(context, Display.class);
        intent.putExtra(Display.INTENT_JOKE, mResult);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}