package com.cookbook.app.Entity;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String email;
    @ManyToOne
    private List<Recipe> recipes;
}
