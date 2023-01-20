package com.example.gasWaterUsageMonitoring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @NotBlank
    @Size(min = 4, message = "Role name should contain at least 4 symbols")
    private String name;
    //@Transient
    @ManyToMany(mappedBy = "roles", cascade = {CascadeType.ALL})
    @JsonIgnore
    private Set<User> users;

    public Role(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }

}
