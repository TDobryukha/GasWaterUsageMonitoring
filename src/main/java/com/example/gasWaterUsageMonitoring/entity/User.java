package com.example.gasWaterUsageMonitoring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @NotBlank
    @Size(min = 4, message = "Login should contain at least 4 symbols")
    private String login;
    private String password;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Measurement> measurementList;
}
