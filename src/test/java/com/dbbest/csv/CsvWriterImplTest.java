package com.dbbest.csv;

import com.dbbest.model.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvWriterImplTest {

  private CsvWriterImpl csvWriter = new CsvWriterImpl();

  private Result resultTrue = new Result(true, 35);
  private Result resultFalse = new Result(false, 0);

  @Test
  void replaceBooleanTrueTest() {
    assertEquals("TRUE", csvWriter.replaceBoolean(true));
  }

  @Test
  void replaceBooleanFalseTest() {
    assertEquals("FALSE", csvWriter.replaceBoolean(false));
  }

  @Test
  void resultLineTrue() {
    assertEquals("TRUE;35", csvWriter.resultLine(resultTrue));
  }

  @Test
  void resultLineFalse() {
    assertEquals("FALSE;", csvWriter.resultLine(resultFalse));
  }
}
