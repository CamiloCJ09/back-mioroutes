package service.implement;

import firebase.FirebaseInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import service.RoutesManagementService;

@Service
@ComponentScan("firebase")
public class RouteManagementServiceImplement implements RoutesManagementService {

    @Autowired
    private FirebaseInitializer firebaseInitializer;

    @Override
    public void add() {

    }

    @Override
    public void get() {

    }
}
