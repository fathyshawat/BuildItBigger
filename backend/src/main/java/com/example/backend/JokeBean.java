package com.example.backend;

import com.example.jokelib.Joke;

public class JokeBean {

    private Joke myData;

    public Joke getData() {
        return myData;
    }

    public void setData(Joke data) {
        myData = data;
    }
}