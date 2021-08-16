package com.example.vaccinationmanagementsystem.representation;

import com.example.vaccinationmanagementsystem.marker.BaseRepresentation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineByGroupRepresentation implements BaseRepresentation {
    private Long vaccineId;
    private Long ageRangeId;
}
