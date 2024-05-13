package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;


@Component
public class CarDaoImplArrayList implements CarDao, Constants {

    private List<Car> carList;


    public CarDaoImplArrayList() {
        this.carList = fillTestData();
        printCars(carList.toArray(Car[]::new));
    }


    @Override
    public void save(Car car) {
        throw new UnsupportedOperationException("Метод 'save' не реализован");
    }


    @Override
    public Car get(int id) {
        return carList.stream()
                .filter(car -> car.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Car[] get() {
        return carList.toArray(Car[]::new);
    }

    @Override
    public void update(Car carUpdate) {
        throw new UnsupportedOperationException("Метод 'update' не реализован");
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Метод 'remove' не реализован");
    }


    private static List<Car> fillTestData() {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < CARS.length; i++) {
            CARS[i].setId(i);
            carList.add(CARS[i]);
        }
        return carList;
    }
}
