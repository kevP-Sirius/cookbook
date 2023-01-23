package com.cookbook.app.Service.Ingredient;

import com.cookbook.app.Entity.Ingredient;
import com.cookbook.app.Repository.IngredientRepository;

import java.util.List;

public class IngredientService implements IIngredientService{
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> findAll(){
        return ingredientRepository.findAll();
    }

    public Ingredient createRecipe(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public boolean deleteRecipe(Ingredient ingredient){
        ingredientRepository.delete(ingredient);

        return true;
    }
}
