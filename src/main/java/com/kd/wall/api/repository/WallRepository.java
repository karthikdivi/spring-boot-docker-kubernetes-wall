package com.kd.wall.api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kd.wall.api.model.Message;

@Repository
public class WallRepository {
    private List<Message> store = new ArrayList<Message>();

    public List<Message> readAll() {
        return store;
    }

    public void save(Message msg) {
        msg.setDate(System.currentTimeMillis());
        store.add(msg);
    }

}
