package hiber.model;

import javax.persistence.*;

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

    public Car(int series,String model) {
    this.series = series;
    this.model = model;
    }

    public Car() {

    }

    public String getModel () {
        return model;
    }
    public int getSeries () {
        return series;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                ", id=" + id +
                '}';
    }
}
