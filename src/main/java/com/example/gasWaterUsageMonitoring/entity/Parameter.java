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
    @Transient
    @OneToMany(mappedBy = "parameter")
    @JsonIgnore
    private List<Measurement> measurementList;

    public Parameter(String name) {
        this.name = name;
    }
}
