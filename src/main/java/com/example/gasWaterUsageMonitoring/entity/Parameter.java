package com.example.gasWaterUsageMonitoring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Parameter {
    @Id
    // @GeneratedValue
    private String name;
    @OneToMany(mappedBy = "parameter")
    private List<Measurement> measurementList;
}
