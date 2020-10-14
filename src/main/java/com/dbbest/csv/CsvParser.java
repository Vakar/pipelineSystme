package com.dbbest.csv;

import com.dbbest.model.Path;
import com.dbbest.model.Pipe;

import java.io.File;
import java.util.List;

public interface CsvParser {

  List<Pipe> parsePipeSystem(File csvFile, Delimiter delimiter);

  List<Path> parsePathList(File csvFile, Delimiter delimiter);
}
