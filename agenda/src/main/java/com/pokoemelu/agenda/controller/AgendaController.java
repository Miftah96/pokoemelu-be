package com.pokoemelu.agenda.controller;

import com.pokoemelu.agenda.model.Agenda;
import com.pokoemelu.agenda.repository.AgendaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {
    private final AgendaRepository repository;

    public AgendaController(AgendaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Agenda> getAllAgenda() {
        return repository.getAllAgenda();
    }

    @PostMapping
    public ResponseEntity<?> createAgenda(@RequestBody Agenda agenda) {
        if (repository.existsByName(agenda.getName())) {
            return ResponseEntity.badRequest().body("Agenda name already exists.");
        }

        return ResponseEntity.ok(repository.save(agenda));
    }
}
