package com.kris.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kris.demo.model.Campagne;

@Repository
public interface CampagneRepository extends JpaRepository<Campagne,Integer>{




}
