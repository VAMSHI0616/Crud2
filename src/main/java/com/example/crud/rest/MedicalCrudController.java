package com.example.crud.rest;

import com.example.crud.dao.ParticipantDao;
import com.example.crud.entity.Participant;
import com.example.crud.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;


@RestController
public class MedicalCrudController{




    @Autowired
    private ParticipantDao participantDao;

    @Autowired
    private RestTemplate restTemplate;


    // get participant and his enrolled research
    @GetMapping("/Participant/{id}")
    public Participant getParticipant(@PathVariable int id){

        Participant participant = participantDao.getParticipantById(id);

        return participant;
    }



    @PutMapping("/Participant")
    public Participant updateParticipant(@RequestBody Participant participant) throws HeuristicRollbackException, RollbackException, HeuristicMixedException, SystemException {

        participantDao.save(participant);

        return participant;

    }

    @PostMapping("/Participant")
    public Participant saveParticipant(@RequestBody Participant participant) throws HeuristicRollbackException, RollbackException, HeuristicMixedException, SystemException {

        System.out.println(participant.getName());
        participant.setId(0);
        participantDao.save(participant);

        return participantDao.save(participant);

    }

    @DeleteMapping("/Participant/{id}")
    public String deleteParticipant(@PathVariable int id){

        participantDao.deleteParticipantById(id);

        return  "deleted the resource";
    }

    @GetMapping("/apitest")
    public Person getApi(@RequestParam String name){
        return restTemplate.getForObject("https://api.agify.io/?name=Vamshi", Person.class);

    }

}
