package com.example.gasWaterUsageMonitoring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Measurement {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "parameterValue")
    private double value;

    private Date date;
    @ManyToOne
    @JoinColumn(name = "parameterName")
    private Parameter parameter;
    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;
}
