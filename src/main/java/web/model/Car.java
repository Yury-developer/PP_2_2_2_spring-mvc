package web.model;
import javax.persistence.*;


@Entity
//@Table(name = "cars")
public class Car {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_car", updatable = false, nullable = false) // имя калонки:"id";  поле не может быть обновлено при выполнении операции обновления (UPDATE) в базе данных; не может содержать значение NULL
    private int id;

//    @Column(name = "model", length = 30, nullable = false)
    private String model;

//    @Column(name = "series")
    private int series;

//    @Column(name = "color", length = 15)
    private String color;


    public Car() {}

    public Car(String model, int series, String color) {
        this.model = model;
        this.series = series;
        this.color = color;
    }

    public Car(Car car) {
        this(car.model, car.series, car.color);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                ", color='" + color + '\'' +
                "}";
    }
}
