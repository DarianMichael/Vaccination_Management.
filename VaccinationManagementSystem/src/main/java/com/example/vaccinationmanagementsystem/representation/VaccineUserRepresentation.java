package com.example.vaccinationmanagementsystem.representation;

import com.example.vaccinationmanagementsystem.enums.Rol;
import com.example.vaccinationmanagementsystem.mapper.EntityMappable;
import com.example.vaccinationmanagementsystem.marker.BaseRepresentation;
import com.example.vaccinationmanagementsystem.models.VaccineUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccineUserRepresentation implements BaseRepresentation, EntityMappable<VaccineUser> {
    private Long id;
    public String username;
    public String password;
    public Rol rol;
    private PersonRepresentation person;

    @Override
    public VaccineUser toEntity() {
        return new VaccineUser(username, password, rol, person.toEntity());
    }
}
