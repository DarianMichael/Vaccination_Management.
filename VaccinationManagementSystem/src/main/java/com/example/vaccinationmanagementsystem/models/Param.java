package com.example.vaccinationmanagementsystem.models;

import com.example.vaccinationmanagementsystem.mapper.RepresentationMappable;
import com.example.vaccinationmanagementsystem.marker.BaseEntity;
import com.example.vaccinationmanagementsystem.representation.ParamRepresentation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Param implements BaseEntity, RepresentationMappable<ParamRepresentation> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    private String value;

    public Param(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public ParamRepresentation toRepresentation() {
        return new ParamRepresentation(id, name, value);
    }
}
