package com.enigma.wms_api.service;

import com.enigma.wms_api.entity.MBranchEntity;

import com.enigma.wms_api.repository.MBranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService{
    @Autowired
    private MBranchRepository branchRepository;
    @Override
    public MBranchEntity create(MBranchEntity branch) {
        return branchRepository.save(branch);
    }

    @Override
    public MBranchEntity update(MBranchEntity branch) {
        MBranchEntity currentBranch = getById(branch.getBranchId());
        if (currentBranch != null){
            return branchRepository.save(branch);
        }
        return null;
    }

    @Override
    public MBranchEntity getById(String id) {
        return branchRepository.findById(id).get();
    }

    @Override
    public MBranchEntity getAll() {
        return null;
    }



    @Override
    public void deleteById(String branch) {

    }
}
