package com.pokoemelu.bus.controller;

import com.pokoemelu.bus.model.Bus;
import com.pokoemelu.bus.repository.BusRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus")
public class BusController {
    private final BusRepository repository;

    public BusController(BusRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Bus> getAllBus() {
        return repository.getAllBus();
    }

    @PostMapping
    public ResponseEntity<?> createBus(@RequestBody Bus bus) {
        int result = repository.insertIfNotExists(
                bus.getName(),
                bus.getAgendaId(),
                bus.getCapacity(),
                bus.getNote(),
                bus.getCreateDate()
        );

        if (result == 0) {
            return ResponseEntity
                    .badRequest()
                    .body("Bus with this name and agenda already exists.");
        }

        return ResponseEntity.ok("Bus saved successfully.");
    }
}
