package com.dbbest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public @Data class Pipe {
  private Integer startPoint;
  private Integer endPoint;
  private int length;
}
