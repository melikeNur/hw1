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
public class Player {
    public static final char marker = 'p';
    private Position position;
    public Player(int x, int y) {
        position = new Position(x,y);
    }
    public Position getPosition() {
        return this.position;
    }
    public void move() {
       
        Position newPosition;
        while(!Terrain.canGo(newPosition = step()));
     
        
        position = newPosition;
       
         
     //   System.out.println(Terrain.canGo(position));
    }
    
    private Position step() {
        Random r =new Random();
        int oldX = position.getX();
        int oldY = position.getY();
        int newX , newY ;
        int[]directions = {-2,-1,1,2};
        int randomIndex = r.nextInt(directions.length);
        int X =directions[randomIndex];
        if(X==-2){
            newX=oldX-1;
            newY=oldY;
        }else if(X==-1){
            newX=oldX+1;
            newY=oldY;
        }else if(X==1){
            newY=oldY-1;
            newX=oldX;
        }else{
            newY=oldY+1;
            newX=oldX;
        }
      //  System.out.println("oldX = "+oldX+" oldY = "+oldY+ " newX = "+newX+ " newY = "+newY);
       
              
        Position newPosition = new Position(newX,newY);
        return newPosition;
    }
    
    
}
