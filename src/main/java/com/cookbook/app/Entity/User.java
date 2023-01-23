package com.cookbook.app.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "_user")
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String email;
    @OneToMany
    private Set<Recipe> recipes;

}
