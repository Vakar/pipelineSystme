package com.dbbest.model;

import java.util.Objects;

public class Path {
  private int fromPoint;
  private int toPoint;

  public Path(int fromPoint, int toPoint) {
    this.fromPoint = fromPoint;
    this.toPoint = toPoint;
  }

  public int getFromPoint() {
    return fromPoint;
  }

  public void setFromPoint(int fromPoint) {
    this.fromPoint = fromPoint;
  }

  public int getToPoint() {
    return toPoint;
  }

  public void setToPoint(int toPoint) {
    this.toPoint = toPoint;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Path path = (Path) o;
    return fromPoint == path.fromPoint && toPoint == path.toPoint;
  }

  @Override
  public int hashCode() {
    return Objects.hash(fromPoint, toPoint);
  }

  @Override
  public String toString() {
    return "Path{" + "fromPoint=" + fromPoint + ", toPoint=" + toPoint + '}';
  }
}
