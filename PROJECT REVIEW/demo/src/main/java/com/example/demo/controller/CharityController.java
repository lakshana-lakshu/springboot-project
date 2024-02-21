
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Charity;
import com.example.demo.service.CharityService;
@RestController
public class CharityController {
    @Autowired
    private final CharityService ch;
    public CharityController(CharityService ch) {
        this.ch = ch;
    }
    @PostMapping("/api/charity/add")
    public ResponseEntity<Charity> create(@RequestBody Charity obj)
    {
        return new ResponseEntity<>(ch.create(obj),HttpStatus.CREATED);
    }
    @GetMapping("/api/charity")
    public ResponseEntity<List<Charity>> getAll()
    {
        return new ResponseEntity<>(ch.getAll(),HttpStatus.OK);
    }
    @GetMapping("/api/charity/{charityId}")
    public ResponseEntity<Charity> getById(@PathVariable int charityId)
    {
        Charity obj = ch.getById(charityId);
            return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @PutMapping("/api/charity/update/{charityId}")
    public ResponseEntity<Charity> update(@PathVariable int charityId, @RequestBody Charity obj) {
        Charity existingCharity = ch.getById(charityId);
        if (existingCharity != null) {
            obj.setId(charityId); 
            ch.create(obj); 
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/charity/delete/{charityId}")
    public ResponseEntity<Void> delete(@PathVariable int charityId) {
        Charity existingCharity = ch.getById(charityId);
        if (existingCharity != null) {
            ch.delete(charityId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}