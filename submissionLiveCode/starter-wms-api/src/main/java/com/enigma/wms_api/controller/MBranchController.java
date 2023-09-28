package com.enigma.wms_api.controller;
import com.enigma.wms_api.entity.MBranchEntity;


import com.enigma.wms_api.repository.MBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/branch")
public class MBranchController {

    @Autowired
    private MBranchRepository branchRepository;

    // CREATE
    @PostMapping
    public ResponseEntity<MBranchEntity> createBranch(@RequestBody MBranchEntity branch) {
        MBranchEntity savedBranch = branchRepository.save(branch);
        return new ResponseEntity<>(savedBranch, HttpStatus.CREATED);
    }

    // READ all
    @GetMapping
    public ResponseEntity<List<MBranchEntity>> getAllBranches() {
        List<MBranchEntity> branches = branchRepository.findAll();
        return new ResponseEntity<>(branches, HttpStatus.OK);
    }

    // READ by ID
    @GetMapping("/{branchId}")
    public ResponseEntity<?> getBranchById(@PathVariable String branchId) {
        Optional<MBranchEntity> optionalBranch = branchRepository.findById(branchId);
        return optionalBranch.map(branch -> new ResponseEntity<>(branch, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity("Branch not found", HttpStatus.NOT_FOUND));
    }

    // UPDATE
    @PutMapping("/{branchId}")
    public ResponseEntity<?> updateBranch(@PathVariable String branchId, @RequestBody MBranchEntity updatedBranch) {
        Optional<MBranchEntity> optionalBranch = branchRepository.findById(branchId);

        if (optionalBranch.isPresent()) {
            MBranchEntity existingBranch = optionalBranch.get();
            existingBranch.setAddress(updatedBranch.getAddress());
            existingBranch.setBranchCode(updatedBranch.getBranchCode());
            existingBranch.setBranchName(updatedBranch.getBranchName());
            existingBranch.setPhoneNumber(updatedBranch.getPhoneNumber());
            existingBranch.setProduct(updatedBranch.getProduct());

            MBranchEntity savedBranch = branchRepository.save(existingBranch);
            return new ResponseEntity<>(savedBranch, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Branch not found", HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/{branchId}")
    public ResponseEntity<?> deleteBranch(@PathVariable String branchId) {
        Optional<MBranchEntity> optionalBranch = branchRepository.findById(branchId);

        if (optionalBranch.isPresent()) {
            branchRepository.deleteById(branchId);
            return new ResponseEntity<>("Branch deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Branch not found", HttpStatus.NOT_FOUND);
        }
    }
}

