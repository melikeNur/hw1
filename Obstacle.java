/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hw1;

import java.util.Random;

/**
 *
 * @author melikenur
 */
public class Obstacle {
    public static final char marker = '1';
    private Position position;
    public Obstacle(int x, int y) {
        position = new Position(x,y);
    }
    public Position getPosition() {
        return this.position;
    }
}