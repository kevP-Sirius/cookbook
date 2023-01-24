package com.cookbook.app.Service.Recipe;

import com.cookbook.app.Entity.Recipe;
import com.cookbook.app.Repository.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService implements IRecipeService{

    public final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> findAll(){
        return recipeRepository.findAll();
    }

    public Recipe createRecipe(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    public boolean deleteRecipe(Long id){
        recipeRepository.deleteById(id);

        return true;
    }

    @Transactional
    public boolean updateRecipe(Recipe recipe){
        Recipe recipe1 = recipeRepository.findById(recipe.getId()).orElseThrow(() -> {
            throw  new IllegalStateException("Recipe does not exist");
        });

        recipe1 = recipe;

        return true;
    }
}
