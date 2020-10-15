package com.dbbest.model;

import java.util.Objects;

public class Result {
  private boolean isConnected;
  private int totalLength;

  public Result(boolean isConnected, int totalLength) {
    this.isConnected = isConnected;
    this.totalLength = totalLength;
  }

  public boolean isConnected() {
    return isConnected;
  }

  public void setConnected(boolean connected) {
    isConnected = connected;
  }

  public int getTotalLength() {
    return totalLength;
  }

  public void setTotalLength(int totalLength) {
    this.totalLength = totalLength;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Result result = (Result) o;
    return isConnected == result.isConnected && totalLength == result.totalLength;
  }

  @Override
  public int hashCode() {
    return Objects.hash(isConnected, totalLength);
  }

  @Override
  public String toString() {
    return "Result{" + "isConnected=" + isConnected + ", totalLength=" + totalLength + '}';
  }
}
