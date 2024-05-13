package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;


@Repository
public interface CarDao {

    void save(Car car);

    Car get(int id);

    Car[] get();

    void update(Car car);

    void remove(int id);
}
