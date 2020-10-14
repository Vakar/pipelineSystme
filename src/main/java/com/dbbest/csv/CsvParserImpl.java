package com.dbbest.csv;

import com.dbbest.model.Path;
import com.dbbest.model.Pipe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CsvParserImpl implements CsvParser {

  @Override
  public Set<Pipe> parsePipeSystem(File csvFile, Delimiter delimiter) {
    Set<Pipe> pipes = new HashSet<>();
    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
      String line = br.readLine(); // skip file header line
      while ((line = br.readLine()) != null) {
        String[] values = line.split(delimiter.getValue());
        Pipe pipe =
            Pipe.of(
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
      String line = br.readLine(); // skip file header line
      while ((line = br.readLine()) != null) {
        String[] values = line.split(delimiter.getValue());
        Path pipe = Path.of(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        pathSet.add(pipe);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return pathSet;
  }
}
