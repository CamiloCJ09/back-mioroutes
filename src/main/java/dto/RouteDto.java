package dto;

import model.Manager;
import org.springframework.web.bind.annotation.RequestMapping;

public class RouteDto {
    private Manager manager;

    public RouteDto(){
        manager = new Manager();
    }
    /*
     Esta clase es la que se va a encargar de guardar la informacion de las rutas
     y generar el objeto que se va a guardar en la base de datos. Esta clase será
     la conexion del backend con el frontEnd
     */

    @RequestMapping(value = "{initialPoint}{finalPoint}")
    public String createRoute(int initialPoint, int finalPoint){
        return manager.bestRoute(initialPoint, finalPoint);
    }
    //@RequestMapping( value = {})

}
