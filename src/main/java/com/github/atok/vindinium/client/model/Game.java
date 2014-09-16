package com.github.atok.vindinium.client.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public String id;
    public Integer turn;
    public Integer maxTurns;
    public List<Hero> heroes = new ArrayList<Hero>();
    public Board board;
    public Boolean finished;
}
