package com.kd.wall.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kd.wall.api.model.Message;
import com.kd.wall.api.repository.WallRepository;

@RestController
@RequestMapping("/wall")
public class Wall {
    
    @Autowired
    WallRepository wallRepository;
    
    @RequestMapping()
    public List<Message> read() {
        return wallRepository.readAll();
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> write(@RequestBody Message message){
        System.out.println("Saving message: " + message.getText());
        wallRepository.save(message);
        System.out.println("returning messages " + wallRepository.readAll().size());
        return wallRepository.readAll();
    }
}
