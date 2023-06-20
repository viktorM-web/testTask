package org.example.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "car")
public class Car implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String vinCode;
    private String brand;
    private String model;
    private Integer yearIssue;
    private String colour;
    private Integer seatsQuantity;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "garage_id")
    private Garage garage;
}
