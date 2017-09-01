package airline.models;

public
class Flight {
    String flightNum;
    Route route;

    public
    Flight(String flightNum, Route route) {
        this.flightNum = flightNum;
        this.route = route;
    }

    public
    String getFlightNum() {
        return flightNum;
    }

    public
    Route getRoute() {
        return route;
    }

    public
    void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public
    void setRoute(Route route) {
        this.route = route;
    }
}
