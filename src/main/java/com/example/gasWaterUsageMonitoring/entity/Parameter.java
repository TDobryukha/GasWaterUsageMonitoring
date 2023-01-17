package com.example.gasWaterUsageMonitoring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "parameter")
    private List<Measurement> measurementList;
}
