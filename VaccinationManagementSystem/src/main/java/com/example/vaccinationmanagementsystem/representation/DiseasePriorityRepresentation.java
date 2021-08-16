package com.example.vaccinationmanagementsystem.representation;

import com.example.vaccinationmanagementsystem.enums.Disease;
import com.example.vaccinationmanagementsystem.mapper.EntityMappable;
import com.example.vaccinationmanagementsystem.marker.BaseRepresentation;
import com.example.vaccinationmanagementsystem.models.DiseasePriority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiseasePriorityRepresentation implements BaseRepresentation, EntityMappable<DiseasePriority> {
    private Long id;
    private int value;
    private Disease disease;

    @Override
    public DiseasePriority toEntity() {
        return new DiseasePriority(value, disease);
    }
}
