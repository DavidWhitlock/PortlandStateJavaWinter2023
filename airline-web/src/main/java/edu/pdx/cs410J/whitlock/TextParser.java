package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.ParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {
  private final Reader reader;

  public TextParser(Reader reader) {
    this.reader = reader;
  }

  public Airline parse() throws ParserException {
    Pattern pattern = Pattern.compile("(.*) : (.*)");

    Airline airline = null;

    try (
      BufferedReader br = new BufferedReader(this.reader)
    ) {

      for (String line = br.readLine(); line != null; line = br.readLine()) {
        Matcher matcher = pattern.matcher(line);
        if (!matcher.find()) {
          throw new ParserException("Unexpected text: " + line);
        }

        String airlineName = matcher.group(1);
        String flightNumberAsString = matcher.group(2);

        if (airline == null) {
          airline = new Airline(airlineName);
        }
        airline.addFlight(new Flight(Integer.parseInt(flightNumberAsString)));
      }

    } catch (IOException e) {
      throw new ParserException("While parsing dictionary", e);
    }

    return airline;
  }
}
