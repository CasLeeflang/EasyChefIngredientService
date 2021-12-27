package io.getarrays.secondService.controller;

import io.getarrays.secondService.domain.UOM;
import io.getarrays.secondService.service.UOM.UOMService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:8081")
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
