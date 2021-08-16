package com.example.vaccinationmanagementsystem.representation;

import com.example.vaccinationmanagementsystem.marker.BaseRepresentation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiseasePriorityListRepresentation implements BaseRepresentation {
    private List<DiseasePriorityRepresentation> diseasePriorityRepresentations;
}
