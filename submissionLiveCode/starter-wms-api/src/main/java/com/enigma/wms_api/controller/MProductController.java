package com.enigma.wms_api.controller;


import com.enigma.wms_api.entity.MProductEntity;
import com.enigma.wms_api.repository.MProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class MProductController {

    @Autowired
    private MProductRepository productRepository;

    // CREATE
    @PostMapping
    //todo 1 : ResponseEntity used to create response from user request and the generic type is
    // declarated with Entity Class that request mapped

    public ResponseEntity<MProductEntity> createProduct(@RequestBody MProductEntity product) {
//todo 2 :      @RequestBody is meaning for request body  that included as a request todo
        MProductEntity savedProduct = productRepository.save(product);
//todo 3 : in this case you send object ftom Entity to product repository to be saved at database with jpa feature
// by methode save which present at product repo
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // READ all
    @GetMapping
    public ResponseEntity<List<MProductEntity>> getAllProducts() {
        List<MProductEntity> products = productRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // READ by ID
    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable String productId) {
        Optional<MProductEntity> optionalProduct = productRepository.findById(productId);
        return optionalProduct.map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity("Product not found", HttpStatus.NOT_FOUND));
    }

    // UPDATE
    @PutMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable String productId, @RequestBody MProductEntity updatedProduct) {
        Optional<MProductEntity> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            MProductEntity existingProduct = optionalProduct.get();
            existingProduct.setProductPriceId(updatedProduct.getProductPriceId());
            existingProduct.setProductCode(updatedProduct.getProductCode());
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setBranchId(updatedProduct.getBranchId());
            existingProduct.setMBranch(updatedProduct.getMBranch());
            existingProduct.setBill(updatedProduct.getBill());

            MProductEntity savedProduct = productRepository.save(existingProduct);
            return new ResponseEntity<>(savedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productId) {
        Optional<MProductEntity> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            productRepository.deleteById(productId);
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }
}
