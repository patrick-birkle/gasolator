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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@Table(name = "refuels")
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class Refuel {

    public final static String FIELD_ID = "id";
    public final static String FIELD_CAR_ID = "car_id";
    public final static String FIELD_CAR_KILOMETERS = "car_kilometers";
    public final static String FIELD_GAS_STATION = "gas_station";
    public final static String FIELD_GAS_TYPE = "gas_type";
    public final static String FIELD_LITERS = "liters";
    public final static String FIELD_PRICE = "price";
    public final static String FIELD_TIMESTAMP = "timestamp";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = FIELD_ID)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = FIELD_CAR_ID)
    private Car car;

    @Column(name = FIELD_CAR_KILOMETERS)
    private long carKilometers;

    @Column(name = FIELD_GAS_STATION)
    private String gasStation;

    @Column(name = FIELD_GAS_TYPE)
    private String gasType;

    @Column(name = FIELD_LITERS)
    private double liters;

    @Column(name = FIELD_PRICE)
    private double price;

    @Column(name = FIELD_TIMESTAMP)
    private ZonedDateTime timestamp;

}
