package model;

import java.util.ArrayList;

public class Graph<K>{

    private boolean directed;
    private ArrayList<Vertice<K>> vertices;
    private ArrayList<Edge> edges;

    public Graph(boolean directed){
        this.directed = directed;
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addVertice(K key){
        Vertice<K> v = new Vertice<>(key);
        vertices.add(v);
    }

    public void addEdge(K sourceKey, K endKey, int weight){
        Vertice<K> source = null;
        Vertice<K> end = null;
        for(int i = 0; i<vertices.size(); i++){
            if(vertices.get(i).getKey() == sourceKey){
                source = vertices.get(i);
            }
        }
        for(int i = 0; i<vertices.size(); i++){
            if(vertices.get(i).getKey() == endKey){
                end = vertices.get(i);
            }
        }
        if(directed) {
            Edge<K> e = new Edge<>(source, end, weight);
            edges.add(e);
            source.getEdges().add(e);
        }else{
            Edge<K> e1 = new Edge<>(source, end, weight);
            Edge<K> e2 = new Edge<>(end, source, weight);
            edges.add(e1);
            edges.add(e2);
            source.getEdges().add(e1);
            end.getEdges().add(e2);
        }
    }

    public boolean existVertice(K key){
        boolean exist = false;
        for(int i = 0; i<vertices.size() && !exist; i++){
            if(vertices.get(i).getKey() == key){
                exist = true;
            }
        }
        return exist;
    }

    public Vertice<K> searchVertice(K key){
        boolean exist = false;
        Vertice<K> v = null;
        for(int i = 0; i<vertices.size() && !exist; i++){
            if(vertices.get(i).getKey() == key){
                exist = true;
                v = vertices.get(i);
            }
        }
        return v;
    }


    public void edit(K key ,K newValue){
        Vertice<K> toEdit = searchVertice(key);
        toEdit.setKey(newValue);
    }

    public void edit(K key ,int newValue, int oldValue){
        Vertice<K> toEdit = searchVertice(key);
        boolean out = false;
        for (int i = 0; i < toEdit.getEdges().size() && !out; i++) {
            if (toEdit.getEdges().get(i).getWeight() == oldValue){
                toEdit.getEdges().get(i).setWeight(newValue);
                out = true;
            }
        }
    }
}