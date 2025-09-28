package com.hexagon.paymentservice.controller;

import com.hexagon.paymentservice.model.Payout;
import com.hexagon.paymentservice.service.PayoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/payouts")
@RequiredArgsConstructor
public class PayoutController {

    private final PayoutService payoutService;

    @PostMapping
    public ResponseEntity<Payout> create(@RequestBody Payout payout) {
        Payout created = payoutService.create(payout);
        return ResponseEntity.created(URI.create("/api/v1/payouts/" + created.getId())).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payout> getById(@PathVariable Long id) {
        return payoutService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Payout>> getAll() {
        return ResponseEntity.ok(payoutService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payout> update(@PathVariable Long id, @RequestBody Payout payout) {
        Payout updated = payoutService.update(id, payout);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        payoutService.delete(id);
    }
}


