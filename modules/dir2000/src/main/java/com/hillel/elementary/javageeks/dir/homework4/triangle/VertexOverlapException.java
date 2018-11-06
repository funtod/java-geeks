package com.hillel.elementary.javageeks.dir.homework4.triangle;

public class VertexOverlapException extends Exception {

  public VertexOverlapException() {
  }

  public VertexOverlapException(Vertex ... vertexes) {
    this("Vertex overlap detected: " + vertexes);
  }

  public VertexOverlapException(String message) {
    super(message);
  }
}
