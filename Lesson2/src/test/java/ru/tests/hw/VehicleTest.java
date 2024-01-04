package ru.tests.hw;

/*
     Написать следующие тесты:
     - проверка того, что экземпляр объекта Car также является экземпляром
     транспортного средства; (instanceof)
     - проверка того, объект Car создается с 4-мя колесами
     - проверка того, объект Motorcycle создается с 2-мя колесами
     - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
     - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового
     вождения (testDrive())
     - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция
     движения транспорта) машина останавливается (speed = 0)
     - проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция
     движения транспорта) мотоцикл останавливается (speed = 0)
    */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleTest {

    private Car car;
    private Motorcycle motorcycle;

    @BeforeEach
    void init() {
        car = new Car("Toyota", "Prius", 2016);
        motorcycle = new Motorcycle("BMW", "Motorrad", 2023);
    }

    // проверка того, что экземпляр объекта Car также является экземпляром
    // транспортного средства; (instanceof)
    @Test
    void carIsInstanceOfVehicle() {
        assertThat(car).isInstanceOf(Vehicle.class);
    }

    // проверка того, объект Car создается с 4-мя колесами
    @Test
    void newCarHas4NumWheels() {
        int wheels = car.getNumWheels();
        assertThat(wheels).isEqualTo(4);
    }

    // проверка того, объект Motorcycle создается с 2-мя колесами
    @Test
    void newMotorcycleHas2NumWheels() {
        int wheels = motorcycle.getNumWheels();
        assertThat(wheels).isEqualTo(2);
    }

    // проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
    @Test
    void checkCarTestDriveSpeed() {
        car.testDrive();
        int speed = car.getSpeed();
        assertThat(speed).isEqualTo(60);
    }

    // проверка того, объект Motorcycle развивает скорость 75 в режиме тестового
    // вождения (testDrive())
    @Test
    void checkMotorcycleTestDriveSpeed() {
        motorcycle.testDrive();
        int speed = motorcycle.getSpeed();
        assertThat(speed).isEqualTo(75);
    }

    // проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция
    // движения транспорта) машина останавливается (speed = 0)
    @Test
    void checkCarParkSpeed() {
        car.testDrive();
        car.park();
        int speed = car.getSpeed();
        assertThat(speed).isEqualTo(0);
    }

    // проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция
    // движения транспорта) мотоцикл останавливается (speed = 0)
    @Test
    void checkMotorcycleParkSpeed() {
        motorcycle.testDrive();
        motorcycle.park();
        int speed = motorcycle.getSpeed();
        assertEquals(speed, 0);
    }
}