package service;

import dto.StationDto;

import java.util.List;

public interface RoutesManagementService {

    //Adecuar al contexto del uso del modelo
   String calculateRoute(int initialPoint, int finalPoint);

   List<StationDto> getStations();

   boolean addStations();



}
