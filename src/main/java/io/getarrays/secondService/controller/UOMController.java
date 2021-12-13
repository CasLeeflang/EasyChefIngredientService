package io.getarrays.secondService.controller;

import io.getarrays.secondService.logic.UOM.UOM;
import io.getarrays.secondService.logic.UOM.UOMService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api") @RequiredArgsConstructor
@Slf4j
public class UOMController {
    private final UOMService uomCollection;

    @PostMapping("/uom")
    public void saveUOM(UOM uom){
        uomCollection.saveUOM(uom);
    }

    @GetMapping("/uom")
    public Collection<UOM> getUOM(){
        return uomCollection.getAllUOM();
    }
}
