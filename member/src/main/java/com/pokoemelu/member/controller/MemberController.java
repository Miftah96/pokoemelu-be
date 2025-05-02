package com.pokoemelu.member.controller;

import com.pokoemelu.member.dto.AddressDTO;
import com.pokoemelu.member.dto.MemberWithAddressDTO;
import com.pokoemelu.member.model.Member;
import com.pokoemelu.member.repository.MemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    private final MemberRepository repository;

    public MemberController(MemberRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Member> gettAllMember() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createMember(@RequestBody Member member) {
        return ResponseEntity.ok(repository.save(member));
    }
}
