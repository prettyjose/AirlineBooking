package airline.models;

import java.util.HashMap;
import java.util.Map;

public
class Flight {
    String flightNum;
    Route route;
    Aircraft aircraft;
    Map<TravelClass, Integer> bookedSeats;

    public
    Flight(String flightNum, Route route, Aircraft aircraft) {
        this.flightNum = flightNum;
        this.route = route;
        this.aircraft = aircraft;

        bookedSeats =  new HashMap<TravelClass, Integer>();

        TravelClassManager travelClassManager= aircraft.getTravelClassManager();

        bookedSeats.put(travelClassManager.getEconomyClass(), 0);

        bookedSeats.put(travelClassManager.getBusinessClass(), 0);

        bookedSeats.put(travelClassManager.getFirstClass(), 0);

    }

    public
    Aircraft getAircraft() {
        return aircraft;
    }

    public
    void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
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


    public int getAvailableSeatsInEconomy(){

        TravelClass economyClass = aircraft.getTravelClassManager().getEconomyClass();
        return economyClass.getTotalSeats() - bookedSeats.get(economyClass);
    }
    public int getAvailableSeatsInBusinessClass(){
        TravelClass businessClass = aircraft.getTravelClassManager().getBusinessClass();
        return businessClass.getTotalSeats() - bookedSeats.get(businessClass);
    }
    public int getAvailableSeatsInFirstClass(){
        TravelClass firstClass = aircraft.getTravelClassManager().getFirstClass();
        return firstClass.getTotalSeats() - bookedSeats.get(firstClass);
    }

    public
    int getAvailableSeats(TravelClasses type) {
        switch(type){
            case ECONOMY:
                return getAvailableSeatsInEconomy();
            case BUSINESSCLASS:
                return getAvailableSeatsInBusinessClass();
            case FIRSTCLASS:
                return getAvailableSeatsInFirstClass();
        }
        return 0;
    }

    public Double calculateEconomyCost(int numRequestedSeats){
        TravelClass economyClass = aircraft.getTravelClassManager().getEconomyClass();
        return numRequestedSeats * economyClass.getPrice();
    }
    public Double calculateBusinessClassCost(int numRequestedSeats){
        TravelClass businessClass = aircraft.getTravelClassManager().getBusinessClass();
        return numRequestedSeats * businessClass.getPrice();
    }
    public Double calculateFirstClassCost(int numRequestedSeats){
        TravelClass firstClass = aircraft.getTravelClassManager().getFirstClass();
        return numRequestedSeats * firstClass.getPrice();
    }
    public Double calculateTravelCost(TravelClasses travelClass, int numRequestedSeats){
        switch(travelClass){
            case ECONOMY:
                return calculateEconomyCost(numRequestedSeats);
            case BUSINESSCLASS:
                return calculateBusinessClassCost(numRequestedSeats);
            case FIRSTCLASS:
                return calculateFirstClassCost(numRequestedSeats);
        }
        return Double.POSITIVE_INFINITY;//Todo: change to a good default
    }
}
