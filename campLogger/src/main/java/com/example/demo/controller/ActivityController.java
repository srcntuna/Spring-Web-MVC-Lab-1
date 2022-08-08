package com.example.demo.controller;

import com.example.demo.dto.ActivityDTO;
import com.example.demo.dto.CamperDTO;
import com.example.demo.dto.CreateActivityDTO;
import com.example.demo.dto.CreateCamperDTO;
import com.example.demo.model.Activity;
import com.example.demo.service.ActivityService;
import com.example.demo.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @Autowired
    SignUpService signUpService;

    @GetMapping
    public List<ActivityDTO> getActivities() {
        return activityService.getActivities();
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Integer id) {

        signUpService.deleteSignUps(id);
        activityService.deleteActivity(id);
    }

    @PostMapping
    public ActivityDTO createActivity(@RequestBody @Valid CreateActivityDTO activityDTO) {
        return activityService.createActivity(activityDTO);
    }

}
