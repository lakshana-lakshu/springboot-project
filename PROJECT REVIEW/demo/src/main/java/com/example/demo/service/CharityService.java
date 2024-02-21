
package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Charity;
import com.example.demo.repository.CharityRepo;
@Service
public class CharityService {
    @Autowired
    private final CharityRepo ch;
    public CharityService(CharityRepo ch) {
        this.ch = ch;
    }
    public Charity create(Charity obj)
    {
        return ch.save(obj);
    }
    public List<Charity> getAll()
    {
        return ch.findAll();
    }
    public Charity getById(int id)
    {
        return ch.findById(id).orElse(null);
    }
    public void delete(int id) {
          ch.deleteById(id);

    }
    public Charity update(Charity obj) {
     
        return ch.save(obj);
    }
   
}