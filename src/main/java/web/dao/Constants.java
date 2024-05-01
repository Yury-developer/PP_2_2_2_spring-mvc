package web.dao;

import web.model.Car;


public interface Constants {

    Car[] CARS = {
            new Car("Mercedes 'Мерседес'", 101, "White 'белый'"),
            new Car("Lexus 'ЛЕКСУС'", 202, "Red 'красный'"),
            new Car("BMW DCT'БМВ'", 303, "Yellow 'желтый'"),
            new Car("Chevrolet 'Шевроле'", 404, "Orange 'оранжевый'"),
            new Car("Hyundai 'Хундай'", 505, "Green 'зеленый'"),
            new Car("KIA 'Киа'", 606, "Blue 'синий'"),
            new Car("Mazda 'Мазда'", 707, "Purple 'фиолетовый'"),
            new Car("Nissan 'Нисан'", 808, "Pink 'розовый'"),
            new Car("Opel 'Опель'", 909, "Brown 'коричневый'"),
            new Car("Peugeot 'Пежо'", 110, "Grey/gray 'серый'")
    };

    default void printCars(Car... cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}








