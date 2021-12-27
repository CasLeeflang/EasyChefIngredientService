package io.getarrays.secondService.Interface;

import io.getarrays.secondService.domain.Ingredient;

import java.util.Collection;

public interface IngredientServiceInterface {
    Collection<Ingredient> getIngredients();
    Ingredient saveIngredient(Ingredient ingredient);
    Ingredient getIngredientById(Long id);
    void deleteIngredientById(Long id);
    void updateIngredient(Ingredient ingredient);
}
