package model;

public class Manager{
    //Clase responsable de crear las rutas según con 2 nodos dados

    private Graph graph;
    private int numOfStations;
    public Manager(){
        this.graph = new Graph(false);
        this.numOfStations = graph.getVertices().size();
        graph.floydWarshall(numOfStations-1);
        //
    }
    public String bestRoute(int initialPoint, int finalPoint){
        return graph.printPath(graph.constructPath(initialPoint, finalPoint));
    }
}
