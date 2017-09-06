package airline.models;

public
class Aircraft {
    private String id;
    private int numOfSeats;
    TravelClassManager travelClassManager;

    public
    Aircraft(String id, TravelClassManager travelClassManager) {
        this.id = id;
//        this.numOfSeats = numOfSeats;
        this.travelClassManager = travelClassManager;
    }

    public
    String getId() {
        return id;
    }

    public
    int getNumOfSeats() {
        return numOfSeats;
    }

    public
    TravelClassManager getTravelClassManager() {
        return travelClassManager;
    }

    public
    void setTravelClassManager(TravelClassManager travelClassManager) {
        this.travelClassManager = travelClassManager;
    }
}
