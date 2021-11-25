package model;

import java.util.ArrayList;

public class Vertice<K> {

    private K key;
    private ArrayList<Edge> edges;

    public Vertice(K key){
        this.key = key;
        edges = new ArrayList<>();
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public int searchWeight(K endKey){
        boolean found = false;
        int sWeight = 0;
        for(int i = 0; i<edges.size() && !found; i++){
            if(edges.get(i).getEnd().getKey() == endKey){
                sWeight = edges.get(i).getWeight();
                found = true;
            }
        }
        return sWeight;
    }
}