package com.example.demo.dto;

import com.example.demo.model.Activity;
import com.example.demo.model.Camper;
import lombok.Data;

import javax.persistence.*;

@Data

public class CreateSignUpDTO {

private int currentTime;

 private int camper_id;

 private int activity_id;



}
