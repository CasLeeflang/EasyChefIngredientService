package io.getarrays.secondService.repo;


import io.getarrays.secondService.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface IngredientRepo extends JpaRepository<Ingredient, Long> {

    @Modifying
    @Query("update Ingredient I set I.ingredientName = :ingredientName, I.price = :price, I.sellByQty = :sellByQty, I.UOM_id = :UOM_id, I.ISO_price = :ISO_price where I.id = :id")
    void updateIngredientName(
            @Param(value = "id") Long id,
            @Param(value = "ingredientName") String ingredientName,
            @Param(value = "price") BigDecimal price,
            @Param(value = "sellByQty") BigDecimal sellByQty,
            @Param(value = "UOM_id") Long UOM_id ,
            @Param(value = "ISO_price") BigDecimal ISO_price
    );

}
