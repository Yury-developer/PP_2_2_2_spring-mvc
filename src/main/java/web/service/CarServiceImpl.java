package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;


@Service
public class CarServiceImpl implements CarService {

    @Autowired
    public CarDao carDao;


    @Override
    public String ping() {
        return "Welcome to Car Controller!";
    }

    @Override
    public boolean save(Car car) {
        return carDao.save(car);
    }

    @Override
    public Car get(int id) {
        return carDao.get(id);
    }

    @Override
    public Car[] getSeveral(int count) {
        int size;
        if (count >= 1 && count <= 4) {
            size = Math.min(count, carDao.getSize()); // минимальное между запрошенным и реально существующим
        } else {
            size = carDao.getSize();
        }
        return carDao.getSeveral(0, size);
    }

    @Override
    public Car update(int id, Car car) {
        return carDao.update(id, car);
    }

    @Override
    public boolean remove(int id) {
        return carDao.remove(id);
    }
}
