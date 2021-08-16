package com.example.vaccinationmanagementsystem.models;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class VaccineInventory {
    public Map<Vaccine,Integer> vaccineInventory;

    public VaccineInventory(Map<Vaccine, Integer> vaccineInventory) {
        this.vaccineInventory = new HashMap<>(vaccineInventory);
    }
}
