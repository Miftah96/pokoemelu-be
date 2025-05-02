package com.pokoemelu.member.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private Long id;
    private String village;
    private String ward;
    private String subdistrict;
    private String regency;
    private String province;
    private String postalCode;
    private String country;
}
