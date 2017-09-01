package airline.repository;

import airline.models.Aircraft;

import java.util.HashMap;
import java.util.Map;

public
class Aircrafts {

    private static Map<String, Aircraft> aeroPlaneList;
    private
    Aircrafts(){

    }
    public
    static Map<String, Aircraft> getAircrafts(){
        if(aeroPlaneList != null){
            return aeroPlaneList;
        }else {
            aeroPlaneList = new HashMap<String, Aircraft>();

            aeroPlaneList.put("BOEING747", new Aircraft("BOEING747", 30));
            aeroPlaneList.put("BOEING777", new Aircraft("BOEING777", 45));

            return aeroPlaneList;
        }
    }
}
