package com.example.vaccinationmanagementsystem.models;

import com.example.vaccinationmanagementsystem.enums.Rol;
import com.example.vaccinationmanagementsystem.mapper.RepresentationMappable;
import com.example.vaccinationmanagementsystem.marker.BaseEntity;
import com.example.vaccinationmanagementsystem.representation.VaccineUserRepresentation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class VaccineUser implements BaseEntity, RepresentationMappable<VaccineUserRepresentation> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String username;
    public String password;
    public Rol rol;

    @OneToOne
    private Person person;

    public VaccineUser(String username, String password, Rol rol, Person person) {
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.person = person;
    }

    @Override
    public VaccineUserRepresentation toRepresentation() {
        return new VaccineUserRepresentation(id, username, password, rol, person.toRepresentation());
    }
}
