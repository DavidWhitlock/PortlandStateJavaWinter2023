package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.web.HttpRequestHelper;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Integration test that tests the REST calls made by {@link AirlineRestClient}
 */
@TestMethodOrder(MethodName.class)
class AirlineRestClientIT {
  private static final String HOSTNAME = "localhost";
  private static final String PORT = System.getProperty("http.port", "8080");

  private AirlineRestClient newAirlineRestClient() {
    int port = Integer.parseInt(PORT);
    return new AirlineRestClient(HOSTNAME, port);
  }

  @Test
  void test0RemoveAllAirlines() throws IOException {
    AirlineRestClient client = newAirlineRestClient();
    client.removeAllAirlines();
  }

  @Test
  void test2CreateFirstFlight() throws IOException, ParserException {
    AirlineRestClient client = newAirlineRestClient();
    String airlineName = "Airline";
    int flightNumber = 123;
    client.addFlight(airlineName, String.valueOf(flightNumber));

    Airline airline = client.getAirline(airlineName);
    assertThat(airline.getName(), equalTo(airlineName));
    assertThat(airline.getFlights().iterator().next().getNumber(), equalTo(flightNumber));
  }

}