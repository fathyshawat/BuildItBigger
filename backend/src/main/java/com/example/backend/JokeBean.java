package com.example.backend;

import com.example.jokelib.TellingJoke;

public class JokeBean {

    private TellingJoke jokeTelling;

    public JokeBean() {
        jokeTelling = new TellingJoke();
    }

    public String getJoke() {
        return jokeTelling.getRandomJoke();
    }

    public void setJokeTelling(TellingJoke jokeTelling) {
        this.jokeTelling = jokeTelling;
    }
}