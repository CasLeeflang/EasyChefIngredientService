package io.getarrays.secondService.Interface;

import io.getarrays.secondService.logic.ingredient.Ingredient;

import java.util.Collection;

public interface IngredientCollectionInterface {
    Collection<Ingredient> getIngredients();
    Ingredient saveIngredient(Ingredient ingredient);
    Ingredient getIngredientById(Long id);
    void deleteIngredientById(Long id);
    void updateIngredient(Ingredient ingredient);
}
