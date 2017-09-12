package airline.repository;

import airline.models.*;

import java.util.*;

public
class FlightRepository {

    private static List<Flight> flightList;
    public
    static List<Flight> getFlights(){
        if(flightList != null){
            return flightList;
        }else {
            flightList = new ArrayList<Flight>();
            Map<String, Route> routes = RouteRepository.getRoutes();
            Map<String, Aircraft> aircrafts = AircraftRepository.getAircrafts();




            Flight newFlight = new Flight("One", routes.get("BLR_HYD"), aircrafts.get("BOEING_777"));
            newFlight.setFlightDate(setDate(2017, Calendar.SEPTEMBER, 10));
            flightList.add(newFlight);

            newFlight = new Flight("Two", routes.get("BLR_HYD"), aircrafts.get("AIRBUS_A321"));
            newFlight.setFlightDate(setDate(2017, Calendar.SEPTEMBER, 10));
            flightList.add(newFlight);

            newFlight = new Flight("Three", routes.get("BLR_HYD"), aircrafts.get("BOEING_777"));
            newFlight.setFlightDate(setDate(2017, Calendar.SEPTEMBER, 12));
            flightList.add(newFlight);

            newFlight = new Flight("Four", routes.get("COK_HYD"), aircrafts.get("AIRBUS_A321"));
            newFlight.setFlightDate(setDate(2017, Calendar.SEPTEMBER, 10));
            flightList.add(newFlight);

            return flightList;
        }
    }
    private static Date setDate(int year, int month, int date){
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(year, month, date, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

}
