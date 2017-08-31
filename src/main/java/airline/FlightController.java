package airline;

import airline.models.FlightsFromTo;

import airline.models.Route;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajashrk on 8/8/17.
 */
@Controller
@SpringBootApplication
public class FlightController {

    public static void main(String []args) {
        SpringApplication.run(FlightController.class,args);
    }


    @RequestMapping("/")
    public String welcomeMessage(Model model) {
        model.addAttribute("message", "Welcome!");
        return "flightwelcome";
    }

    @RequestMapping(value="/helloWorld", method= RequestMethod.GET)
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        return "flightwelcome";
    }

    @RequestMapping(value="/search/{route}", method= RequestMethod.POST)
    public String flightSearch(@PathVariable(value="route") String route, Model model) {
        String[] places = route.split("_");

        List<FlightsFromTo> searchResult = getSearchResult(places[0], places[1]);

        model.addAttribute("from", places[0]);
        model.addAttribute("to", places[1]);
        model.addAttribute("flights", searchResult);
        model.addAttribute("flight", new FlightsFromTo());

        return "flightSearch";
    }


    @RequestMapping(value="/search", method= RequestMethod.GET)
    public String flightSearch(Model model) {
//    public String flightSearch(@RequestParam("dropOperator") String selectedVal, Model model) {


        List<FlightsFromTo> searchResult = getSearchResult("blr", "hyd");

        model.addAttribute("from", "blr");
        model.addAttribute("to", "hyd");
        model.addAttribute("flights", searchResult);
        model.addAttribute("flight", new FlightsFromTo());

        return "flightSearch";
    }
    private List<FlightsFromTo> getSearchResult(String from, String to){
        return getFlights(chartFlights(), new Route(from, to));
    }
    private List<FlightsFromTo> chartFlights(){
        List<FlightsFromTo> flightList=new ArrayList<FlightsFromTo>();
        flightList.add(new FlightsFromTo("Flight No. One", "blr", "hyd"));
        flightList.add(new FlightsFromTo("Flight No. Two", "cok", "hyd"));
        flightList.add(new FlightsFromTo("Flight No. Three", "blr", "hyd"));
        return flightList;
    }
    private List<FlightsFromTo> getFlights(List<FlightsFromTo> flightList, Route route){
        List<FlightsFromTo> flightsFromTos=new ArrayList<FlightsFromTo>();
        for(FlightsFromTo thisFlight: flightList){
            if(route.getSource().equals(thisFlight.getSource()) && route.getDestination().equals(thisFlight.getDestination())){
                flightsFromTos.add(thisFlight);
                System.out.println(thisFlight.getFlightNum());
            }
        }
        return flightsFromTos;
    }


}
