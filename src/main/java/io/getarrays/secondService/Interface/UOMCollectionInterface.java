package io.getarrays.secondService.Interface;


import io.getarrays.secondService.logic.UOM.UOM;

import java.util.Collection;


public interface UOMCollectionInterface {
    UOM saveUOM(UOM uom);
    UOM getUOM(Long id);
    Collection<UOM> getAllUOM();
    void deleteUOMById(Long id);
}
