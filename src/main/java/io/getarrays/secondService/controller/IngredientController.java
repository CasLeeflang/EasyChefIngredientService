package io.getarrays.secondService.controller;

import io.getarrays.secondService.Interface.IngredientServiceInterface;
import io.getarrays.secondService.domain.Ingredient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api") @RequiredArgsConstructor
@Slf4j
public class IngredientController {
    private final IngredientServiceInterface ingredientService;

    @GetMapping("/ingredient/{id}")
    public Ingredient getIngredientById(@PathVariable Long id){
        return ingredientService.getIngredientById(id);
    }

    @GetMapping("/ingredient/all")
    public Collection<Ingredient> getAllIngredients() throws SQLException {
        return ingredientService.getIngredients();
    }

    @PostMapping("/ingredient")
    public void saveIngredient(@RequestBody Ingredient ingredient) throws SQLException {
        ingredientService.saveIngredient(ingredient);
    }

    @DeleteMapping("/ingredient/{id}")
    public void deleteIngredientById(@PathVariable Long id){
        ingredientService.deleteIngredientById(id);
    }

    @PutMapping("/ingredient")
    public void updateIngredient(@RequestBody Ingredient updated){
        ingredientService.updateIngredient(updated);
//        updated.update();
    }
}
