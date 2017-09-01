package airline.repository;

import airline.models.Airport;

import java.util.HashMap;
import java.util.Map;

public
class Airports {
    private static Map<String, Airport> airportList;
    private Airports(){

    }
    public
    static Map<String, Airport> getAirports(){
        if(airportList != null){
            return airportList;
        }else {
            airportList = new HashMap<String, Airport>();

            airportList.put("BLR", new Airport("Bangalore", "BLR"));
            airportList.put("HYD", new Airport("Hyderabad", "HYD"));
            airportList.put("COK", new Airport("Cochin", "COK"));

            return airportList;
        }
    }
}
