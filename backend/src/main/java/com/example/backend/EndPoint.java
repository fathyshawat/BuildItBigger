package com.example.backend;

import com.example.jokelib.Joke;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

@Api(
        name = "myApi",
        version = "v2",
        namespace = @ApiNamespace(
                ownerDomain = "backend.example.com",
                ownerName = "backend.example.com",
                packagePath = ""))
public class EndPoint {

    @ApiMethod(name = "putJoke")
    public JokeBean putJoke() {
        JokeBean response = new JokeBean();
        response.setData(Joke.getRandomJoke());
        return response;
    }


}
