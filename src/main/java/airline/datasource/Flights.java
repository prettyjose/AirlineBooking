package airline.datasource;

import airline.models.Flight;
import airline.models.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public
class Flights {

    private static List<Flight> flightList;
    private Flights(){

    }
    public
    static List<Flight> getFlights(){
        if(flightList != null){
            return flightList;
        }else {
            flightList = new ArrayList<Flight>();
            Map<String, Route> routes = Routes.getRoutes();

            flightList.add(new Flight("One", routes.get("BLR_HYD")));
            flightList.add(new Flight("Two", routes.get("COK_HYD")));
            flightList.add(new Flight("Three", routes.get("BLR_HYD")));
            return flightList;
        }
    }
}
