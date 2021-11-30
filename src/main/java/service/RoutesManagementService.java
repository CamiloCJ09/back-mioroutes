package service;

import dto.RouteDto;
import dto.StationDto;

import java.util.List;

public interface RoutesManagementService {

    //Adecuar al contexto del uso del modelo
   boolean calculateRoute(int initialPoint, int finalPoint);

   List<StationDto> getStations();

   boolean addStations();

   boolean costOfAllCity(int initialPoint);

   RouteDto getBestRoute();

   RouteDto getBestcostOfAllCity();




}
