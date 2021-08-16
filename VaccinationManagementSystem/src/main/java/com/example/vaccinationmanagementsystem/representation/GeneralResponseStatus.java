package com.example.vaccinationmanagementsystem.representation;

import com.example.vaccinationmanagementsystem.marker.BaseRepresentation;
import lombok.Data;

@Data
public class GeneralResponseStatus implements BaseRepresentation {
    private ErrorResponse error;
    private boolean status;
    private Object data;

    public GeneralResponseStatus() {
        this.status = true;
    }

    public GeneralResponseStatus(Object data) {
        this.data = data;
        this.status = true;
    }

    public GeneralResponseStatus(ErrorResponse error) {
        this.error = error;
        this.status = false;
    }
}
