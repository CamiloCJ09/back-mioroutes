package service.implement;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import dto.RouteDto;
import dto.StationDto;
import firebase.FirebaseInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import service.RoutesManagementService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
@ComponentScan({"firebase"})
public class RouteManagementServiceImplement implements RoutesManagementService {

    @Autowired
    private FirebaseInitializer firebaseInitializer;

    //@Autowired
    private RouteDto dto = new RouteDto() ;
    private static final String ID = "nEj6euolxpv8t1mzMpFT";


    @Override
    public boolean calculateRoute(int initialPoint, int finalPoint) {
        dto.createRoute(initialPoint,finalPoint);
        Map<String,Object> document = getDocument();
        CollectionReference post = getCollection();
        ApiFuture<WriteResult> writeResultApiFuture = post.document(ID).set(document);
        try {
            if (null!=writeResultApiFuture.get()){
                return true;
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<StationDto> getStations() {
        List<StationDto> response = new ArrayList<>();
        StationDto post;
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection2().get();

        try {
            for (DocumentSnapshot doc:querySnapshotApiFuture.get().getDocuments()) {
                post = doc.toObject(StationDto.class);
                post.setId(doc.getId());
                response.add(post);
            }

            return response;
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("null");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addStations() {
        Map<String,Object> document = new HashMap<>();
        ApiFuture<WriteResult> writeResultApiFuture = null;
        boolean finished = false;
        for (int i = 0; i <dto.getManager().getGraph().getVertices().size() ; i++) {
            document.put("name",dto.getManager().getGraph().getVertices().get(i).getValue());
            document.put("value", dto.getManager().getGraph().getVertices().get(i).getKey());
            CollectionReference post = getCollection2();
            writeResultApiFuture = post.document().create(document);
            try {
                if(writeResultApiFuture.get()!=null){
                    finished = true;
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        return finished;




    }

    @Override
    public boolean costOfAllCity(int initialPoint) {
        Map<String,Object> document = new HashMap<>();
        document.put("totalCost",dto.getManager().getGraph().printPrim(dto.getManager().getGraph().prim(initialPoint)));
        CollectionReference post = getCollection();
        ApiFuture<WriteResult> writeResultApiFuture = post.document("allCali").set(document);
        try {
            if (null!=writeResultApiFuture.get()){
                return true;
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Map<String,Object>getDocument() {
        Map<String,Object> dataDocument = new HashMap<>();
        dataDocument.put("best-route",dto.getBestRoute());
        return dataDocument;
    }

    private CollectionReference getCollection() {
        return firebaseInitializer.getFireStore().collection("routes");
    }

    private CollectionReference getCollection2() {
        return firebaseInitializer.getFireStore().collection("vertex");
    }
}
