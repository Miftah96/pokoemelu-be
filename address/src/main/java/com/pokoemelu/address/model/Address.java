package com.pokoemelu.address.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String village;
    private String ward;
    private String subdistrict;
    private String regency;
    private String province;
    private String postalCode;
    private String country = "Indonesia";
}
