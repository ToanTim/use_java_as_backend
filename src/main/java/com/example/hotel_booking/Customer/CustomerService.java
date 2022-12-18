package com.example.hotel_booking.Customer;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class CustomerService {

  public String createCustomer(Customer customer) throws InterruptedException, ExecutionException {
    Firestore dbFirestore = FirestoreClient.getFirestore();

    DocumentReference documentReference = dbFirestore.collection("customer").document(customer.getEmail());
    ApiFuture<DocumentSnapshot> future = documentReference.get();
    DocumentSnapshot document = future.get();

    if (document.exists()) {
      return "you are already sign up, pls sign in";
    } else {
      ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("customer").document(customer.getEmail())
          .set(customer, SetOptions.merge());
      return collectionsApiFuture.get().getUpdateTime().toString();
    }

  }

  public Customer getCustomer(String customerId) throws InterruptedException, ExecutionException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    DocumentReference documentReference = dbFirestore.collection("customer").document(customerId);
    ApiFuture<DocumentSnapshot> future = documentReference.get();
    DocumentSnapshot document = future.get();
    Customer customer;
    if (document.exists()) {
      customer = document.toObject(Customer.class);

      return customer;
    }
    return null;
  }

  public Customer getCustomerByEmail(String customerEmail) throws InterruptedException, ExecutionException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    DocumentReference documentReference = dbFirestore.collection("customer").document(customerEmail);
    ApiFuture<DocumentSnapshot> future = documentReference.get();
    DocumentSnapshot document = future.get();
    Customer customer;
    if (document.exists()) {
      customer = document.toObject(Customer.class);
      return customer;
    }
    return null;
  }

  public String updateCustomer(Customer customer) throws InterruptedException, ExecutionException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("customer").document(customer.getEmail())
        .set(customer, SetOptions.merge());

    return "update password success";

  }

  public String deleteCustomer(String customerEmail) {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> writeResult = dbFirestore.collection("customer").document(customerEmail).delete();

    return "Successfully deleted" + customerEmail;
  }

}
