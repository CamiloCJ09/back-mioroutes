package model;

import java.util.ArrayList;

public class Vertice<K> {

    private K key;
    private int value;
    private ArrayList<Edge<K>> edges;

    public Vertice(K key){
        this.key = key;
        //value = (int) key;
        edges = new ArrayList<Edge<K>>();
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
}