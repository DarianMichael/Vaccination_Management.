package com.example.vaccinationmanagementsystem.representation;

import com.example.vaccinationmanagementsystem.mapper.EntityMappable;
import com.example.vaccinationmanagementsystem.marker.BaseRepresentation;
import com.example.vaccinationmanagementsystem.models.AgeRange;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgeRangeRepresentation implements BaseRepresentation, EntityMappable<AgeRange> {
    private Long id;
    private int lowThreshold;
    private int highThreshold;

    @Override
    public AgeRange toEntity() {
        return new AgeRange(lowThreshold, highThreshold);
    }
}
