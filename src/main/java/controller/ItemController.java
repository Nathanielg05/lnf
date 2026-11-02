package controller;

import model.Item;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

//REST controller annotation so the fronend can send/recieve JSON data via HTTP requests
@RestController 
@RequestMapping ("/api/items")
@CrossOrigin (origins = "*") //allows frontend to talk to backend smoothly
public class ItemController {

    //POST endpoint to handle Step 3 (saving item and returning summary data)
    @PostMapping("/submit")
    public ResponseEntity<Item> submitItem(@RequestBody Item newItem) {
        try {
            // Get connection to Firebase Firestore database
            Firestore dbFirestore = FirestoreClient.getFirestore();
            
            // Save item into the "items" collection in Firestore
            // Firestore automatically generates a unique Document ID (docID) docID)
            String docID = dbFirestore.collection("items").document().getId();
            newItem.setID(docID);
            
            dbFirestore.collection("items").document(docID).set(newItem).get();

            // Return saved item back to frontend for the summary page display
            return ResponseEntity.ok(newItem);
            
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
    
}
