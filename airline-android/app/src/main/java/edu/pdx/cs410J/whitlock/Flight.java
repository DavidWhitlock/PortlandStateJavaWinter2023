package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.AbstractFlight;

public class Flight extends AbstractFlight {
    @Override
    public int getNumber() {
        return 42;
    }

    @Override
    public String getSource() {
        return "PDX";
    }

    @Override
    public String getDepartureString() {
        return "3/7/2022 6:20 PM";
    }

    @Override
    public String getDestination() {
        return "LAS";
    }

    @Override
    public String getArrivalString() {
        return "3/7/2022 11:00 PM";
    }
}
