package airline.repository;

import airline.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

            flightList.add(new Flight("One", routes.get("BLR_HYD"), aircrafts.get("BOEING_777")));
            flightList.add(new Flight("Three", routes.get("BLR_HYD"), aircrafts.get("AIRBUS_A321")));
            return flightList;
        }
    }
}
