package model;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private Graph<Integer> graph;
    private int numOfStations;
    private Scanner sc;
    private File file;
    private static String FILE_ROUTE = "src/main/resources/static/data/graph.csv";

    void  setup1(){
        this.graph = new Graph<>(false);
        this.file = new File(FILE_ROUTE);
        try {
            this.sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error creating graph");
        }
        while(sc.hasNextLine()){
            String data = sc.nextLine();
            String[] splitData = data.split(";");
            if(splitData[0].equals("0")){
                //System.out.println("Añado a: "+splitData[1]);
                graph.addVertice(Integer.valueOf(splitData[2]),splitData[1]);
            }else{
                //System.out.println("Creo camino entre: "+splitData[1]+" y "+splitData[2]);
                graph.addEdge(Integer.valueOf(splitData[1]),Integer.valueOf(splitData[2]),1);
            }
        }
        sc.close();
        this.numOfStations = graph.getVertices().size();
        graph.initialize();
        graph.floydWarshall(numOfStations-1);
    }

    @Test
    void bestRoute() {
        setup1();
    }
}