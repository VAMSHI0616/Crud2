package com.example.crud.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.crud.entity.MedicalResearch;
import com.example.crud.entity.Participant;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.*;

@Repository
@Transactional
public class ParticipantDaoImpl implements ParticipantDao{

    // save participants in in-memory
    private ArrayList<Participant> participantDb;

    private ArrayList<MedicalResearch> medicalResearhDb;

    // for perisitance context
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private SessionFactory sessionFactory;

    public ParticipantDaoImpl(){
        participantDb = new ArrayList<Participant>();

        // create medical research objects

        MedicalResearch research1 = new MedicalResearch("Cancer Research");
        MedicalResearch research2 = new MedicalResearch("AIDS Research");
        MedicalResearch research3 = new MedicalResearch("Akshay Research");
        research1.setId(1);
        research2.setId(2);
        research2.setId(3);
        medicalResearhDb = new ArrayList<MedicalResearch>();
        medicalResearhDb.add(research1);
        medicalResearhDb.add(research2);
        medicalResearhDb.add(research3);

    }

public Participant save(Participant participant) {

        // here the data is loaded into the persistance context and is being tracked

        return entityManager.merge(participant);

    }

    public Participant getParticipantById(int id){

    return entityManager.find(Participant.class,id);
    
    }

    public Participant deleteParticipantById(int id){

    try{    
        Participant participant = participantDb.remove(id);

        return participant;
    }

    catch(Exception ex){
        return null;
    }


    }
}