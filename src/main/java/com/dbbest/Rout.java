package com.dbbest;

public enum Rout {
  SAVE_RESULT("saveResult"),
  SELECT_OUTPUT_DIRECTORY("selectOutputDirectory"),
  UPLOAD_PIPELINE_SYSTEM("uploadPipelineSystem"),
  UPLOAD_SET_OF_POINTS("uploadSetOfPoints"),
  WELL_DONE("wellDone");

  public final String value;

  Rout(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
