package com.kris.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kris.demo.model.Investisseur;

@Repository
public interface InvestRepository extends JpaRepository<Investisseur,Integer>{


}
