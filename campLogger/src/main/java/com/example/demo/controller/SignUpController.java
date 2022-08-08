package com.example.demo.controller;

import com.example.demo.dto.ActivityDTO;
import com.example.demo.dto.CreateSignUpDTO;
import com.example.demo.dto.SignUpDTO;
import com.example.demo.model.Activity;
import com.example.demo.model.Camper;
import com.example.demo.service.CamperService;
import com.example.demo.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/signups")
public class SignUpController {

    @Autowired
    SignUpService signUpService;


    @PostMapping
    public ActivityDTO createSignUp(@RequestBody @Valid CreateSignUpDTO signUp) throws Exception {

        return signUpService.createSignUp(signUp);

    }

}
