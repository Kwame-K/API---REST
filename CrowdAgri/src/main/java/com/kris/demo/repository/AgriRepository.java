package com.kris.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kris.demo.model.Agriculteur;


@Repository
public interface AgriRepository extends JpaRepository<Agriculteur,Integer>{

}
