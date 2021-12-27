package io.getarrays.secondService.Interface;


import io.getarrays.secondService.domain.UOM;

import java.util.Collection;


public interface UOMServiceInterface {
    UOM saveUOM(UOM uom);
    UOM getUOM(Long id);
    Collection<UOM> getAllUOM();
    void deleteUOMById(Long id);
}
