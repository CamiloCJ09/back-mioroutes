package dto;

public class BestRouteDto {
    private String id;
    private String bestRoute;

    public BestRouteDto() {

    }

    public String getBestRoute() {
        return bestRoute;
    }

    public void setBestRoute(String bestRoute) {
        this.bestRoute = bestRoute;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
