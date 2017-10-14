package com.qalabs.javabasics;


class Bike {
    private String brand;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {

        assert speed < 0 && speed >= 1000 ;

        this.speed = speed;
    }

    private int speed;

    Bike(String brand) {
        this.brand = brand;
        this.speed = 0;
    }

    void speedUp() {
        this.speed += 1;
        System.out.println(String.format("%s speed %d", this.brand, this.speed));
    }

    void speedUp( int interval) {
        this.speed += interval;
        System.out.println(String.format("%s speed %d", this.brand, this.speed));
    }
}

class MountainBike extends Bike {
    private int seatHeight;

    MountainBike(String brand) {
        super(brand);
        this.seatHeight = 0;
    }


    public void setSeatHeight(int newHeight) {
        this.seatHeight = newHeight;
    }
}

class RoadBike extends Bike {
    private int sizeTire;

    RoadBike(String brand) {
        super(brand);
        this.sizeTire=1;
        setSpeed(1000);
    }

}

public class InheritanceExample {
    public static void main (String[] args) {
        // Hold bike instance into bike variable
        Bike bike = new Bike("bike");
        bike.speedUp();

        // Hold mountain bike instance into same bike variable, no problem
        bike = new MountainBike("mountain bike");
        bike.speedUp();

        bike = new RoadBike("road bike");
        bike.speedUp(2);
    }
}
