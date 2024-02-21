package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Charity {
    
    @Id
      private int id;
      private String charityname;
      private double charityamount;
      public Charity()
      {

      }
      public int getId() {
        return id;
      }
      public void setId(int id) {
        this.id = id;
      }
      public String getCharityname() {
        return charityname;
      }
      public void setCharityname(String charityname) {
        this.charityname = charityname;
      }
      public double getCharityamount() {
        return charityamount;
      }
      public void setCharityamount(double charityamount) {
        this.charityamount = charityamount;
      }
     
      
}
