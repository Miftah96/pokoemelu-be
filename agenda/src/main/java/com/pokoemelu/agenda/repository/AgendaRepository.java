package com.pokoemelu.agenda.repository;

import com.pokoemelu.agenda.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    @Query(value = "SELECT * FROM agenda ", nativeQuery = true)
    List<Agenda> getAllAgenda();

    boolean existsByName(String name);

}
