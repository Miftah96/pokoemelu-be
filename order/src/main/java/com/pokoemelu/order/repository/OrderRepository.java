package com.pokoemelu.order.repository;

import com.pokoemelu.order.model.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT * FROM order ", nativeQuery = true)
    List<Order> getAllOrder();

    @Query(value = "SELECT " +
            "o.id AS order_id, o.status, o.set_number, o.trx_date, " +
            "b.id AS bus_id, b.name AS bus_name, " +
            "m.id AS member_id, m.name AS member_name " +
            "FROM `orders` o " +
            "JOIN bus b ON b.id = o.bus_id " +
            "JOIN member m ON m.id = o.member_id", nativeQuery = true)
    List<Object[]> getAllOrderWithDetails();

    @Modifying
    @Transactional
    @Query(value = """
        INSERT INTO orders (name, agenda_id, capacity, note, create_date)
        SELECT :name, :agendaId, :capacity, :note, :createDate
        WHERE NOT EXISTS (
            SELECT 1 FROM order WHERE name = :name AND agenda_id = :agendaId
        )
        """, nativeQuery = true)
    int insertIfNotExists(
            @Param("name") String name,
            @Param("agendaId") int agendaId,
            @Param("capacity") int capacity,
            @Param("note") String note,
            @Param("createDate") LocalDateTime createDate
    );

}
