package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.daos.SessionDAO;
import com.cg.entities.Session;


@Service
@Transactional
public class SessionService {

    @Autowired
    private SessionDAO dao;
    
    //Finding a session by id
    @Transactional(readOnly=true)
    public Session byId(int id) {
    	Optional<Session> session = dao.findById(id);
    	if(session.isPresent()) {
            return session.get();
        }
        else
            throw new RuntimeException("Session not found!");
    }
    
    //Extracting all the sessions details
    @Transactional(readOnly=true)
    public List<Session> view() {
    	List<Session> session = dao.findAll();
    	if(session!=null) {
            return session;
        }
        else
            throw new RuntimeException("Session not found!");
    }
    
    //Updating an existing session by id
    public void update(Session s) {
    	s=dao.save(s);
                 
    }
    
    //Add a new session
    public void create(Session session) {
    	dao.save(session);
    }
    
    //Deleting an existing session by id
    public void deleteById(Session s) {
    	dao.delete(s);
    }
    
}