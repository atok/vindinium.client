package com.github.atok.vindinium.client;


import com.github.atok.vindinium.client.model.Direction;
import com.github.atok.vindinium.client.model.State;
import com.google.gson.Gson;
import com.squareup.okhttp.*;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class VinClient {

    public final String BASE_URL = "http://vindinium.org/api/";
    public final OkHttpClient http = new OkHttpClient();
    public final String key;

    private final Gson gson = new Gson();

    public VinClient(String key) {
        this.key = key;
    }

    public void playTraining(int turns, String map, BotInterface bot, boolean openGameInBrowser) {
        RequestBody params = new FormEncodingBuilder()
                .add("key", key)
                .add("turns", Integer.toString(turns))
                .add("map", map)
                .build();

        State initialState = getState(BASE_URL + "training", params);
        if(openGameInBrowser) {
            showInBrowser(initialState.viewUrl);
        }
        playLoop(initialState, bot);
    }

    public void playArena(BotInterface bot, boolean openGameInBrowser) {
        RequestBody params = new FormEncodingBuilder()
                .add("key", key)
                .build();

        State initialState = getState(BASE_URL + "arena", params);
        if(openGameInBrowser) {
            showInBrowser(initialState.viewUrl);
        }
        playLoop(initialState, bot);
    }

    private void playLoop(State firstState, BotInterface bot) {
        State state = firstState;
        while(!state.game.finished) {
            Direction direction = bot.nextMove(state);

            RequestBody nextMoveParams = new FormEncodingBuilder()
                    .add("key", key)
                    .add("dir", direction.name)
                    .build();

            state = getState(state.playUrl, nextMoveParams);
        }
    }

    private void showInBrowser(String url) {
        try {
            URI url2 = new URI(url);
            Desktop.getDesktop().browse(url2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private State getState(String url, RequestBody params) {
        Request request = new Request.Builder()
                .url(url)
                .post(params)
                .build();
        try {
            Response response = http.newCall(request).execute();
            if (!response.isSuccessful()) throw new IOException("Unexpected code: " + response);
            String responseString = response.body().string();
            return gson.fromJson(responseString, State.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
