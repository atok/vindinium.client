package com.github.atok.vindinium.client.model;

/**
 * Play direction.
 */
public enum Direction {
    STAY("Stay"), NORTH("North"), SOUTH("South"), EAST("East"), WEST("West");

    // --- Properties ---

    /**
     * String representation
     */
    public final String name;

    private Direction(final String name) { this.name = name; }

    public static Direction reverse(Direction dir) {
        if(dir == STAY)
            return STAY;

        if(dir == NORTH)
            return SOUTH;

        if(dir == SOUTH)
            return NORTH;

        if(dir == EAST)
            return WEST;

        if(dir == WEST)
            return EAST;

        if(dir == null)
            return null;

        return null;
    }

    public Direction reverse() {
        return Direction.reverse(this);
    }


    /**
     * Returns string representation/name.
     */
    public String toString() {
        return this.name;
    } // end of toString
} // end of enumeration Direction
        
