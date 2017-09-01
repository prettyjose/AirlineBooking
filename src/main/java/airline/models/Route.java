package airline.models;

public
class Route {
    Airport source;
    Airport destination;

    public
    Route(){

    }

    public
    Route(Airport source, Airport destination) {
        this.source = source;
        this.destination = destination;
    }

    public
    Airport getSource() {
        return source;
    }

    public
    Airport getDestination() {
        return destination;
    }

    public
    void setSource(Airport source) {
        this.source = source;
    }

    public
    void setDestination(Airport destination) {
        this.destination = destination;
    }
}
