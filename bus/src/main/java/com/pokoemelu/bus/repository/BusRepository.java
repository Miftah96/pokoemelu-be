package com.pokoemelu.bus.repository;

import com.pokoemelu.bus.model.Bus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

    @Query(value = "SELECT * FROM bus ", nativeQuery = true)
    List<Bus> getAllBus();

    @Modifying
    @Transactional
    @Query(value = """
        INSERT INTO bus (name, agenda_id, capacity, note, create_date)
        SELECT :name, :agendaId, :capacity, :note, :createDate
        WHERE NOT EXISTS (
            SELECT 1 FROM bus WHERE name = :name AND agenda_id = :agendaId
        )
        """, nativeQuery = true)
    int insertIfNotExists(
            @Param("name") String name,
            @Param("agendaId") int agendaId,
            @Param("capacity") int capacity,
            @Param("note") String note,
            @Param("createDate") LocalDateTime createDate
    );

    boolean existsByName(String name);

}
