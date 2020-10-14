package com.dbbest.csv;

import com.dbbest.model.Result;

import java.util.List;

public interface CsvWriter {

  void writeCsvFile(List<Result> resultList, String directory);
}
