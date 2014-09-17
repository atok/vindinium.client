package com.github.atok.vindinium.client;

import com.github.atok.vindinium.client.model.Direction;
import com.github.atok.vindinium.client.model.State;

import java.util.Random;

public class ExampleBot implements BotInterface {

    Random rnd = new Random();
    @Override
    public Direction nextMove(State state) {
        return Direction.values()[rnd.nextInt(Direction.values().length)];
    }

    public static void main(String[] args) {
        VinClient vinClient = new VinClient("YOUR BOT KEY"); // Get one here: http://vindinium.org/register
//        vinClient.playArena(new ExampleBot(), true);
        vinClient.playTraining(20, "m1", new ExampleBot(), true);
    }
}
