package edu.pdx.cs410J.whitlock;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;

public class TextDumper {
  private final Writer writer;

  public TextDumper(Writer writer) {
    this.writer = writer;
  }

  public void dump(Airline airline) {
    try (
      PrintWriter pw = new PrintWriter(this.writer)
    ){
      String airlineName = airline.getName();
      for (Flight flight : airline.getFlights()) {
        pw.println(airlineName + " : " + flight.getNumber());
      }

      pw.flush();
    }
  }
}
