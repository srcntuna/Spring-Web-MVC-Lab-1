package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class CamperWithActivitiesDTO {

    private int id;

    private String name;

    private int age;

    private List<ActivityDTO> activities;


}
