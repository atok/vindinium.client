package com.github.atok.vindinium.client.model;

import com.google.gson.annotations.SerializedName;

public class Board {
    public Integer size;

    @SerializedName("tiles")
    public String rawTiles;

    transient private Tile[][] tiles = null;

    public Tile[][] getTiles() {
        if(tiles == null) {
            tiles = parseTiles();
        }
        return tiles;
    }

    private Tile[][] parseTiles() {
        Tile[][] ret = new Tile[size][size];
        for(int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                String rawTile = rawTiles.substring(y * size + x * 2, y * size + x * 2 + 2);
                ret[y][x] = new Tile(rawTile);
            }
        }
        return ret;
    }
}
