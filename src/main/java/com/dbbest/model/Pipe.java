package com.dbbest.model;

import java.util.Objects;

public class Pipe {
  private Integer startPoint;
  private Integer endPoint;
  private int length;

  public Pipe(Integer startPoint, Integer endPoint, int length) {
    this.startPoint = startPoint;
    this.endPoint = endPoint;
    this.length = length;
  }

  public Integer getStartPoint() {
    return startPoint;
  }

  public void setStartPoint(Integer startPoint) {
    this.startPoint = startPoint;
  }

  public Integer getEndPoint() {
    return endPoint;
  }

  public void setEndPoint(Integer endPoint) {
    this.endPoint = endPoint;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pipe pipe = (Pipe) o;
    return length == pipe.length
        && Objects.equals(startPoint, pipe.startPoint)
        && Objects.equals(endPoint, pipe.endPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startPoint, endPoint, length);
  }

  @Override
  public String toString() {
    return "Pipe{"
        + "startPoint="
        + startPoint
        + ", endPoint="
        + endPoint
        + ", length="
        + length
        + '}';
  }
}
