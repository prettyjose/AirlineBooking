package airline.repository;

import airline.models.Aircraft;
import airline.models.TravelClass;
import airline.models.TravelClassManager;
import airline.models.TravelClasses;

import java.util.HashMap;
import java.util.Map;

public
class AircraftRepository {

    private static Map<String, Aircraft> aeroPlaneList;
    private
    AircraftRepository(){

    }
    public
    static Map<String, Aircraft> getAircrafts(){
        if(aeroPlaneList != null){
            return aeroPlaneList;
        }else {
            aeroPlaneList = new HashMap<String, Aircraft>();

            TravelClassManager travelClassManager = new TravelClassManager();
            TravelClass travelClass = new TravelClass(TravelClasses.ECONOMY, 195, 6000.0);
            travelClassManager.setEconomyClass(travelClass);
            travelClass = new TravelClass(TravelClasses.BUSINESSCLASS, 35, 13000.0);
            travelClassManager.setBusinessClass(travelClass);
            travelClass = new TravelClass(TravelClasses.FIRSTCLASS, 8, 20000.0);
            travelClassManager.setFirstClass(travelClass);
            aeroPlaneList.put("BOEING_777", new Aircraft("BOEING777", travelClassManager));


            travelClassManager = new TravelClassManager();
            travelClass = new TravelClass(TravelClasses.ECONOMY, 152, 5000.0);
            travelClassManager.setEconomyClass(travelClass);
            travelClass = new TravelClass(TravelClasses.BUSINESSCLASS, 20, 10000.0);
            travelClassManager.setBusinessClass(travelClass);
            travelClass = new TravelClass(TravelClasses.FIRSTCLASS, 0, 0.0);
            travelClassManager.setFirstClass(travelClass);
            aeroPlaneList.put("AIRBUS_A321", new Aircraft("Airbus A321", travelClassManager));

            return aeroPlaneList;
        }
    }
}
