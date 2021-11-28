package dto;

import model.Manager;


/*
     Esta clase es la que se va a encargar de guardar la informacion de las rutas
     y generar el objeto que se va a guardar en la base de datos. Esta clase será
     la conexion del backend con el frontEnd
     */
public class RouteDto {
    private Manager manager;
    private String id;
    private String bestRoute;
    private String cost;


    public RouteDto(){
        manager = new Manager();
    }



    public void createRoute(int initialPoint, int finalPoint){
         bestRoute = manager.bestRoute(initialPoint, finalPoint);
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBestRoute() {
        return bestRoute;
    }

    public void setBestRoute(String bestRoute) {
        this.bestRoute = bestRoute;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }






}
