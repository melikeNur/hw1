/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hw1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author melikenur
 */
public class Terrain {
    ArrayList<Obstacle> obstacles;
    ArrayList<Player> players;
   
    public static final char FINISH ='F';
    public static final char FREE = '0';
    private boolean success;
    public static int width, height, finishX, finishY;
    public static int turn;
    
    public  Terrain(int width, int height, int finishX, int finishY) {
        success = false;
        this.width = width;
        this.height = height;
        this.finishX = finishX;
        this.finishY = finishY;
        this.turn=0;
        obstacles = new ArrayList<Obstacle>();
        players = new ArrayList<Player>();
        
    }
    public static boolean canGo(Position position) {
        
          if(position.getX()==-1){
           return false;
          }   
          if(position.getX() == width){
            return false;}
            
          if(position.getY() == -1){     
            return false;}
          
          if(position.getY() == height){
            return false;}
         if((position.getX() == Obstacle.marker ) || (position.getY() == Obstacle.marker)){
             return false;
         }

          return true;
         
      }
    public boolean stay(Position position){
        boolean stayi=false;
          for (Obstacle obstacle : obstacles){
          if(position.getX()==obstacle.getPosition().getX() && position.getY()==obstacle.getPosition().getY()){
              stayi=true;
          }
          }
          return stayi;
    }
 
    public boolean addObstacle(Obstacle obstacle) {
        boolean exists = false;
        for(Obstacle o : obstacles) {
            if(o.getPosition().getX() == obstacle.getPosition().getX() && o.getPosition().getY() == obstacle.getPosition().getY()){
                exists = true;
            }
        }
        if(!exists) {
            obstacles.add(obstacle);
        }
        return !exists;
    }
    public boolean addPlayer(Player player) {
        boolean exists = false;
        for(Player p : players) {
            if((p.getPosition().getX() == player.getPosition().getX() && p.getPosition().getY() == player.getPosition().getY()) ||
                (player.getPosition().getX() == finishX && player.getPosition().getY() == finishY)){
                exists = true;
            }
        }
        if(!exists) {
            players.add(player);
        }
        return !exists;
    }

    public void step() {
        for(Player p : players) {
            p.move();
        }
    }
    
    public void print() throws FileNotFoundException, IOException {
         turn ++;
         File state = new File("output" + turn + ".txt");
         FileOutputStream os = new FileOutputStream(state);
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        char[][] board = new char[width][height];
        for(int i=0;i<width;i++){
           for(int j=0;j<height;j++){
               board[i][j] = FREE;
           }
        }
        board[finishX][finishY] = FINISH;
        for(Obstacle o : obstacles) {
            board[o.getPosition().getX()][o.getPosition().getY()] = Obstacle.marker;
        }
        for(Player p : players) {
            board[p.getPosition().getX()][p.getPosition().getY()] = Player.marker;
        }
        for(int i=0;i<width;i++){
           for(int j=0;j<height;j++){
               bw.write(board[i][j] + "\t");
           }
           bw.write("\n");
         
           
        } 
           bw.write("The game continues");      
           bw.close();
    }
    public void printLast() throws FileNotFoundException, IOException {
         turn ++;
         File state = new File("output" + turn + ".txt");
         FileOutputStream os = new FileOutputStream(state);
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        char[][] board = new char[width][height];
        for(int i=0;i<width;i++){
           for(int j=0;j<height;j++){
               board[i][j] = FREE;
           }
        }
        board[finishX][finishY] = FINISH;
        for(Obstacle o : obstacles) {
            board[o.getPosition().getX()][o.getPosition().getY()] = Obstacle.marker;
        }
        for(Player p : players) {
            board[p.getPosition().getX()][p.getPosition().getY()] = Player.marker;
        }
        for(int i=0;i<width;i++){
           for(int j=0;j<height;j++){
               bw.write(board[i][j] + "\t");
           }
           bw.write("\n");
         
           
        } 
          bw.write("PLAYER WON!");
          bw.write("The game lasted " +turn +" rounds");
          bw.close();
    }
    public boolean won() {
       for(Player p : players) {
        if((p.getPosition().getX() == finishX) && (p.getPosition().getY() == finishY)){
        return true;
    }
} 
       return success;
}
}

            
 
         
