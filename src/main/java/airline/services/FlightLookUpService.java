package airline.services;

import airline.models.EachResultLine;
import airline.models.TravelClasses;
import airline.repository.FlightRepository;
import airline.models.Flight;
import airline.models.SearchCriteria;
import airline.util.FlightFilters;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;

@Service
public
class FlightLookUpService {

    public List<EachResultLine> searchFlights(SearchCriteria searchCriteria){
        List<Flight> filteredFlights = getFlights(searchCriteria);

        List<EachResultLine> searchResult = new ArrayList<>();

        for(Flight flight: filteredFlights){
            searchResult.add(new EachResultLine(flight, flight.calculateTravelCost(searchCriteria.getTravelClass(), searchCriteria.getRequestedTravellers())));
        }

        return searchResult;
    }

    private
    List<Flight> getFlights(SearchCriteria searchCriteria){

        List<Flight> searchedFlights=FlightRepository.getFlights()
                .stream()
                .filter(FlightFilters.filterOnSource(searchCriteria.getSource().getShortName()))
                .peek(e-> System.out.println(e.getFlightNum()))
                .filter(FlightFilters.filterOnDestination(searchCriteria.getDestination().getShortName()))
                .peek(e-> System.out.println(e.getFlightNum()))
                .filter(FlightFilters.filterOnFlightDate(searchCriteria.getFlightDate()))
                .peek(e-> System.out.println(e.getFlightNum()))
                .filter(FlightFilters.filterOnTravelClass(searchCriteria.getRequestedTravellers(), searchCriteria.getTravelClass()))
                .peek(e-> System.out.println(e.getFlightNum()))
                //Todo: Try .map to create a resultline object with each flight.
                .collect(toList());



        /*//Todo: Do streaming or independent methods
        for(Flight thisFlight: allFlightList){
            if(searchCriteria.getSource().getShortName().equals(thisFlight.getRoute().getSource().getShortName())
                    && searchCriteria.getDestination().getShortName().equals(thisFlight.getRoute().getDestination().getShortName())
                    && searchCriteria.getRequestedTravellers() <= thisFlight.getAvailableSeats(searchCriteria.getTravelClass())){
                searchedFlights.add(thisFlight);
            }
        }*/
        return searchedFlights;
    }

}
