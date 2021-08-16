package com.example.vaccinationmanagementsystem.models;

import com.example.vaccinationmanagementsystem.mapper.RepresentationMappable;
import com.example.vaccinationmanagementsystem.marker.BaseEntity;
import com.example.vaccinationmanagementsystem.representation.AgeRangeRepresentation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AgeRange implements BaseEntity, RepresentationMappable<AgeRangeRepresentation> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int lowThreshold;
    private int highThreshold;

    @ManyToMany(mappedBy = "ages")
    private List<Vaccine> vaccine;

    public AgeRange(int lowThreshold, int highThreshold) {
        this.lowThreshold = lowThreshold;
        this.highThreshold = highThreshold;
    }

    @Override
    public AgeRangeRepresentation toRepresentation() {
        return new AgeRangeRepresentation(id, lowThreshold, highThreshold);
    }


}
