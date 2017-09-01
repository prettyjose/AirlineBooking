package airline.controllers;

import airline.datasource.Airports;
import airline.datasource.Flights;
import airline.models.Airport;
import airline.models.Flight;

import airline.models.Route;
import airline.services.FlightLookUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by rajashrk on 8/8/17.
 */
@Controller
public class FlightController {

    @Autowired  //implies no need to initialise flightLookUpService object. It keeps it as a Singleton object.
    private FlightLookUpService flightLookUpService;

    @RequestMapping("/")
    public String welcomeMessage(Model model) {
        model.addAttribute("welcomemessage", "Welcome to Vapasi Flights");
        model.addAttribute("airports", Airports.getAirports());
//        model.addAttribute("route", new Airport());
        model.addAttribute("route", new Route());
        return "flightwelcome";
    }

    @RequestMapping(value={"/flights", "/flights/search"})
    public String allflights(Model model) {
        model.addAttribute("welcomemessage", "Welcome to Vapasi Flights");
        model.addAttribute("flights", Flights.getFlights());
        model.addAttribute("airports", Airports.getAirports());
        model.addAttribute("route", new Route());

        return "flightsView";
    }

    @RequestMapping(value="/flights/search", method = RequestMethod.POST)//{route}
    public String searchFlights(@ModelAttribute("route") Route route,  Model model) {
        model.addAttribute("welcomemessage", "Welcome to Vapasi Flights");
        model.addAttribute("flights", flightLookUpService.getFlights(route));
        model.addAttribute("airports", Airports.getAirports());
        return "flightsView";
    }

    /*@RequestMapping(value="/search/{route}", method= RequestMethod.POST)
    public String flightSearch(@PathVariable(value="route") String route, Model model) {
        String[] places = route.split("_");

        List<Flight> searchResult = getSearchResult(places[0], places[1]);

        model.addAttribute("from", places[0]);
        model.addAttribute("to", places[1]);
        model.addAttribute("flights", searchResult);
        model.addAttribute("flight", new Flight());

        return "flightSearch";
    }*/


    /*@RequestMapping(value="/search", method= RequestMethod.POST)
    public String flightSearch(@ModelAttribute("flight") Flight flight, Model model) {

        List<Flight> searchResult = getSearchResult(flight.getSource(), flight.getDestination());

        model.addAttribute("from", flight.getSource());
        model.addAttribute("to", flight.getDestination());
        model.addAttribute("flights", searchResult);

        return "flightSearch";
    }
    private List<Flight> getSearchResult(String from, String to){
        FlightLookUpService flightLookup = new FlightLookUpService();
        return flightLookup.getFlights(new Route(from, to));
    }*/
}
