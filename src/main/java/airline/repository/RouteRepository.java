package airline.repository;

import airline.models.Airport;
import airline.models.Route;

import java.util.HashMap;
import java.util.Map;

public
class Routes {
    private static Map<String, Route> routeList;
    private Routes(){

    }
    public
    static Map<String, Route> getRoutes(){
        if(routeList != null){
            return routeList;
        }else {
            routeList = new HashMap<String, Route>();
            Map<String, Airport> airports = AirportRepository.getAirports();
            routeList.put("BLR_HYD", new Route(airports.get("BLR"), airports.get("HYD")));
            routeList.put("COK_HYD", new Route(airports.get("COK"), airports.get("HYD")));
            return routeList;
        }
    }
}
