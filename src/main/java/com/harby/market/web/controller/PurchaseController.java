package com.harby.market.web.controller;

import com.harby.market.domain.Purchase;
import com.harby.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{clientid}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("clientid") String cliendId) {
        return ResponseEntity.of(purchaseService.getByClient(cliendId));
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<List<Purchase>> getByState(@PathVariable("state") String state) {
        return ResponseEntity.of(purchaseService.getByState(state));
    }

    @PostMapping("/save")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}
