package web.service;

import web.model.Car;


public interface CarService {

    void save(Car car);

    Car[] get(int count);

    void update(Car car);

    void remove(int id);
}
