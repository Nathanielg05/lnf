package com.example.lostandfound.controller;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.example.lostandfound.model.Item;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    // POST: Save a lost/found item to Firestore
    @PostMapping
    public String addItem(@RequestBody Item item) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        dbFirestore.collection("items").document(item.getID()).set(item);
        return "Item saved successfully!";
    }

    // GET: Retrieve all items from Firestore
    @GetMapping
    public List<Item> getItems() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        List<Item> itemList = new ArrayList<>();
        var future = dbFirestore.collection("items").get();
        for (var document : future.get().getDocuments()) {
            itemList.add(document.toObject(Item.class));
        }
        return itemList;
    }
}