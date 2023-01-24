package com.example.gasWaterUsageMonitoring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "parameterName")
    @NotNull(message = "Enter measurements parameter name")
    private Parameter parameter;

    @Column(name = "parameterValue")
    @Positive
    private double value;

    @UpdateTimestamp
    private Date date;

}
