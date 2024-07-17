package com.example.application.service;

import com.example.application.model.Id;
import com.example.application.model.Item;
import com.example.application.model.Points;
import com.example.application.model.ReceiptInfo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ReceiptService {
    private final Map<UUID, Integer> receiptPointsMap = new HashMap<>();

    public Id processReceipt(ReceiptInfo receiptInfo) {
        Id id = new Id(UUID.randomUUID());

        int points = calculatePoints(receiptInfo);
        receiptPointsMap.put(id.getId(), points);
        return id;
    }

    public Points getPoints(UUID receiptId) {
        if(receiptPointsMap.containsKey(receiptId)) {
            return new Points(receiptPointsMap.get(receiptId));
        }
        return null;
    }

    private int calculatePoints(ReceiptInfo receiptInfo) {
        int points = 0;

        points+=receiptInfo.getRetailer().replaceAll("[^a-zA-Z0-9]", "").length();

        if(receiptInfo.getTotal().endsWith(".00")) {
            points += 50;
        }

        if(Double.parseDouble(receiptInfo.getTotal()) % 0.25 == 0){
            points += 25;
        }

        points += (receiptInfo.getItems().size() /2 ) * 5;

        for(Item item: receiptInfo.getItems()) {
            String description = item.getDescription().trim();
            if(description.length() %3 ==0) {
                double price = Double.parseDouble(item.getPrice());
                points += Math.ceil(price * 0.2);
            }
        }

        String day = receiptInfo.getPurchaseDate().split("-")[2];
        if(Integer.parseInt(day) % 2 != 0) {
            points += 6;
        }


        String[] timeParts = receiptInfo.getPurchaseTime().split(":");
        int hour = Integer.parseInt(timeParts[0]);
        int minute = Integer.parseInt(timeParts[1]);
        if(hour == 14 || (hour == 15 && minute == 0)) {
            points += 10;
        }

        return points;
    }
}
