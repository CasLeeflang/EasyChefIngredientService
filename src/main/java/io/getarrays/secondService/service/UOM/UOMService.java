package io.getarrays.secondService.service.UOM;

import io.getarrays.secondService.Interface.UOMServiceInterface;
import io.getarrays.secondService.repo.UOMRepo;
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
public class UOMService implements UOMServiceInterface {
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
