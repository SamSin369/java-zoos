package com.example.javazoo.controllers;

import com.example.javazoo.models.Zoo;
import com.example.javazoo.repositories.EmailRepository;
import com.example.javazoo.services.ZooService;
import com.example.javazoo.textscanner.ReadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController {

    @Autowired
    private ZooService zooService;
    @Autowired
    EmailRepository emailrepos;
    @Autowired
    ReadFile file;

    @GetMapping(value = "/zoos",
    produces = "application/json")
    public ResponseEntity<?> findAllZoos()
    {
        List<Zoo> allZoos = zooService.findAll();
        return new ResponseEntity<>(allZoos, HttpStatus.OK);
    }
    @GetMapping(value = "/zoos/{zooid}",
    produces = "application/json")
    public ResponseEntity<?> findZooById(@PathVariable  Long zooid)
    {
        Zoo zoo = zooService.findZooById(zooid);
        return  new ResponseEntity<>(zoo, HttpStatus.OK);
    }
    @GetMapping(value = "/emails",
    produces = "application/json"
    )
    public ResponseEntity<?> findAllEmails()
    {
      file.loadFile();
        return new ResponseEntity<>(emailrepos.findAll(), HttpStatus.ACCEPTED);
    }
}
