package io.getarrays.secondService.logic.UOM;

import io.getarrays.secondService.Interface.UOMCollectionInterface;
import io.getarrays.secondService.dao.UOMRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UOMService implements UOMCollectionInterface {
    private final UOMRepo uomRepo;

    @Override
    public Collection<UOM> getAllUOM() {
        return uomRepo.findAll();
    }

    @Override
    public UOM saveUOM(UOM uom) {
        return uomRepo.save(uom);
    }

    @Override
    public UOM getUOM(Long id) {
        return uomRepo.getById(id);
    }

    @Override
    public void deleteUOMById(Long id) {
        uomRepo.deleteById(id);
    }
}
