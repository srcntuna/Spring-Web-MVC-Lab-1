package com.example.demo.repository;

import com.example.demo.model.Activity;
import com.example.demo.model.Camper;
import com.example.demo.model.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository  extends JpaRepository<Activity,Integer> {


    Activity save(Activity activity);

    List<Activity> findAll();

    void deleteById(Integer id);


}
