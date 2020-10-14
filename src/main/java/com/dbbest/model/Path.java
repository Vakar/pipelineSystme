package com.dbbest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public @Data class Path {
  private int fromPoint;
  private int toPoint;
}
