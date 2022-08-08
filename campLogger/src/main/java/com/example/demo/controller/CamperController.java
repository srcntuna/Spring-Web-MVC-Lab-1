package com.example.demo.controller;

import com.example.demo.dto.CamperDTO;
import com.example.demo.dto.CamperWithActivitiesDTO;
import com.example.demo.dto.CreateCamperDTO;
import com.example.demo.model.Camper;
import com.example.demo.service.ActivityService;
import com.example.demo.service.CamperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Member;
import java.util.List;

@RestController
@RequestMapping("/campers")
public class CamperController {

    @Autowired
    CamperService camperService;


    @GetMapping
    public List<CamperDTO> getCampers() {
        return camperService.getCampers();
    }


    @GetMapping("/{id}")
    public CamperWithActivitiesDTO readCamper(@PathVariable Integer id) {
        return camperService.getCamper(id);
    }

    @PostMapping
    public CamperDTO createCamper(@RequestBody @Valid CreateCamperDTO camper) {
        return camperService.createCamper(camper);
    }



}
