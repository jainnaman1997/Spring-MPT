package com.cg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Session;
import com.cg.services.SessionService;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired SessionService service;
    
    //Mapping for viewing all sessions
    @GetMapping(value="/view")	
    public List<Session> viewAll() {
        return service.view();
    }

    //Mapping for adding new session
    @PostMapping(value="/new", consumes= {"application/json"})
    public String save(@RequestBody Session session) {
    	if(session.getDuration()<4 || (!session.getMode().equals("ILT") && !session.getMode().equals("VC"))) {
    		return "Session can't be added";
    	}
    	else {
    		service.create(session);
    		return "Session added!";
    	}
    }
    
    //Mapping for update an existing session by id
    @PutMapping(value="/update/{id}", consumes= {"application/json"})
    public String update(@PathVariable int id) {
    	Session session=service.byId(id);
    	service.update(session);
    	return "Session updated!";
    }  
    
    //Mapping for deleting an existing session by id
    @DeleteMapping(value="/delete/{id}", consumes= {"application/json"})
    public String delete(@PathVariable int id) {
    	Session session=service.byId(id);
    	service.deleteById(session);
    	return "Session deleted!";
    }
    
    
    
}