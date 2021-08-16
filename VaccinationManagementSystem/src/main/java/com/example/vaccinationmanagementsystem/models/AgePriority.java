package com.example.vaccinationmanagementsystem.models;

import com.example.vaccinationmanagementsystem.mapper.RepresentationMappable;
import com.example.vaccinationmanagementsystem.marker.BaseEntity;
import com.example.vaccinationmanagementsystem.representation.AgePriorityRepresentation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AgePriority implements BaseEntity, RepresentationMappable<AgePriorityRepresentation> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private AgeRange ageRange;
    private int value;

    public AgePriority(AgeRange ageRange, int value) {
        this.ageRange = ageRange;
        this.value = value;
    }

    @Override
    public AgePriorityRepresentation toRepresentation() {
        return new AgePriorityRepresentation(id, ageRange.getId(), getValue());
    }
}
