package hiber.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {
    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;


    public Car() {

    }

    public Car(int series,String model) {
        this.series = series;
        this.model = model;
    }



    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return series == car.series && Objects.equals(model, car.model) && Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, series, id);
    }
}
