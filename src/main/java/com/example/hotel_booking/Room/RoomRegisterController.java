package com.example.hotel_booking.Room;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.firebase.cloud.FirestoreClient;
import com.google.cloud.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RoomRegisterController {

  @Autowired
  public RoomService roomService;

  @GetMapping("/get_room")
  public Room getRoom(@RequestParam String roomId) throws InterruptedException, ExecutionException {
    return roomService.getRoom(roomId);
  }

  @GetMapping("/get_room_list")
  public List<QueryDocumentSnapshot> getRoomList() throws Exception {
    return roomService.getRoomList();
  }

  @PutMapping("/room_update")
  public String updateRoom(@RequestBody Room room) throws InterruptedException, ExecutionException {
    return roomService.updateRoom(room);
  }

}
