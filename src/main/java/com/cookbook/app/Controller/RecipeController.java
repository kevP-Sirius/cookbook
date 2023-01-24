package com.cookbook.app.Controller;

import com.cookbook.app.Dto.RecipeDto;
import com.cookbook.app.Entity.Ingredient;
import com.cookbook.app.Entity.Recipe;
import com.cookbook.app.Repository.IngredientRepository;
import com.cookbook.app.Repository.RecipeRepository;
import com.cookbook.app.Service.Ingredient.IngredientService;
import com.cookbook.app.Service.Recipe.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
public class RecipeController {
private final RecipeService recipeService;
private final IngredientService ingredientService;

    public RecipeController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @GetMapping("/recipe/all")
    public ModelAndView getAllRecipePage(ModelAndView mav) {
        List<Recipe> recipes = recipeService.findAll();
        mav.addObject("recipe_list",recipes );
        mav.setViewName("recipe_list");
        return mav;
    }
    @PostMapping("/recipe/create")
    public ModelAndView handleCreateRecipePage(ModelAndView mav, @RequestBody RecipeDto formData) {
        Recipe recipe = new Recipe();
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
        recipeService.createRecipe(recipe);
        List<Recipe> recipes = recipeService.findAll();
        mav.addObject("recipe_list",recipes );
        mav.setViewName("recipe_list");
        return mav;
    }
    @GetMapping("/recipe/create")
    public ModelAndView createRecipePage(ModelAndView mav) {
        mav.setViewName("recipe_create");
        return mav;
    }
    @PostMapping("/recipe/update")
    public ModelAndView updateRecipePage(ModelAndView mav) {
        mav.setViewName("recipe_list");
        return mav;
    }
    @GetMapping("/recipe/delete/{id}")
    public ModelAndView deleteRecipePage(ModelAndView mav,@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        List<Recipe> recipes = recipeService.findAll();
        mav.addObject("recipe_list",recipes );
        mav.setViewName("recipe_list");
        return mav;
    }

}


