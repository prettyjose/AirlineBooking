package airline.models;

public
class TravelClass {
    TravelClasses type;
    int totalSeats;
    Double price;

    public
    TravelClass(TravelClasses type, int totalSeats, Double price) {
        this.type = type;
        this.totalSeats = totalSeats;
        this.price = price;
    }

    public
    TravelClasses getType() {
        return type;
    }

    public
    void setType(TravelClasses type) {
        this.type = type;
    }

    public
    int getTotalSeats() {
        return totalSeats;
    }

    public
    void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

   public
    Double getPrice() {
        return price;
    }

    public
    void setPrice(Double price) {
        this.price = price;
    }

//    abstract public Double getDemandBasedPrice();
}
