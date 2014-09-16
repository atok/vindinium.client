package com.github.atok.vindinium.client.model;

import com.google.gson.GsonBuilder;

public class State {

    public Game game;
    public Hero hero;
    public String token;
    public String viewUrl;
    public String playUrl;

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
