package com.cookbook.app.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeDto {
    String name;
    String description;
    IngredientDto[] ingredients;

}
