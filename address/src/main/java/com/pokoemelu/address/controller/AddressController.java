package com.pokoemelu.address.controller;

import com.pokoemelu.address.model.Address;
import com.pokoemelu.address.repository.AddressRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressRepository repository;

    public AddressController(AddressRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Address> getAllAddress() {
        return repository.getAllAddress();
    }

    @PostMapping
    public ResponseEntity<?> createAddress(@RequestBody Address address) {
        return ResponseEntity.ok(repository.save(address));
    }
}
