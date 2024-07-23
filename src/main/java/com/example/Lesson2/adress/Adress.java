package com.example.Lesson2.adress;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

@Entity
public class Adress implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long adressId;
    @NotBlank(message = "Требуется указать улицу")
    String street;
    @NotBlank(message = "Требуется указать номер дома")
    String houseNo;
    @NotBlank(message = "Требуется указать номер квартиры")
    String flatNo;
    @NotBlank(message = "Требуется указать зип код")
    String zip;


    public Long getAdressId() {
        return adressId;
    }

    public void setAdressId(Long adressId) {
        this.adressId = adressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
