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
        //sleep(3000); // to simulate delay while development 
        return wallRepository.readAll();
    }

    private void sleep(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> write(@RequestBody Message message) {
        //sleep(3000); // to simulate delay while development 
        System.out.println("Saving message: " + message.getText());
        wallRepository.save(message);
        System.out.println("returning messages " + wallRepository.readAll().size());
        return wallRepository.readAll();
    }
}
