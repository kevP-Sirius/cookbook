package com.cookbook.app;
import com.cookbook.app.Dto.IngredientDto;
import com.cookbook.app.Dto.RecipeUpdateDto;
import com.cookbook.app.Entity.Ingredient;
import com.cookbook.app.Entity.Recipe;
import com.cookbook.app.Repository.RecipeRepository;
import com.cookbook.app.Service.Recipe.RecipeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RecipeTest {
    @Mock
    private RecipeRepository recipeRepository;
    @InjectMocks
    private RecipeService recipeService;


    @Test
    public void testRecipe() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setName("test");
        recipe.setDescription("test");
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setName("test");
        ingredient.setQuantity(1);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        recipe.setIngredients(new HashSet<>(ingredients));
        RecipeUpdateDto RecipeUpdateDto = new RecipeUpdateDto();
        RecipeUpdateDto.setId(1L);
        RecipeUpdateDto.setName("test");
        RecipeUpdateDto.setDescription("test");
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setName("test");
        ingredientDto.setQuantity(1);
        RecipeUpdateDto.setIngredients(new IngredientDto[]{ingredientDto});
        Boolean newRecipe = recipeService.updateRecipe(RecipeUpdateDto);

        assertTrue(newRecipe);
    }

    @Test
    public void test2 (){
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Recipe recipeDAO = new Recipe();
        recipeDAO.setId(1L);
        recipeDAO.setName("Old Recipe Name");
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipeDAO));
        boolean result = recipeService.updateRecipe(recipe);
        assertTrue(result);
    }

}

