package com.dbbest.csv;

import com.dbbest.model.Result;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriterImpl implements CsvWriter {

  private static final String FILE_NAME = "output.csv";
  private static final String HEADER = "ROUTE EXISTS;MIN LENGTH";

  @Override
  public void writeCsvFile(List<Result> resultList, String directory) {
    try (FileWriter writer = new FileWriter(directory + File.separator + FILE_NAME)) {
      writer.write(HEADER);
      writer.write(System.lineSeparator());
      for (Result result : resultList) {
        writer.write(resultLine(result));
        writer.write(System.lineSeparator());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  String replaceBoolean(boolean value) {
    return value ? "TRUE" : "FALSE";
  }

  String resultLine(Result result) {
    if (result.isConnected()) {
      return replaceBoolean(result.isConnected()) + ";" + result.getTotalLength();
    } else {
      return replaceBoolean(result.isConnected()) + ";";
    }
  }
}
