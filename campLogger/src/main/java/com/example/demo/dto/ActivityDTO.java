package com.example.demo.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
public class ActivityDTO {

    private int id;


    private String name;

    private int difficulty;
}
