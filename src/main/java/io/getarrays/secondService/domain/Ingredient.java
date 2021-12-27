package io.getarrays.secondService.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.math.BigDecimal;
import java.math.MathContext;

import static javax.persistence.GenerationType.IDENTITY;


@Entity @Data @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ingredient{

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String ingredientName;
    private BigDecimal price;
    private BigDecimal sellByQty;
    private Long UOM_id;
    private BigDecimal ISO_price;

    public void calculateISO_price(UOM uom){
        this.setISO_price((this.price).divide((this.sellByQty.multiply(uom.getFactor(), MathContext.DECIMAL32)), MathContext.DECIMAL32));
    }

}
