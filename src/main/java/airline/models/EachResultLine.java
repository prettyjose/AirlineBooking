package airline.models;

public
class EachResultLine {
 Flight flight;
 Double costOfTravel;

    public EachResultLine(Flight flight, Double costOfTravel) {
        this.flight = flight;
        this.costOfTravel = costOfTravel;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Double getCostOfTravel() {
        return costOfTravel;
    }

    public void setCostOfTravel(Double costOfTravel) {
        this.costOfTravel = costOfTravel;
    }
}
