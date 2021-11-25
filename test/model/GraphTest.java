package model;

import org.junit.jupiter.api.Test;

public class GraphTest {

    private Graph<Integer> graph;

    void setup1(){
        this.graph = new Graph<>(false);
    }

    void setup2(){
        this.graph = new Graph<>(false);
        graph.addVertice(1);
        graph.addVertice(2);
        graph.addVertice(3);
        graph.addVertice(4);
    }

    void setup3(){
        this.graph = new Graph<>(false);
        graph.addVertice(1);
        graph.addVertice(2);
        graph.addVertice(3);
        graph.addVertice(4);
        graph.addEdge(1,2,5);
        graph.addEdge(1,3,10);
        graph.addEdge(1,4,6);
    }

    void setup4(){
        this.graph = new Graph<>(true);
        graph.addVertice(1);
        graph.addVertice(2);
        graph.addVertice(3);
        graph.addVertice(4);
    }

    @Test
    public void addVertice5(){
        setup3();
        graph.initialize();
        graph.floydWarshall(4);
        graph.printPath(graph.constructPath(1,3));
    }

    @Test
    void addVertice1(){
        setup1();
        graph.addVertice(1);
        assert graph.existVertice(1);
    }

    @Test
    void addVertice2(){
        setup1();
        graph.addVertice(1);
        graph.addVertice(3);
        assert !graph.existVertice(2);
    }

    @Test
    void addEdge1(){
        setup2();
        graph.addEdge(1,2,5);
        assert (graph.searchVertice(1).searchWeight(2) == 5);
    }

    @Test
    void addEdge2(){
        setup2();
        graph.addEdge(1,2,5);
        assert (graph.searchVertice(2).searchWeight(1) == 5);
    }

    @Test
    void addEdge3(){
        setup4();
        graph.addEdge(1,2,5);
        assert (graph.searchVertice(1).searchWeight(2) == 5);
    }

    @Test
    void addEdge4(){
        setup4();
        graph.addEdge(1,2,5);
        assert (graph.searchVertice(2).searchWeight(1) == 0);
    }
}
