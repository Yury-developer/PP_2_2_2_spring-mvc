package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.Arrays;


@Service
public class CarServiceImpl implements CarService {

    @Autowired
    public CarDao carDao;

    @Override
    public String ping() {
        System.out.println("CarServiceImpl: ping");

        return "Welcome to Car Controller!";
    }

    @Override
    public boolean save(Car car) {
        System.out.println("CarServiceImpl: save");

        return carDao.save(car);
    }

    @Override
    public Car get(int id) {
        System.out.println("CarServiceImpl: get (id=" + id + ")");
        System.out.println(carDao.get(id));

        return carDao.get(id);
    }

    @Override
    public Car[] getSeveral(int count) {  // согласно задания - выводим запрошенное количество машин
        System.out.println("CarServiceImpl: getSeveral"); // УДАЛИТЬ потом

        int size;
        if (count >= 1 && count <= 4) {
            size = Math.min(count, carDao.getSize()); // минимальное между запрошенным и реально существующим
        } else {
            size = carDao.getSize();
        }
        Arrays.stream(carDao.getSeveral(0, size)).forEach(System.out::println); // УДАЛИТЬ потом
        return carDao.getSeveral(0, size);
    }

    @Override
    public Car update(int id, Car car) {
        System.out.println("CarServiceImpl: update"); // УДАЛИТЬ потом
        System.out.println("id = " + id + "; car = " + car); // УДАЛИТЬ потом

        return carDao.update(id, car);
    }

    @Override
    public boolean remove(int id) {
        System.out.println("CarServiceImpl: remove"); // УДАЛИТЬ потом
        System.out.println("id = " + id); // УДАЛИТЬ потом

        return carDao.remove(id);
    }
}
