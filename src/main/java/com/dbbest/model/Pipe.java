package com.dbbest.model;

import java.util.Objects;

public class Pipe {

  private int startPoint;
  private int endPoint;
  private int length;

  public Pipe(int startPoint, int endPoint, int length) {
    this.startPoint = startPoint;
    this.endPoint = endPoint;
    this.length = length;
  }

  public int getStartPoint() {
    return startPoint;
  }

  public void setStartPoint(int startPoint) {
    this.startPoint = startPoint;
  }

  public int getEndPoint() {
    return endPoint;
  }

  public void setEndPoint(int endPoint) {
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
    return startPoint == pipe.startPoint && endPoint == pipe.endPoint && length == pipe.length;
  }

  @Override
  public int hashCode() {
    return Objects.hash(startPoint, endPoint, length);
  }

  @Override
  public String toString() {
    return "Pipe{" + "from=" + startPoint + ", to=" + endPoint + ", length=" + length + '}';
  }
}
