package com.pokoemelu.order.controller;

import com.pokoemelu.order.dto.BusDTO;
import com.pokoemelu.order.dto.MemberDTO;
import com.pokoemelu.order.dto.OrderDetailsDTO;
import com.pokoemelu.order.model.Order;
import com.pokoemelu.order.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<OrderDetailsDTO>> getAllOrder() {
        List<Object[]> rows = repository.getAllOrderWithDetails();
        List<OrderDetailsDTO> result = new ArrayList<>();

        for (Object[] row : rows) {
            OrderDetailsDTO dto = new OrderDetailsDTO();
            dto.setId(((Number) row[0]).longValue());
            dto.setStatus((String) row[1]);
            dto.setSetNumber((String) row[2]);
            dto.setTrxDate(((Timestamp) row[3]).toLocalDateTime());

            BusDTO bus = new BusDTO(((Number) row[4]).longValue(), (String) row[5]);
            MemberDTO member = new MemberDTO(((Number) row[6]).longValue(), (String) row[7]);

            dto.setBus(bus);
            dto.setMember(member);

            result.add(dto);
        }

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody Order order) {


        Map<String, Object> response = new HashMap<>();
        response.put("message", "Order saved successfully.");
        response.put("data", repository.save(order));

        return ResponseEntity.ok(response);

    }
}
