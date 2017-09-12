package airline.util;

import airline.models.Flight;
import airline.models.TravelClasses;

import java.util.Date;
import java.util.function.Predicate;

public class FlightFilters {
    public static Predicate<Flight> filterOnSource(String source){
        Predicate<Flight> qw = flight -> source.equals(flight.getRoute().getSource().getShortName());
        return qw;
    }
    public static Predicate<Flight> filterOnDestination(String destination){
        return flight -> destination.equals(flight.getRoute().getDestination().getShortName());
    }
    public static Predicate<Flight> filterOnFlightDate(Date flightDate){
        return
                flight ->
                        (flightDate != null)?
                                flightDate.equals(flight.getFlightDate())
                                :Boolean.TRUE;

        /*Calendar cal1 = Calendar.getInstance();
        cal1.setTime(flightDate);
        Calendar cal2 = Calendar.getInstance();

        return (Flight flight) -> {
            cal2.setTime(flight.getFlightDate());
            System.out.println(flightDate.equals(flight.getFlightDate()));
            return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                    && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
                    && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
        };*/
    }
    public static Predicate<Flight> filterOnTravelClass(int reqNumOfSeats, TravelClasses travelClass){
        return flight -> reqNumOfSeats <= flight.getAvailableSeats(travelClass);
    }

}
