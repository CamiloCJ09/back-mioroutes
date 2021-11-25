package model;

import java.util.ArrayList;
import java.util.Vector;

public class Graph<K>{

    private boolean directed;
    private ArrayList<Vertice<K>> vertices;
    private ArrayList<Edge> edges;

    private static int [][]dis;
    private static int [][]next;

    public Graph(boolean directed){
        this.directed = directed;
        vertices = new ArrayList<>();
        edges = new ArrayList<>();

    }
    public void createMatrix(){
        dis = new int[vertices.size()][vertices.size()];
        next = new int[vertices.size()][vertices.size()];
    }
    public void initialize(){
        createMatrix();
        for(int i = 0; i < dis.length; i++){
            for(int j = 0; j < dis[0].length; j++){
                if(i== j){
                    dis[i][j] = 0;
                }else{
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(Vertice vertex : vertices){
            for(int i = 0; i < vertex.getEdges().size(); i++){
                if(vertex.getEdges().get(i) instanceof Edge){
                    if((((Edge<?>) vertex.getEdges().get(i)).getWeight()) < (dis[(int)vertex.getKey()-1][(int) ( (Edge<Integer>)vertex.getEdges().get(i)).getEnd().getKey()-1])){
                        dis[(int)vertex.getKey()-1][(int) ((Edge<Integer>) vertex.getEdges().get(i)).getEnd().getKey()-1] = (((Edge<?>) vertex.getEdges().get(i)).getWeight());
                    }
                    //System.out.println((int)vertex.getKey()-1 + " , "+ ((int) ((Edge<Integer>) vertex.getEdges().get(i)).getEnd().getKey()-1));
                    //System.out.println(dis[(int)vertex.getKey()-1][(int) ((Edge<Integer>) vertex.getEdges().get(i)).getEnd().getKey()-1]);
                }
            }
        }

        for(int i = 0; i < vertices.size(); i++){
            for(int j = 0; j < vertices.size(); j++){
                if(dis[i][j] == Integer.MAX_VALUE){
                    //System.out.println("Dis: "+dis[i][j]);
                    next[i][j] = -1;
                    //System.out.println("Dis: "+next[i][j]);
                }else{
                    //System.out.println("Dis: "+dis[i][j]);
                    next[i][j] = j;
                    //System.out.println("Dis: "+next[i][j]);
                }
            }
        }

    }

    public Vector<Integer> constructPath(int u, int v) {
        if (next[u][v] == -1)
            return null;

        Vector<Integer> path = new Vector<Integer>();
        path.add(u);

        while (u != v) {
            u = next[u][v];
            path.add(u);
        }
        return path;
    }

    public void printPath(Vector<Integer> path) {
        int n = path.size();
        for(int i = 0; i < n - 1; i++) {
            System.out.print(path.get(i) + " -> ");
        }
            System.out.print(path.get(n - 1) + "\n");

    }

    public void floydWarshall(int V) {
        for(int k = 0; k < V; k++) {
            for(int i = 0; i < V; i++) {
                for(int j = 0; j < V; j++) {

                    // We cannot travel through
                    // edge that doesn't exist
                    if (dis[i][k] == Integer.MAX_VALUE || dis[k][j] == Integer.MAX_VALUE) {
                        System.out.println("Entra aquí");
                        continue;
                    }

                    //System.out.println("Dis en i: "+i +" j "+j+" k "+k+" = "+dis[i][j] + " "+ dis[i][k]+ " "+dis[k][j] );
                    if (dis[i][j] > dis[i][k] + dis[k][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                        next[i][j] = next[i][k];
                        //System.out.println("Next 1: "+ i+" "+j+" "+next[i][j]);
                        //System.out.println("Next 2: "+ i+" "+k+" "+next[i][k]);

                    }
                }
            }
        }
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
}