package com.hexagon.paymentservice.controller;

import com.hexagon.schoolservice.dal.entity.InvoiceEntity;
import com.hexagon.schoolservice.dal.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
public class InvoiceRest {

    private final InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<InvoiceEntity> create(@RequestBody InvoiceEntity inv) {
        InvoiceEntity saved = invoiceService.create(inv);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InvoiceEntity>> read(){
        return ResponseEntity.ok(invoiceService.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceEntity> findById(@PathVariable Long id) {
        InvoiceEntity invoiceEntity = invoiceService.findById(id);
        return ResponseEntity.ok(invoiceEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceEntity> update(@RequestBody InvoiceEntity inv, @PathVariable Long id) {
        InvoiceEntity updated = invoiceService.update(inv, id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        invoiceService.delete(id);
        return ResponseEntity.ok("Invoice with id: " + id + " was deleted!");
    }
}