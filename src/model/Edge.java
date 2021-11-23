package model;

public class Edge<K> {

    private Vertice<K> source;
    private Vertice<K> end;
    private int weight;

    public Edge(Vertice<K> source, Vertice<K> end, int weight){
        this.source = source;
        this.end = end;
        this.weight = weight;
    }

    public Vertice<K> getSource() {
        return source;
    }

    public void setSource(Vertice<K> source) {
        this.source = source;
    }

    public Vertice<K> getEnd() {
        return end;
    }

    public void setEnd(Vertice<K> end) {
        this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}