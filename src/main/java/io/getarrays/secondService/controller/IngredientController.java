package io.getarrays.secondService.controller;

import io.getarrays.secondService.Interface.IngredientCollectionInterface;
import io.getarrays.secondService.logic.ingredient.Ingredient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collection;

@RestController
@RequestMapping("/api") @RequiredArgsConstructor
@Slf4j
public class IngredientController {
    private final IngredientCollectionInterface ingredientCollection;

    @GetMapping("/ingredient/{id}")
    public Ingredient getIngredientById(@PathVariable Long id){
        return ingredientCollection.getIngredientById(id);
    }

    @GetMapping("/ingredient/all")
    public Collection<Ingredient> getAllIngredients() throws SQLException {
        return ingredientCollection.getIngredients();
    }

    @PostMapping("/ingredient")
    public void saveIngredient(@RequestBody Ingredient ingredient) throws SQLException {
        ingredientCollection.saveIngredient(ingredient);
    }

    @DeleteMapping("/ingredient/{id}")
    public void deleteIngredientById(@PathVariable Long id){
        ingredientCollection.deleteIngredientById(id);
    }

    @PutMapping("/ingredient")
    public void updateIngredient(@RequestBody Ingredient updated){
        ingredientCollection.updateIngredient(updated);
//        updated.update();
    }
}
