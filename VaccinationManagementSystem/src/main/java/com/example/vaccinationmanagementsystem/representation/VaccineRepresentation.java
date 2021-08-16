package com.example.vaccinationmanagementsystem.representation;

import com.example.vaccinationmanagementsystem.mapper.EntityMappable;
import com.example.vaccinationmanagementsystem.marker.BaseRepresentation;
import com.example.vaccinationmanagementsystem.models.Vaccine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccineRepresentation implements BaseRepresentation, EntityMappable<Vaccine> {
    private Long id;
    private String name;
    private int quantity;

    @Override
    public Vaccine toEntity() {
        return new Vaccine(name, quantity);
    }
}
