package airline.models;

import java.util.Date;

public
class SearchCriteria {
    private Airport source;
    private Airport destination;
    private Date flightDate;
    private int requestedTravellers = 1;
    private TravelClasses travelClass;

    public
    TravelClasses getTravelClass() {
        return travelClass;
    }

    public
    void setTravelClass(TravelClasses travelClass) {
        this.travelClass = travelClass;
    }

    public
    Airport getSource() {
        return source;
    }

    public
    void setSource(Airport source) {
        this.source = source;
    }

    public
    Airport getDestination() {
        return destination;
    }

    public
    void setDestination(Airport destination) {
        this.destination = destination;
    }

    public
    int getRequestedTravellers() {
        return requestedTravellers;
    }

    public
    void setRequestedTravellers(int requestedTravellers) {
        this.requestedTravellers = requestedTravellers;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public Date getFlightDate() {
        return flightDate;
    }
}
