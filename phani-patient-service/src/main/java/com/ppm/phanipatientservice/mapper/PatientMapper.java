package com.ppm.phanipatientservice.mapper;

import com.ppm.phanipatientservice.dto.PatientResponseDTO;
import com.ppm.phanipatientservice.model.Patient;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient) {
        PatientResponseDTO patientDto = new PatientResponseDTO();

        patientDto.setId(patient.getId().toString());
        patientDto.setName(patient.getName());
        patientDto.setAddress(patient.getAddress());
        patientDto.setEmail(patient.getEmail());
        patientDto.setDateOfBirth(patient.getDateOfBirth().toString());

        return patientDto;
    }
}
