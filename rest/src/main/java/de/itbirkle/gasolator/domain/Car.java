package de.itbirkle.gasolator.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class Car {

    public final static String FIELD_ID = "id";
    public final static String FIELD_NAME = "name";
    public final static String FIELD_DESCRIPTION = "description";
    public final static String FIELD_KILOMETERS = "kilometers";
    public final static String FIELD_COLOR = "color";
    public final static String FIELD_BRAND = "brand";
    public final static String FIELD_MODEL = "model";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = FIELD_ID)
    private long id;

    @Column(name = FIELD_NAME)
    private String name;

    @Column(name = FIELD_DESCRIPTION)
    private String description;

    @Column(name = FIELD_KILOMETERS)
    private long kilometers;

    @Column(name = FIELD_COLOR)
    private String color;

    @Column(name = FIELD_BRAND)
    private String brand;

    @Column(name = FIELD_MODEL)
    private String model;

}