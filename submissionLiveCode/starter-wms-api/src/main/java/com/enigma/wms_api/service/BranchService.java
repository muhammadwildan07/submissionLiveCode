package com.enigma.wms_api.service;

import com.enigma.wms_api.entity.MBranchEntity;


public interface BranchService {
    MBranchEntity create(MBranchEntity branch);
    MBranchEntity update(MBranchEntity branch);
    MBranchEntity getById(String branch);
    MBranchEntity getAll();


    void deleteById(String branch);
}
