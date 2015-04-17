package com.system.utils;

import com.logic.player.APlayer;

public class PlayerUtil {

    /**
     * Calculate the distance between two player.
     * 1.clockwise direction;
     * 2.anticlockwise direction;
     * return the minimum distance between the two direction.
     *
     * @param player1
     * @param player2
     * @return distance between two player.
     * @throws java.lang.RuntimeException if distance is not valid.
     */
    public int getDistance(APlayer player1, APlayer player2) {
        if (player1.getPosition() < 1 || player2.getPosition() < 1 ||
            player1.getPosition() > 5 || player2.getPosition() > 5) {
            throw new RuntimeException("Invalid distance.");
        }
        int distance = Math.abs(player2.getPosition() - player1.getPosition());
        if (distance > 2) {
            distance = 5 - distance;
        }
        return distance;
    }
}
