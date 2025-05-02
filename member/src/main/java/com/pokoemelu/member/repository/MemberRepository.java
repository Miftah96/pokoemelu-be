package com.pokoemelu.member.repository;

import com.pokoemelu.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "SELECT " +
            "m.id AS member_id, " +
            "m.name AS member_name, " +
            "m.phone_number AS member_phone, " +
            "m.note AS member_note, " +
            "m.register_date AS member_register_date, " +
            "a.village,  "+
            "a.ward,  "+
            "a.subdistrict,  "+
            "a.regency,  "+
            "a.province,  "+
            "a.postal_code,  "+
            "a.country "+
            "FROM member m " +
            "LEFT JOIN address a ON a.id = m.address_id", nativeQuery = true)
    List<Object[]> getAllMember();

}
