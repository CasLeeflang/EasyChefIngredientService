package io.getarrays.secondService.service.ingredient;

import io.getarrays.secondService.Interface.IngredientServiceInterface;
import io.getarrays.secondService.repo.IngredientRepo;
import io.getarrays.secondService.repo.UOMRepo;
import io.getarrays.secondService.domain.Ingredient;
import io.getarrays.secondService.domain.UOM;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class IngredientService implements IngredientServiceInterface {
    private final IngredientRepo ingredientRepo;
    private final UOMRepo uomRepo;

    @Override
    public Collection<Ingredient> getIngredients() {

        return ingredientRepo.findAll();
    }

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        UOM uom = uomRepo.getById(ingredient.getUOM_id());
        ingredient.calculateISO_price(uom);
        return ingredientRepo.save(ingredient);
    }

    @Override
    public Ingredient getIngredientById(Long id) {
        return ingredientRepo.getById(id);
    }

    @Override
    public void deleteIngredientById(Long id) {
        ingredientRepo.deleteById(id);
    }

    public void updateIngredient(Ingredient updated){
        ingredientRepo.updateIngredientName(updated.getId(), updated.getIngredientName(), updated.getPrice(), updated.getSellByQty(), updated.getUOM_id(), updated.getISO_price());
    }
}
