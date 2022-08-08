package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.model.Activity;
import com.example.demo.repository.ActivityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {


    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ModelMapper mapper;


    public ActivityDTO createActivity(CreateActivityDTO createActivityDTO) {
        Activity activity = mapper.map(createActivityDTO,Activity.class);

        activity = activityRepository.save(activity);

        return mapper.map(activity, ActivityDTO.class);

    }

    public ActivityDTO getActivity(Integer id) {
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Activity not found"));

        return mapper.map(activity,ActivityDTO.class);

    }


    public List<ActivityDTO> getActivities() {
        return activityRepository.findAll().stream().map(activity -> mapper.map(activity,ActivityDTO.class)).collect(Collectors.toList());
    }

    public void deleteActivity(Integer id){

        if(activityRepository.existsById(id)){
            activityRepository.deleteById(id);
            new ResponseEntity<>(new EmptyJsonResponse(), HttpStatus.OK);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }


}
