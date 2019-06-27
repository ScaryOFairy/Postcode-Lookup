package com.addresslookup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addresslookup.entity.LoqateBean;

@Repository
public interface LoqateRepository extends JpaRepository<LoqateBean, Long>{

}
