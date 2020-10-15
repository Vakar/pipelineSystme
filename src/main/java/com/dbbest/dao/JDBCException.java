package com.dbbest.dao;

public class JDBCException extends RuntimeException {
  public JDBCException(String message, Throwable cause) {
    super(message, cause);
  }
}
