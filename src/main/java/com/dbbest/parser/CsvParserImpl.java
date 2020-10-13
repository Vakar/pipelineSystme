package com.dbbest.parser;

import com.dbbest.model.Path;
import com.dbbest.model.Pipe;

import java.io.*;
import java.util.*;

public class CsvParserImpl implements CsvParser {

  @Override
  public Set<Pipe> parsePipeSystem(File csvFile, Delimiter delimiter) {
    Set<Pipe> pipes = new HashSet<>();
    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] values = line.split(delimiter.getValue());
        Pipe pipe =
            new Pipe(
                Integer.parseInt(values[0]),
                Integer.parseInt(values[1]),
                Integer.parseInt(values[2]));
        pipes.add(pipe);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return pipes;
  }

  @Override
  public Set<Path> parsePathList(File csvFile, Delimiter delimiter) {
    Set<Path> pathSet = new HashSet<>();
    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] values = line.split(delimiter.getValue());
        Path pipe = new Path(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        pathSet.add(pipe);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return pathSet;
  }
}
