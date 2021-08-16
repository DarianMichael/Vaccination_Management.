package com.example.vaccinationmanagementsystem.models;

import com.example.vaccinationmanagementsystem.mapper.RepresentationMappable;
import com.example.vaccinationmanagementsystem.marker.BaseEntity;
import com.example.vaccinationmanagementsystem.representation.VaccineRepresentation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vaccine implements BaseEntity, RepresentationMappable<VaccineRepresentation> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int quantity;

    @ManyToMany
    @JoinTable
    private List<AgeRange> ages;

    public Vaccine(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public VaccineRepresentation toRepresentation() {
        return new VaccineRepresentation(id, name, quantity);
    }
}

