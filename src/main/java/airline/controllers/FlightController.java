package airline.controllers;

import airline.models.Flight;
import airline.models.EachResultLine;
import airline.repository.AirportRepository;

import airline.models.SearchCriteria;
import airline.services.FlightLookUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


/**
 * Created by rajashrk on 8/8/17.
 */
@Controller
public class FlightController {

    @Autowired  //implies no need to initialise flightLookUpService object. It keeps it as a Singleton object.
    private FlightLookUpService flightLookUpService;

    @RequestMapping("/")
    public String welcomeMessage(Model model) {
        model.addAttribute("welcomemessage", "Welcome to Vapasi FlightRepository");
        model.addAttribute("airports", AirportRepository.getAirports());
        model.addAttribute("searchCriteria", new SearchCriteria());
        return "flightwelcome";
    }

    @RequestMapping(value="/flights/search", method = RequestMethod.POST)//{route}
    public String searchFlights(@ModelAttribute("searchCriteria") SearchCriteria searchCriteria, Model model) {
        //Todo: empty num of passengers+ grayed text and tooltip.
        model.addAttribute("welcomemessage", "Welcome to Vapasi FlightRepository");
//        List<Flight> flights = flightLookUpService.getFlights(searchCriteria);
//        model.addAttribute("flights", flights);


        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(2017, Calendar.SEPTEMBER, 10,0,0,0);
        calendar.set(Calendar.MILLISECOND, 0);
        searchCriteria.setFlightDate(calendar.getTime());


        List<EachResultLine> searchResult = flightLookUpService.searchFlights(searchCriteria);
        model.addAttribute("searchResult", searchResult);
        if(searchResult.size() == 0){
            model.addAttribute("noflightfoundmessage", "No flights found for the provided search criteria");
        }

        model.addAttribute("airports", AirportRepository.getAirports());
        return "flightsView";
    }
}
