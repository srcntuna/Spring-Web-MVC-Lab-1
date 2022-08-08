package com.example.demo.repository;

import com.example.demo.model.Camper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CamperRepository extends JpaRepository<Camper,Integer> {


    Optional<Camper> findById(Integer id);

    List<Camper> findAll();

    Camper save(Camper camper);

}
