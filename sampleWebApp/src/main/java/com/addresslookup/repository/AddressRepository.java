package com.addresslookup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addresslookup.entity.AddressBean;

@Repository
public interface AddressRepository extends JpaRepository<AddressBean,Long> {

}
