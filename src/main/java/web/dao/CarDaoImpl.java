package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class CarDaoImpl implements CarDao {

    private List<Car> carList;


    private int size;

    public CarDaoImpl() {
        carList = new ArrayList<>();
        this.save(new Car("Mers МЭРС ммм", 111, "red красный"));
        this.save(new Car("Lexus ЛЕКСУС", 222, "orange"));
        this.save(new Car("BMW БМВ", 333, "green"));
        this.save(new Car("Lada ЛАДА", 444, "blue"));
        this.save(new Car("Oka ОКА", 555, "violet"));
        carList.stream().forEach(System.out::println);
    }


    @Override
    public boolean save(Car car) {
        boolean isSaved = carList.add(car);
        if (isSaved) {
            car.setId(size++);
        }
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
        if (isRemoved) {
            size--;
        }
        return isRemoved;
    }


    public int getSize() {
        return size;
    }
}
