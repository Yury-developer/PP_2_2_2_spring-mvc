package web.dao;

import web.model.Car;

import java.util.Arrays;


public interface Constants {

    Car[] CARS = {
            new Car("Peugeot   'Пежо'", 000, "Grey/gray   'серый'"),
            new Car("Mercedes   'Мерседес'", 111, "White   'белый'"),
            new Car("Lexus   'ЛЕКСУС'", 222, "Red   'красный'"),
            new Car("BMW DCT   'БМВ'", 333, "Yellow   'желтый'"),
            new Car("Chevrolet   'Шевроле'", 444, "Orange   'оранжевый'"),
            new Car("Hyundai   'Хундай'", 555, "Green   'зеленый'"),
            new Car("KIA   'Киа'", 666, "Blue   'синий'"),
            new Car("Mazda   'Мазда'", 777, "Purple   'фиолетовый'"),
            new Car("Nissan   'Нисан'", 888, "Pink   'розовый'"),
            new Car("Opel   'Опель'", 999, "Brown   'коричневый'")
    };

    default void printCars(Car... cars) {
        Arrays.stream(CARS).forEach(System.out::println);
    }
}








