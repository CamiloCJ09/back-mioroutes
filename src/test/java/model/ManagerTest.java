package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private Manager manager;
    void  setup1(){
        manager = new Manager();

    }

    @Test
    void bestRoute() {
        setup1();
        String espected = "Conquistadores,Villanueva,Santa Monica,Cien Palos,San Pascual,San Bosco,Santa Librada,Manzana del Saber,";
        String get = "";
        String bestPaht = manager.bestRoute(26,43);
        String [] split = bestPaht.split(",");
        for (String string: split) {
            for (int i = 0; i <manager.getGraph().getVertices().size() ; i++) {
                if(string.equals(String.valueOf(manager.getGraph().getVertices().get(i).getKey()))){
                    get+=manager.getGraph().getVertices().get(i).getValue()+",";
                }
            }
        }
        assertEquals(espected,get);

    }
}