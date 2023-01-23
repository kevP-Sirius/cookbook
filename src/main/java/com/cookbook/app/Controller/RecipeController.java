package com.cookbook.app.Controller;

import com.cookbook.app.Entity.Recipe;
import com.cookbook.app.Service.Recipe.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class RecipeController {
private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/all")
    public ModelAndView getAllRecipePage(ModelAndView mav) {
        List<Recipe> recipes = recipeService.findAll();
        mav.addObject("recipe_list",recipes );
        mav.setViewName("recipe_list");
        return mav;
    }
    @PostMapping("/recipe/create")
    public ModelAndView createRecipePage(ModelAndView mav) {
//        mav.addObject("formData", formData);
        mav.setViewName("recipe_create");
        return mav;
    }
    @PostMapping("/recipe/update")
    public ModelAndView updateRecipePage(ModelAndView mav) {
//        mav.addObject("formData", formData);
        mav.setViewName("recipe_list");
        return mav;
    }
    @PostMapping("/recipe/delete")
    public ModelAndView deleteRecipePage(ModelAndView mav) {
//        mav.addObject("formData", formData);
        mav.setViewName("recipe_list");
        return mav;
    }

}


