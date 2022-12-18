package com.example.hotel_booking.Customer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.cloud.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Customer {
  private String dayOfBooking;
  private String customerId;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String room;
  private int numberOfNight;
  private boolean bookingStatus;

}
