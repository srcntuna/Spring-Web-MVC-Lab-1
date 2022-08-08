package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.model.Activity;
import com.example.demo.model.Camper;
import com.example.demo.model.SignUp;
import com.example.demo.repository.CamperRepository;
import com.example.demo.repository.SignUpRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SignUpService {


    @Autowired
    private SignUpRepository signUpRepository;

    @Autowired
    private ActivityService activityService;

    @Autowired CamperService camperService;

    @Autowired
    private ModelMapper mapper;

    public ActivityDTO createSignUp(CreateSignUpDTO createSignUpDTO){


        int camper_id = createSignUpDTO.getCamper_id();
        int activity_id = createSignUpDTO.getActivity_id();
        int currentTime = createSignUpDTO.getCurrentTime();

        ActivityDTO activityDTO = activityService.getActivity(activity_id);
        CamperWithActivitiesDTO camperWithActivitiesDTO = camperService.getCamper(camper_id);

        Activity activity = mapper.map(activityDTO,Activity.class);
        Camper camper = mapper.map(camperWithActivitiesDTO,Camper.class);



        SignUpDTO signUpDTO = new SignUpDTO(currentTime ,camper,activity);



        SignUp signUp = mapper.map(signUpDTO,SignUp.class);

        System.out.println("line 55 - current time : " + signUp.getCurrentTime());
        System.out.println("line 56 - activity : " + signUp.getActivity());
        System.out.println("line 57 - camper : " + signUp.getCamper());

        try{
            signUp = signUpRepository.save(signUp);
        }catch (ValidationException e){
            throw e;
        }



           return activityDTO;


    }

    public void deleteSignUps(Integer activityId){
        List<SignUp> deletedSignUps = signUpRepository.findAll().stream().filter(signUp -> signUp.getActivity().getId() == activityId).toList();

        signUpRepository.deleteAll(deletedSignUps);


    }


}
