package com.cookbook.app.Entity;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@NoArgsConstructor
public class Recipe {
    @Id
    Long id;
    private String name;
    private String description;
    private String instructions;
    @ManyToOne
    private Ingredients ingredients;
    @ManyToOne
    private Comments comments;

}
