package model;

import java.util.ArrayList;

public class Vertice<K> {

    private K key;
    private String value;
    private ArrayList<Edge<K>> edges;
    private boolean visited;

    public Vertice(K key){
        this.key = key;
        //value = (int) key;
        edges = new ArrayList<Edge<K>>();
        this.visited = false;
    }

    public Vertice(K key, String value){
        this.key = key;
        this.value = value;
        edges = new ArrayList<Edge<K>>();
        this.visited = false;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public ArrayList<Edge<K>> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge<K>> edges) {
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}