package com.dbbest.csv;

import com.dbbest.model.Path;
import com.dbbest.model.Pipe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvParserImpl implements CsvParser {

  @Override
  public List<Pipe> parsePipeSystem(File csvFile, Delimiter delimiter) {
    List<Pipe> pipes = new ArrayList<>();
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
  public List<Path> parsePathList(File csvFile, Delimiter delimiter) {
    List<Path> pathSet = new ArrayList<>();
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
