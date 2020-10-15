package com.dbbest.dao;

import com.dbbest.model.Pipe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PipeDaoMock implements PipeDao {

  private List<Pipe> pipes = new ArrayList<>();

  @Override
  public List<Pipe> findAll() {
    return pipes;
  }

  @Override
  public boolean isExists(int startPoint, int endPoint) {
    List<Pipe> f =
        pipes.stream()
            .filter(pipe -> pipe.getStartPoint() == startPoint && pipe.getEndPoint() == endPoint)
            .collect(Collectors.toList());
    return !f.isEmpty();
  }

  @Override
  public void save(Pipe pipe) {
    pipes.add(pipe);
  }
}
