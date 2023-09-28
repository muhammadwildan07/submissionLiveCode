package com.enigma.wms_api.controller;

import com.enigma.wms_api.entity.TransactionEntity;
import com.enigma.wms_api.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // CREATE
    @PostMapping
    public ResponseEntity<TransactionEntity> createTransaction(@RequestBody TransactionEntity transaction) {
        TransactionEntity savedTransaction = transactionService.saveTransaction(transaction);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    // READ all
    @GetMapping
    public ResponseEntity<List<TransactionEntity>> getAllTransactions() {
        List<TransactionEntity> transactions = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    // READ by ID
    @GetMapping("/{transactionId}")
    public ResponseEntity<?> getTransactionById(@PathVariable String transactionId) {
        Optional<TransactionEntity> optionalTransaction = transactionService.getTransactionById(transactionId);
        return optionalTransaction.map(transaction -> new ResponseEntity<>(transaction, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity("Transaction not found", HttpStatus.NOT_FOUND));
    }

    // UPDATE
    @PutMapping("/{transactionId}")
    public ResponseEntity<?> updateTransaction(@PathVariable String transactionId, @RequestBody TransactionEntity updatedTransaction) {
        Optional<TransactionEntity> optionalTransaction = transactionService.getTransactionById(transactionId);

        if (optionalTransaction.isPresent()) {
            TransactionEntity existingTransaction = optionalTransaction.get();
            existingTransaction.setTransactionType(updatedTransaction.getTransactionType());
            existingTransaction.setBillDetails(updatedTransaction.getBillDetails());

            TransactionEntity savedTransaction = transactionService.saveTransaction(existingTransaction);
            return new ResponseEntity<>(savedTransaction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Transaction not found", HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/{transactionId}")
    public ResponseEntity<?> deleteTransaction(@PathVariable String transactionId) {
        Optional<TransactionEntity> optionalTransaction = transactionService.getTransactionById(transactionId);

        if (optionalTransaction.isPresent()) {
            transactionService.deleteTransaction(transactionId);
            return new ResponseEntity<>("Transaction deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Transaction not found", HttpStatus.NOT_FOUND);
        }
    }
}
