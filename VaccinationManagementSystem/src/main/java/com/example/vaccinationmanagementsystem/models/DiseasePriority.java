package com.example.vaccinationmanagementsystem.models;

import com.example.vaccinationmanagementsystem.enums.Disease;
import com.example.vaccinationmanagementsystem.mapper.RepresentationMappable;
import com.example.vaccinationmanagementsystem.marker.BaseEntity;
import com.example.vaccinationmanagementsystem.representation.DiseasePriorityRepresentation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DiseasePriority implements BaseEntity, RepresentationMappable<DiseasePriorityRepresentation> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int value;
    @Enumerated(EnumType.STRING)
    private Disease disease;

    public DiseasePriority(int value, Disease disease) {
        this.value = value;
        this.disease = disease;
    }


    @Override
    public DiseasePriorityRepresentation toRepresentation() {
        return new DiseasePriorityRepresentation(id, value, disease);
    }
}
