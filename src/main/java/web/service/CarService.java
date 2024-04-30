package web.service;

import web.model.Car;


public interface CarService {

    String ping();

    boolean save(Car car);

    Car get(int id);

    Car[] getSeveral(int count); // согласно задания

    Car update(int id, Car car);

    boolean remove(int id);
}
