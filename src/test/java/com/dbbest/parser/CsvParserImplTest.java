package com.dbbest.parser;

import com.dbbest.model.Path;
import com.dbbest.model.Pipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("PARSER TEST")
class CsvParserImplTest {

  private final CsvParser csvParser = new CsvParserImpl();

  private static final String PIPE_SYSTEM_FILE = "pipeSystem.csv";
  private static final String SET_OF_POINTS = "setOfPoints.csv";

  private final Set<Pipe> pipeSet =
      new HashSet<>(
          Arrays.asList(
              Pipe.of(1, 2, 10),
              Pipe.of(2, 3, 20),
              Pipe.of(3, 4, 30),
              Pipe.of(3, 5, 15),
              Pipe.of(6, 7, 20)));

  private final Set<Path> pathSet =
      new HashSet<>(Arrays.asList(Path.of(2, 5), Path.of(2, 6), Path.of(6, 7)));

  @Test
  @DisplayName("Parse pipeline system csv file")
  void parsePipeSystemTest() throws URISyntaxException {
    File pipeSystemCsvFile = getFileByName(PIPE_SYSTEM_FILE);
    Set<Pipe> actualPipeSet = csvParser.parsePipeSystem(pipeSystemCsvFile, Delimiter.SEMICOLON);
    assertThat(pipeSet).hasSize(actualPipeSet.size()).hasSameElementsAs(actualPipeSet);
  }

  @Test
  @DisplayName("Parse set of points csv file")
  void parsePathListTest() throws URISyntaxException {
    File setOfPointsCsvFile = getFileByName(SET_OF_POINTS);
    Set<Path> actualPathSet = csvParser.parsePathList(setOfPointsCsvFile, Delimiter.SEMICOLON);
    assertThat(pathSet).hasSize(actualPathSet.size()).hasSameElementsAs(actualPathSet);
  }

  private File getFileByName(String fileName) throws URISyntaxException {
    ClassLoader classLoader = getClass().getClassLoader();
    URL url = classLoader.getResource(fileName);
    assert url != null;
    return new File(url.toURI());
  }
}
