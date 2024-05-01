package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class CarDaoImplArrayList implements CarDao, Constants {

    private List<Car> carList;


    public CarDaoImplArrayList() {
        fillTestData();
        printCars(carList.toArray(Car[]::new));
    }


    @Override
    public boolean save(Car car) {
        boolean isSaved = carList.add(car);
        return isSaved;
    }


    @Override
    public Car get(int id) {
        return carList.stream()
                .filter(car -> car.getId() == id)
                .findFirst()
                .orElse(null); // в оригинале было findAny вместо findFirst
    }

    @Override
    public Car[] getSeveral(int start, int end) {
        return Arrays.copyOfRange(carList.toArray(Car[]::new), start, end);
    }

    @Override
    public Car update(int id, Car carUpdate) {
        Car carToBeUpdated = get(id);
        Car outdatedCar = new Car(carToBeUpdated);
        if (carToBeUpdated != null) {
            carToBeUpdated.setModel(carUpdate.getModel());
            carToBeUpdated.setSeries(carUpdate.getSeries());
            carToBeUpdated.setColor(carUpdate.getColor());
        }
        return outdatedCar;
    }

    @Override
    public boolean remove(int id) {
        boolean isRemoved = carList.removeIf(car -> car.getId() == id);
        return isRemoved;
    }

    @Override
    public int getSize() {
        return carList.size();
    }

    private void fillTestData() {
        carList = new ArrayList<>();
        for (int i = 0; i < CARS.length; i++) {
            CARS[i].setId(i);
            carList.add(CARS[i]);
        }
    }
}
