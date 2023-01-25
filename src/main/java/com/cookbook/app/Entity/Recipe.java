package com.cookbook.app.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Long id;
    private String name;
    private String description;
    private String instructions;
    private int rate;
    @OneToMany
    private Set<Ingredient> ingredients;
    @OneToMany
    private Set<Comment> comments;

}
