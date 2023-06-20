package org.example.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "garage")
public class Garage implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String city;
    private String street;
    private String building;
    private Integer capacity;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "garage")
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
        car.setGarage(this);
    }
}
