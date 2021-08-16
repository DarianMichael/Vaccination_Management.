package com.example.vaccinationmanagementsystem.representation;

import com.example.vaccinationmanagementsystem.marker.BaseRepresentation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccineListRepresentation implements BaseRepresentation {
    private List<VaccineRepresentation> vaccineRepresentations;
}
