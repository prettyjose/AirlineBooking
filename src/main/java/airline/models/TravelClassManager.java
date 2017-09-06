package airline.models;

public
class TravelClassManager {
    TravelClass economyClass;
    TravelClass firstClass;
    TravelClass businessClass;


    public
    TravelClass getEconomyClass() {
        return economyClass;
    }

    public
    void setEconomyClass(TravelClass economyClass) {
        this.economyClass = economyClass;
    }

    public
    TravelClass getFirstClass() {
        return firstClass;
    }

    public
    void setFirstClass(TravelClass firstClass) {
        this.firstClass = firstClass;
    }

    public
    TravelClass getBusinessClass() {
        return businessClass;
    }

    public
    void setBusinessClass(TravelClass businessClass) {
        this.businessClass = businessClass;
    }
}
