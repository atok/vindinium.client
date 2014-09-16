package com.github.atok.vindinium.client.model;

public class Tile {

    public TileCategory category;
    public int who = 0;

    public Tile(String raw) {
        if(raw.equals("##")) {
            category = TileCategory.wall;
        } else if(raw.equals("[]")) {
            category = TileCategory.tavern;
        } else if(raw.startsWith("@")) {
            category = TileCategory.hero;
            if(raw.substring(1).equals("-")) {
                who = 0;
            } else {
                who = Integer.parseInt(raw.substring(1));
            }
        } else if(raw.startsWith("$")) {
            if(raw.substring(1).equals("-")) {
                who = 0;
            } else {
                who = Integer.parseInt(raw.substring(1));
            }
            category = TileCategory.mine;
        } else if(raw.equals("  ")) {
            category = TileCategory.air;
        } else {
            throw new RuntimeException("Unknown tile: " + raw);
        }
    }

    public enum TileCategory {
        wall, hero, tavern, mine, air
    }
}
