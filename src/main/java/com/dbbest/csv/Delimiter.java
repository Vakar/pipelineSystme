package com.dbbest.csv;

public enum Delimiter {
  SEMICOLON(";");

  public final String value;

  Delimiter(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
