package com.pokoemelu.address.repository;

import com.pokoemelu.address.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(value = "SELECT * FROM address ", nativeQuery = true)
    List<Address> getAllAddress();
    boolean existsByVillage(String village);

}
