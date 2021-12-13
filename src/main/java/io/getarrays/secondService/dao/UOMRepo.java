package io.getarrays.secondService.dao;

import io.getarrays.secondService.logic.UOM.UOM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UOMRepo extends JpaRepository<UOM, Long> {
}
