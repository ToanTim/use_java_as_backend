package com.example.hotel_booking.Room;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Room {
  private String bulding;
  private String roomNumber;
  private boolean status;
  private String customerName;
  private String roomSize;
  private String roomId;
  private int numberOfCustomer;
  private int numberOfNight;

}
