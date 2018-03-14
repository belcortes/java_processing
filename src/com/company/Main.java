package com.company;

import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main(Main.class.getName(), args);
    }


    private float circleX, circleY;  // Position of circle button
    private int circleSize = 93;   // Diameter of circle
    private boolean circleOver = false;
    private int clicker = 0;
    private int begin;
    private int duration = 20;
    private int time = 20;

    public void settings(){
        size(800,600);
    }

    public void setup() {
        noStroke();
        circleX = width/2;
        circleY = height/2;
        begin = millis();
    }
    public void draw() {
        update(mouseX, mouseY);
        background(126);
        text( "How many times can you click the circle in 20 seconds? ", 10, 30);
        text( "Clicker: "+clicker, 10, 50);
//        rect(10,80,50,100);
//        text("START!", 20, 100);
//        fill(0, 102, 153);
//        text(millis()/1000, 170, 170);
        if (time > 0){
            time = duration - (millis() - begin)/1000;
            text(time, 80, 80);
        } else if(time == 0) {
            text("GAME OVER", 10, 100);
            clicker = 0;
        }

        stroke(0);
        ellipse(circleX, circleY, circleSize, circleSize);
    }


    public void update(int x, int y) {
        if ( overCircle(circleX, circleY, circleSize) ) {
            circleOver = true;
        } else {
            circleOver = false;
        }
    }

    public void mousePressed() {
        if (circleOver) {
            clicker++;
            circleX = random(800);
            circleY = random(600);
        }
    }

    public boolean overCircle(float x, float y, int diameter) {
        float disX = x - mouseX;
        float disY = y - mouseY;
        return sqrt(sq(disX) + sq(disY)) < diameter / 2;
    }




}
