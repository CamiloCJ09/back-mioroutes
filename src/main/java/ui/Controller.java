package ui;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.RoutesManagementService;

@RestController
@RequestMapping(value = "/routes")
@ComponentScan("service")
public class Controller {

    @Autowired
    private RoutesManagementService service;
    //Agregar metodos POST y GET requeridos


}
