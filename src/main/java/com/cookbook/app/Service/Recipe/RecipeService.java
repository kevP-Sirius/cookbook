package com.cookbook.app.Service.Recipe;

import com.cookbook.app.Dto.RecipeUpdateDto;
import com.cookbook.app.Entity.Ingredient;
import com.cookbook.app.Entity.Recipe;
import com.cookbook.app.Repository.RecipeRepository;
import com.cookbook.app.Service.Ingredient.IngredientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class RecipeService implements IRecipeService{

    public final RecipeRepository recipeRepository;
    private final IngredientService ingredientService;
    public RecipeService(RecipeRepository recipeRepository, IngredientService ingredientService) {
        this.recipeRepository = recipeRepository;
        this.ingredientService = ingredientService;
    }


    public List<Recipe> findAll(){
        return recipeRepository.findAll();
    }

    public Recipe findById(Long id) {
        return recipeRepository.findById(id).orElseThrow();
    }

    public Recipe createRecipe(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    public boolean deleteRecipe(Long id){
        recipeRepository.deleteById(id);

        return true;
    }

    public boolean updateRecipe(RecipeUpdateDto formData){

        Recipe recipe = new Recipe();
        recipe.setId(formData.getId());
        recipe.setName(formData.getName());
        recipe.setDescription(formData.getDescription());
        List<Ingredient> ingredientList = Arrays.stream(formData.getIngredients()).map(ingredientDto -> {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(ingredientDto.getName());
            ingredient.setQuantity(ingredientDto.getQuantity());
            ingredientService.createIngredient(ingredient);
            return ingredient;
        }).toList();
        recipe.setIngredients(new HashSet<>(ingredientList));
        Recipe recipeDAO = recipeRepository.findById(recipe.getId()).orElseThrow(() -> {
            throw  new IllegalStateException("Recipe does not exist");
        });

        try {
            new ModelMapper().map(recipe, recipeDAO);
            recipeRepository.save(recipe);
            return true;
        }catch (IllegalStateException e){
            throw e;
        }
    }
}
