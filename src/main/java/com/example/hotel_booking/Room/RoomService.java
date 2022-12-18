package com.example.hotel_booking.Room;

import java.nio.file.FileStore;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;
import com.google.firebase.cloud.FirestoreClient;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;

@Service
public class RoomService {

  public Room getRoom(String roomId) throws InterruptedException, ExecutionException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    DocumentReference documentReference = dbFirestore.collection("room").document(roomId);
    ApiFuture<DocumentSnapshot> future = documentReference.get();
    DocumentSnapshot document = future.get();
    Room room;
    if (document.exists()) {
      room = document.toObject(Room.class);
      return room;
    }
    return null;
  }

  public List<QueryDocumentSnapshot> getRoomList() throws Exception {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    // [START firestore_data_get_all_documents]
    // asynchronously retrieve all documents
    ApiFuture<QuerySnapshot> future = dbFirestore.collection("room").get();
    // future.get() blocks on response
    List<QueryDocumentSnapshot> documents = future.get().getDocuments();
    for (QueryDocumentSnapshot document : documents) {
      System.out.println(document.getId() + " => " + document.toObject(Room.class));
    }
    // [END firestore_data_get_all_documents]
    return documents;
  }

  public String updateRoom(Room room) throws InterruptedException, ExecutionException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("room").document(room.getRoomNumber())
        .set(room, SetOptions.merge());

    return "update room success";

  }
}
