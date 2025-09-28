package com.hexagon.paymentservice.controller;

import com.hexagon.paymentservice.model.Refund;
import com.hexagon.paymentservice.service.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/refunds")
@RequiredArgsConstructor
public class RefundController {

    private final RefundService refundService;

    @PostMapping
    public ResponseEntity<Refund> create(@RequestBody Refund refund) {
        Refund created = refundService.create(refund);
        return ResponseEntity.created(URI.create("/api/v1/refunds/" + created.getId())).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Refund> getById(@PathVariable Long id) {
        return refundService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Refund>> getAll() {
        return ResponseEntity.ok(refundService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Refund> update(@PathVariable Long id, @RequestBody Refund refund) {
        Refund updated = refundService.update(id, refund);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        refundService.delete(id);
    }
}


