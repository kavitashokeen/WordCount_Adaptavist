package com.kavita.adaptavist.kafkawordcountdemo.controller;

import com.kavita.adaptavist.kafkawordcountdemo.response.ResponseMessage;
import com.kavita.adaptavist.kafkawordcountdemo.service.FileService;
import com.kavita.adaptavist.kafkawordcountdemo.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/producer-app")
public class EventController {

    @Autowired
    private KafkaMessagePublisher publisher;

    @Autowired
    private FileService fileService;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message)
    {
        try {
            publisher.sendMessageToTopic(message);
            return ResponseEntity.ok("message send Successfully");
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file)
    {
        if(fileService.hasCsvFormat(file))
        {

            try{
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));

                fileReader.lines().forEach(line -> publisher.sendMessageToTopic(line));
                fileReader.close();
                return ResponseEntity.ok(new ResponseMessage("File send Successfully"));
            } catch(FileNotFoundException e){
                System.out.println("Error, file not found");
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Please upload CSV file"));

            } catch(IOException e){
                System.out.println("Error occur during reading file");
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Please upload CSV file"));

            }


        }

        return ResponseEntity.ok(new ResponseMessage("File send to Kafka successfully"));


    }

}
