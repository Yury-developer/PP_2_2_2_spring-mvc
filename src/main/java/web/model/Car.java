package web.model;
import javax.persistence.*;


@Entity
//@Table(name = "cars")
public class Car {
    @Id
    private int id;

    private String model;

    private int series;

    private String color;


    public Car() {}

    public Car(String model, int series, String color) {
        this.model = model;
        this.series = series;
        this.color = color;
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
