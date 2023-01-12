package com.example.gasWaterUsageMonitoring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue
    private UUID id;
    private String login;
    @OneToMany(mappedBy = "user")
    private List<Measurement> measurementList;
}
