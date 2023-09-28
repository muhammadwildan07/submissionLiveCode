package com.enigma.wms_api.repository;


import com.enigma.wms_api.entity.MBranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MBranchRepository extends JpaRepository<MBranchEntity, String > {

}
