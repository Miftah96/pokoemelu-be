package com.pokoemelu.bus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "bus", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "agenda_id"})
})
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "agenda_id")
    private int agendaId;
    private int capacity;
    private String note;
    private LocalDateTime createDate;
}
