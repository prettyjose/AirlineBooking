package airline.models;

import java.time.temporal.ChronoUnit;
import java.util.*;

public
class Flight {
    String flightNum;
    Route route;
    Aircraft aircraft;
    Map<TravelClass, Integer> bookedSeats;
    Date flightDate;

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

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
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

        if(this.timeFromToday() <= 28/*4 weeks = 28 days*/){
            return businessClass.getTotalSeats() - bookedSeats.get(businessClass);
        }
        return 0;
    }
    public int getAvailableSeatsInFirstClass(){
        TravelClass firstClass = aircraft.getTravelClassManager().getFirstClass();

        if( this.timeFromToday() <= 10){
            return firstClass.getTotalSeats() - bookedSeats.get(firstClass);
        }
        return 0;
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
        Double onDemandPrice;
        if(getAvailableSeatsInEconomy() < 0.1 * economyClass.getTotalSeats()){
            onDemandPrice = 1.6 * economyClass.getPrice();
        }else if(getAvailableSeatsInEconomy() < 0.5 * economyClass.getTotalSeats()){
            onDemandPrice = 1.3 * economyClass.getPrice();
        }else{
            onDemandPrice = economyClass.getPrice();
        }
        return numRequestedSeats * onDemandPrice;
    }
    public Double calculateBusinessClassCost(int numRequestedSeats){
        TravelClass businessClass = aircraft.getTravelClassManager().getBusinessClass();
        Double onDemandPrice;
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(this.getFlightDate());
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        //140% of base fare on sundays, mondays, and fridays
        if(dayOfWeek == 1 || dayOfWeek == 2 || dayOfWeek == 6 ){
            onDemandPrice = 1.4 * businessClass.getPrice();
        }else{
            onDemandPrice = businessClass.getPrice();
        }
        return numRequestedSeats * onDemandPrice;
    }
    public Double calculateFirstClassCost(int numRequestedSeats){
        TravelClass firstClass = aircraft.getTravelClassManager().getFirstClass();
        Double onDemandPrice =
                (1 +
                0.1 * (10-this.timeFromToday())
                ) * firstClass.getPrice();
        return numRequestedSeats * onDemandPrice;
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
    private long timeFromToday(){
        Calendar calendar2 = GregorianCalendar.getInstance();
        calendar2.setTime(this.getFlightDate());
        Calendar calendar1 = GregorianCalendar.getInstance();
        calendar1.setTime(new Date());

        return ChronoUnit.DAYS.between(calendar2.toInstant(), calendar1.toInstant());
    }
}
