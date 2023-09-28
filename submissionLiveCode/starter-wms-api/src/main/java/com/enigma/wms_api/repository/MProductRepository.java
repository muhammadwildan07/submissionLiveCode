package com.enigma.wms_api.repository;

import com.enigma.wms_api.entity.MProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MProductRepository extends JpaRepository<MProductEntity, String> {
}
