package com.example.crud.dao;

import com.example.crud.entity.Participant;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

public interface ParticipantDao{

    public Participant save(Participant participant) throws HeuristicRollbackException, RollbackException, HeuristicMixedException, SystemException;

    public Participant getParticipantById(int id);

    public Participant deleteParticipantById(int id);


}