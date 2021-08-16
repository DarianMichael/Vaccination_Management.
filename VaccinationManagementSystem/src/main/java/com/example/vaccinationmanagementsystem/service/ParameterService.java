package com.example.vaccinationmanagementsystem.service;

import com.example.vaccinationmanagementsystem.exception.VaccineEntityNotFoundException;
import com.example.vaccinationmanagementsystem.models.Param;
import com.example.vaccinationmanagementsystem.repository.ParamRepository;
import com.example.vaccinationmanagementsystem.representation.GeneralResponseStatus;
import com.example.vaccinationmanagementsystem.representation.ParamListRepresentation;
import com.example.vaccinationmanagementsystem.representation.ParamRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ParameterService {

    private ParamRepository repository;

    @Autowired
    public ParameterService(ParamRepository repository) {
        this.repository = repository;
    }

    public GeneralResponseStatus retrieveAll() {
        GeneralResponseStatus generalResponseStatus = new GeneralResponseStatus();
        generalResponseStatus.setData(new ParamListRepresentation(repository.findAll().stream()
                .map(Param::toRepresentation)
                .collect(Collectors.toList())));
        return generalResponseStatus;
    }

    public GeneralResponseStatus update(Long id, ParamRepresentation param) {
        return new GeneralResponseStatus(repository.findById(id).map(savedParam -> {
            savedParam.setName(param.getName());
            savedParam.setValue(param.getValue());
            return repository.save(savedParam).toRepresentation();
        }).orElseThrow(() -> new VaccineEntityNotFoundException("Param not found with id:" + id)));
    }

    public GeneralResponseStatus create(ParamRepresentation param) {
        return new GeneralResponseStatus(repository.save(param.toEntity()).toRepresentation());
    }

    public GeneralResponseStatus delete(Long id) {
        repository.deleteById(id);
        return new GeneralResponseStatus();
    }
}
