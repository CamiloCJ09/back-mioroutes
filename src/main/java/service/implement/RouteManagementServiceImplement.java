package service.implement;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.WriteResult;
import dto.RouteDto;
import firebase.FirebaseInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import service.RoutesManagementService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
@ComponentScan("firebase")
public class RouteManagementServiceImplement implements RoutesManagementService {

    @Autowired
    private FirebaseInitializer firebaseInitializer;

    private RouteDto dto = new RouteDto();

    @Override
    public String calculateRoute(int initialPoint, int finalPoint) {
        dto.createRoute(initialPoint,finalPoint);
        Map<String,Object> document = getDocument();
        CollectionReference post = getCollection();
        ApiFuture<WriteResult> writeResultApiFuture = post.document().create(document);
        try {
            if (null!=writeResultApiFuture.get()){
                return "Mejor ruta: "+dto.getBestRoute()+"\n"+
                        "Costo: "+dto.getCost();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return "";
    }

    private Map<String,Object>getDocument() {
        Map<String,Object> dataDocument = new HashMap<>();
        dataDocument.put("best-route",dto.getBestRoute());
        dataDocument.put("cost",dto.getCost());
        return dataDocument;
    }

    private CollectionReference getCollection() {
        return firebaseInitializer.getFireStore().collection("post");
    }
}
