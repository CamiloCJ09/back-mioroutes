package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
    void addVertice1(){
        setup1();
        graph.addVertice(1);
        assertTrue(graph.existVertice(1));
    }

    @Test
    void existVertice(){
        setup1();
        graph.addVertice(1);
        graph.addVertice(3);
        assertFalse(graph.existVertice(2));

    }

    @Test
    void addEdge1(){
        setup2();
        graph.addEdge(1,2,5);
        assertEquals(5,graph.searchVertice(1).searchWeight(2));
    }



    @Test
    void addEdge3(){
        setup4();
        graph.addEdge(1,2,5);
        assertEquals(5,graph.searchVertice(1).searchWeight(2));
    }

    @Test
    void edit1(){
       setup3();
       graph.edit(1,0);
       assertFalse(graph.existVertice(1));
    }
    @Test
    void edit2(){
        setup3();
        graph.edit(1,20,10);
        assertEquals(20,graph.searchVertice(1).searchWeight(3));

    }

    @Test
    void floydWarShall(){
        setup3();
    }

    @Test
    void prim(){
        setup3();
    }


}
