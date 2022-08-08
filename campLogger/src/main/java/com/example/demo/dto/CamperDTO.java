package com.example.demo.dto;

import com.example.demo.model.Activity;
import com.example.demo.model.SignUp;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
public class CamperDTO {

    private int id;

    private String name;

    private int age;

}
