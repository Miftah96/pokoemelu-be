package com.pokoemelu.member.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberWithAddressDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private String note;
    private LocalDateTime registerDate;
    private AddressDTO address;
}
