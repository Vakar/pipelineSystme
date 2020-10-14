package com.dbbest.dao;

import com.dbbest.model.Pipe;

import java.util.List;

public interface PipeDao {

    List<Pipe> findAll();
    boolean isExists(int startPoint, int endPoint);
    void save(Pipe pipe);

}
