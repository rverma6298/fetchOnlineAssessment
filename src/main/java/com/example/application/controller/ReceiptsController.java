package com.example.application.controller;

import com.example.application.model.Id;
import com.example.application.model.Points;
import com.example.application.model.ReceiptInfo;
import com.example.application.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

import java.util.UUID;

@RestController
@RequestMapping(value = "/receipts", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReceiptsController {

    private static final String RECEIPT_PROCESS = "/process";
    private static final String RECEIPT_POINTS  = "/{receipt_id}/points";

    LoggerContext context = new LoggerContext();
    private final Logger LOGGER = context.getLogger("ReceiptsController");

    @Autowired
    private ReceiptService receiptService;


    @ResponseBody
    @PostMapping(RECEIPT_PROCESS)
    public ResponseEntity<Id> processReceipt(@RequestBody ReceiptInfo receiptInfo) {
        if(receiptInfo == null) {
            LOGGER.info("receiptInfo is null");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{
            Id id = receiptService.processReceipt(receiptInfo);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch(Exception e) {
            LOGGER.error("Something went wrong while trying to process the receipt{}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseBody
    @GetMapping(RECEIPT_POINTS)
    public ResponseEntity<Points> getPoints(@PathVariable UUID receipt_id) {
        try{
            Points points = receiptService.getPoints(receipt_id);
            if(points == null) {
                LOGGER.info("No receipt found for that id :{}", receipt_id.toString());
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(points, HttpStatus.OK);
        } catch(Exception e) {
            LOGGER.error("Something went wrong while trying to get the receipt with id: {} {}", receipt_id.toString(), e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/projectName")
    public String getProjectName() {
        return "HITTING THE ENDPOINT";
    }
}
