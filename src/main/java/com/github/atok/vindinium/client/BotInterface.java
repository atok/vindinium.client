package com.github.atok.vindinium.client;


import com.github.atok.vindinium.client.model.Direction;
import com.github.atok.vindinium.client.model.State;

public interface BotInterface {
    public Direction nextMove(final State state);
}
