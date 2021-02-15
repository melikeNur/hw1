/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hw1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author melikenur
 */
public class Config {
    public int height;
    public int width;
    public int numberOfPeople;
    public int numberOfObstacle;
    public int finishPoint;
    String path;
    public Config(String path) {
        this.path = path;
    }
    public void config() throws FileNotFoundException, IOException{
        File file = new File(path); 
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String st;
        st = br.readLine(); 
        String[] list = st.split(" ");
        height = Integer.parseInt(list[1]);
        st = br.readLine(); 
        list = st.split(" ");
        width = Integer.parseInt(list[1]);
        st = br.readLine(); 
        list = st.split(" ");
        numberOfPeople = Integer.parseInt(list[1]);
        st = br.readLine(); 
        list = st.split(" ");
        numberOfObstacle= Integer.parseInt(list[1]);
    }
}

