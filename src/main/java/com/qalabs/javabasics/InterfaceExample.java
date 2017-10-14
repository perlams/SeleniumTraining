package com.qalabs.javabasics;

interface Vehicle {
    void speedUp();
    void printSpec();
}

class Tank implements Vehicle {
    private int speed;

    Tank() {
        this.speed = 0;
    }
    public void speedUp() {
        this.speed += 1;
        System.out.println(String.format("New speed %s", this.speed));
    }

    public void printSpec() {

        System.out.println(String.format("Imprime spec de Tank"));
    }
}

class Truck implements Vehicle{
    private int speed;

    public void printSpec(){

        System.out.println(String.format("Imprime spec de Truck"));

    }
    public void speedUp() {
        this.speed += 5;
        System.out.println(String.format("New speed %s", this.speed));
    }


}

public class InterfaceExample {
    public static void main (String[] args) {
        Vehicle myVehicle = new Tank();
        myVehicle.speedUp();
        myVehicle.printSpec();

        myVehicle = new Truck();
        myVehicle.speedUp();
        myVehicle.printSpec();
    }

}
