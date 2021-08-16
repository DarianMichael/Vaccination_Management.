package com.example.vaccinationmanagementsystem.representation;

import com.example.vaccinationmanagementsystem.mapper.EntityMappable;
import com.example.vaccinationmanagementsystem.marker.BaseRepresentation;
import com.example.vaccinationmanagementsystem.models.AgePriority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgePriorityRepresentation implements BaseRepresentation {
    private Long id;
    private Long idAgeRange;
    private int value;
}
