package airline.models;

public
class FlightsFromTo {
    String id, routeNo, flightNum, source, destination;

    public
    FlightsFromTo(){
        this.flightNum = "";
        this.source = "";
        this.destination = "";
    }
    public
    FlightsFromTo(String flightNum, String source, String destination) {
        this.flightNum = flightNum;
        this.source = source;
        this.destination = destination;
    }

    public
    String getFlightNum() {
        return flightNum;
    }

    public
    String getSource() {
        return source;
    }

    public
    String getDestination() {
        return destination;
    }
}
