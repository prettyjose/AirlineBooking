package airline.services;

import airline.models.TravelClasses;
import airline.repository.FlightRepository;
import airline.models.Flight;
import airline.models.SearchCriteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public
class FlightLookUpService {
    public
    List<Flight> getFlights(SearchCriteria searchCriteria){
        List<Flight> allFlightList= FlightRepository.getFlights();
        List<Flight> searchedFlights=new ArrayList<Flight>();
        //Todo: Do streaming or independent methods
        for(Flight thisFlight: allFlightList){
            if(searchCriteria.getSource().getShortName().equals(thisFlight.getRoute().getSource().getShortName())
                    && searchCriteria.getDestination().getShortName().equals(thisFlight.getRoute().getDestination().getShortName())
                    && searchCriteria.getRequestedTravellers() <= thisFlight.getAvailableSeats(searchCriteria.getTravelClass())){
                searchedFlights.add(thisFlight);
            }
        }
        return searchedFlights;
    }

}
