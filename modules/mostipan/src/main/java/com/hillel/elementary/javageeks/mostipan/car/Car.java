package com.hillel.elementary.javageeks.mostipan.car;


public class Car {


    private String model;
    private int gasTank;
    private int maxSpeed;
    public Wheel wheel;
    public Engine engine;

    public Car(String model, int gasTank, int maxSpeed , Wheel wheel , Engine engine) {
        this.model = model;
        this.gasTank = gasTank;
        this.maxSpeed = maxSpeed;
        this.wheel = wheel;
        this.engine=engine;

    }
    public Wheel getWheel() {
        return wheel;
    }
    public String getModel() {
        return model;
    }

    public  Engine getEngine(){
        return engine;
    }
    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
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
        if (getWheel().getAmounntWheels()<4){
            System.out.println("Stop!Wheel is broken ,please change it");
        }

        if (getGasTank()==0)
        System.out.println("Stop!The tank is empty");
        if (engine.isEngineWorking()==false){
            System.out.print("Engine is broken!");
        }



    }
    public  void move (){
        if (getGasTank()==0 || getWheel().getAmounntWheels()<4 || !engine.isEngineWorking()){
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

