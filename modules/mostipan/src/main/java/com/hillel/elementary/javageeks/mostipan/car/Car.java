package com.hillel.elementary.javageeks.mostipan.car;


public class Car {


    private String model;
    private int gasTank;
    private int maxSpeed;
    public Wheels wheels;
    public Engine engine;

    public Car(String model, int gasTank, int maxSpeed , Wheels wheels, Engine engine) {
        this.model = model;
        this.gasTank = gasTank;
        this.maxSpeed = maxSpeed;
        this.wheels = wheels;
        this.engine=engine;

    }
    public Wheels getWheels() {
        return wheels;
    }
    public String getModel() {
        return model;
    }

    public  Engine getEngine(){
        return engine;
    }
    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }
    public void setEngine(Engine engine){
       this.engine=engine;
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getGasTank() {
        return gasTank;
    }

    public void setGasTank(int gasTank) {
        this.gasTank = gasTank;
    }


    public void setModel(String model) {
        this.model = model;
    }
    public void stop(){
        if (getGasTank()==0)
        System.out.println("Stop!The tank is empty");
        if (engine.isEngineWorking()==false){
            System.out.print("Engine is broken!");
        }



    }
    public  void move (){
        if (getGasTank()==0 || !wheels.isWheelsEnough() || !engine.isEngineWorking()){
            stop();
        }else {
            System.out.print("Car is moves");
      }

    }


    public void fillTheTank(int gass){
        if (gasTank<100){
            gasTank+=gass;
            System.out.print("You filled up the tank:"+gass);
        }else{
            System.out.println("Gass tank is full");
        }

    }

    }

