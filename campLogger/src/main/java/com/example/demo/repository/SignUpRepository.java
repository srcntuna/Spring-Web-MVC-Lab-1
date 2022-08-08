package com.example.demo.repository;

import com.example.demo.model.Activity;
import com.example.demo.model.Camper;
import com.example.demo.model.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepository extends JpaRepository <SignUp,Integer> {


    SignUp save(SignUp signUp);



}
