package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.stream.IntStream;


@Service
public class CarServiceImpl implements CarService {

    @Autowired
    public CarDao carDao;


    @Override
    public void save(Car car) {
        carDao.save(car);
    }

    @Override
    public Car[] get(int count) {
        int size = carDao.get().length;
        Car[] cars;
        if (count >= 1 && count <= 5) {
            size = Math.min(size, count); // минимальное между запрошенным и реально существующим кол-вом машин
            cars = IntStream.range(0, size)
                    .mapToObj(i -> carDao.get()[i])
                    .toArray(Car[]::new);
        } else {
            cars = carDao.get();
        }
        return cars;
    }

    @Override
    public void update(Car car) {
        carDao.update(car);
    }

    @Override
    public void remove(int id) {
        carDao.remove(id);
    }
}
