package com.example.demo.dto;

import com.example.demo.model.Activity;
import com.example.demo.model.Camper;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data

public class SignUpDTO {


    private int currentTime;
    private Camper camper;

    private Activity activity;

    public SignUpDTO(int currentTime, Camper camper, Activity activity) {
        this.currentTime = currentTime;
        this.camper = camper;
        this.activity = activity;
    }
}
