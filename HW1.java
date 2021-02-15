
//package hw1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

public class HW1 {
    public static void main(String[] args) throws IOException {
        Random r = new Random();
        Config config = new Config("var.cfg");
        config.config();
        int finishX = r.nextInt(config.width-1);
        int finishY = r.nextInt(config.height-1);
        Terrain terrain = new Terrain(config.width,config.height, finishX, finishY);
        for(int i = 0;i < config.numberOfObstacle;) {
            int X = r.nextInt(config.width-1);
            int Y = r.nextInt(config.height-1);
            Obstacle newObstacle = new Obstacle(X,Y);
            if(terrain.addObstacle(newObstacle)) {
                i++;
            }
        }
        for(int i = 0;i < config.numberOfPeople;) {
            int X = r.nextInt(config.width-1);
            int Y = r.nextInt(config.height-1);
            Player player = new Player(X,Y);
            if(terrain.addPlayer(player)) {
                i++;
            }
        }

         int i=1;
         terrain.print();
         while(!terrain.won()){
             i++;
             terrain.step();
             terrain.print();
        }
         
        
         terrain.printLast();
         
         
    }
}   
