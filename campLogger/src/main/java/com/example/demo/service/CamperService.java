package com.example.demo.service;

import com.example.demo.dto.ActivityDTO;
import com.example.demo.dto.CamperDTO;
import com.example.demo.dto.CamperWithActivitiesDTO;
import com.example.demo.dto.CreateCamperDTO;
import com.example.demo.model.Camper;
import com.example.demo.model.SignUp;
import com.example.demo.repository.CamperRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CamperService {

    @Autowired
    private CamperRepository camperRepository;

    @Autowired
    private ModelMapper mapper;

    public CamperDTO createCamper(CreateCamperDTO createCamperDTO) {


       Camper camper = mapper.map(createCamperDTO,Camper.class);

       try{
           camper = camperRepository.save(camper);
       }catch (ValidationException e){
           throw e;
       }


       return mapper.map(camper, CamperDTO.class);

    }

    public CamperWithActivitiesDTO getCamper(Integer id) {
        Camper camper = camperRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));


       List<ActivityDTO> activityDTOList = camper.getSignUpArrayList().stream().map(signUp -> mapper.map(signUp.getActivity(), ActivityDTO.class)).collect(Collectors.toList());


       CamperWithActivitiesDTO camperWithActivitiesDTO  = mapper.map(camper, CamperWithActivitiesDTO.class);
       camperWithActivitiesDTO.setActivities(activityDTOList);

       return  camperWithActivitiesDTO;

    }

    public List<CamperDTO> getCampers(){

        return camperRepository.findAll().stream().map(camper -> mapper.map(camper, CamperDTO.class)).collect(Collectors.toList());
    }

}
