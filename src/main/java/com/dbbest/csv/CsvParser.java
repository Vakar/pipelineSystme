package com.dbbest.csv;

import com.dbbest.model.Path;
import com.dbbest.model.Pipe;

import java.io.File;
import java.util.Set;

public interface CsvParser {

  Set<Pipe> parsePipeSystem(File csvFile, Delimiter delimiter);

  Set<Path> parsePathList(File csvFile, Delimiter delimiter);
}
