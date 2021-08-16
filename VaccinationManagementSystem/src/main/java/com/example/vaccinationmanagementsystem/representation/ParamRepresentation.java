package com.example.vaccinationmanagementsystem.representation;

import com.example.vaccinationmanagementsystem.mapper.EntityMappable;
import com.example.vaccinationmanagementsystem.marker.BaseRepresentation;
import com.example.vaccinationmanagementsystem.models.Param;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParamRepresentation implements BaseRepresentation, EntityMappable<Param> {
    private Long id;
    private String name;
    private String value;

    @Override
    public Param toEntity() {
        return new Param(name, value);
    }
}
