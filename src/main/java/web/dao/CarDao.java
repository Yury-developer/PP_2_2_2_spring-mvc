package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;


@Repository
public interface CarDao {

    boolean save(Car car);

    Car get(int id);

    Car[] getSeveral(int start, int end);

    Car update(int id, Car car);

    boolean remove(int id);

    int getSize();
}
