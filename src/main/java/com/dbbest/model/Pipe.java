package com.dbbest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public @Data class Pipe {
  private int startPoint;
  private int endPoint;
  private int length;
}
