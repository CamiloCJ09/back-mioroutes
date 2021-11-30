package ui;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.RoutesManagementService;

@RestController
@RequestMapping(value = { "/vertex","/routes","/routeAll"})
@ComponentScan("service")
public class Controller {

    @Autowired
    private RoutesManagementService service;

    //Floyd
    @PutMapping (value = "calculate/{initialPoint}/{finalPoint}")
    public ResponseEntity calculateBestRoute(@PathVariable String finalPoint, @PathVariable String initialPoint){
        try {
            int firtspoint = Integer.parseInt(initialPoint);
            int lastPoint = Integer.parseInt(finalPoint);
            return new ResponseEntity(service.calculateRoute(firtspoint,lastPoint),HttpStatus.OK);
        }catch (NumberFormatException exception){
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }

    }

    //Prim
    @PutMapping(value = "allCity/")
    public ResponseEntity costOfAllCity(@PathVariable String initialPoint){
        return new ResponseEntity(service.costOfAllCity(0),HttpStatus.OK);
    }


    @GetMapping(value = "/get")
    public ResponseEntity getStations(){
        return new ResponseEntity(service.getStations(), HttpStatus.OK);
    }


    @PostMapping(value = "/add")
    public ResponseEntity addStation(){
        return new ResponseEntity(service.addStations(),HttpStatus.OK);
    }

    //routes/getBestRoute
    @GetMapping(value = "/getBestRoute")
    public ResponseEntity getBestRoute(){
        return new ResponseEntity(service.getBestRoute(),HttpStatus.OK);
    }

    //routeAll/getBestCostAllCity
    @GetMapping(value = "/getBestCostAllCity")
    public ResponseEntity getBestCost(){
        return new ResponseEntity(service.getBestcostOfAllCity(),HttpStatus.OK);
    }




}
