package airline.models;

public
class Route {
    String source, destination;

    public
    Route(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    public
    String getSource() {
        return source;
    }

    public
    String getDestination() {
        return destination;
    }
}
