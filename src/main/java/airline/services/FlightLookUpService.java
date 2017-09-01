package airline.services;

import airline.datasource.Flights;
import airline.models.Flight;
import airline.models.Route;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public
class FlightLookUpService {
    public
    List<Flight> getFlights(Route route){
        List<Flight> allFlightList= Flights.getFlights();
        List<Flight> searchedFlights=new ArrayList<Flight>();
        for(Flight thisFlight: allFlightList){
            if(route.getSource().getShortName().equals(thisFlight.getRoute().getSource().getShortName())
                    && route.getDestination().getShortName().equals(thisFlight.getRoute().getDestination().getShortName())){
                searchedFlights.add(thisFlight);
            }
        }
        return searchedFlights;
    }
}
