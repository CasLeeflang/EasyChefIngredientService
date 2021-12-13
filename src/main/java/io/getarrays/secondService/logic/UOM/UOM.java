package io.getarrays.secondService.logic.UOM;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;


@Entity @Data
@NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UOM {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String UOM;
    private String UOM_Text;
    private BigDecimal factor;
    private String ISO_UOM;

}
