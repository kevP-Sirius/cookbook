package com.cookbook.app.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Recipe {
    @Id
    Long id;
    private String name;
    private String description;
    private String instructions;
    @ManyToOne
    private Ingredient ingredients;
    @ManyToOne
    private Comment comments;

}
