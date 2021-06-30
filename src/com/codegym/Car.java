package com.codegym;

import org.omg.PortableInterceptor.DISCARDING;

import java.io.Serializable;
import java.util.Random;

public class Car implements Runnable {
    private String name;
private static int DISTANCE = 100;
private static int STEP = 2;
    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }


    @Override
    public void run() {
        // khởi tạo điểm bắt dầu
        int runDistance = 0;
        //khởi tạo thời gian bắt đầu
        long startTime = System.currentTimeMillis();
        while (runDistance < DISTANCE) {
            try {
                int speed = (new Random().nextInt(20));
                runDistance += speed;
                String log = "|";
                int percentTravel = (runDistance * 100) / DISTANCE;
                for (int i = 0; i < DISTANCE; i++) {
                    if (percentTravel >= i + STEP){
                        log += "=";
                    }else if(percentTravel >= i && percentTravel<i+STEP){
                        log += "o";
                    }else {
                        log += "-";
                    }
                }log+="|";
                System.out.println("Car" + this.name + ": " + log + " " + Math.min(DISTANCE, runDistance) + "KM");
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("Car" + this.name + " broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
    }
}
