package com.pokoemelu.order.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDTO {
    private Long id;
    private String status;
    private String setNumber;
    private LocalDateTime trxDate;
    private BusDTO bus;
    private MemberDTO member;
}
