package com.example.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.example.com",
                ownerName = "backend.example.com",
                packagePath = ""))
public class EndPoint {

    @ApiMethod(name = "putJoke")
    public JokeBean putJoke(JokeBean joke) {
//        JokeBean response = new JokeBean();
//        response.setJoke("Hi, " + name);
        return joke;
    }


}
