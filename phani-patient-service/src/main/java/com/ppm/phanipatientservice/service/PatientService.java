package com.ppm.phanipatientservice.service;

import com.ppm.phanipatientservice.dto.PatientResponseDTO;
import com.ppm.phanipatientservice.mapper.PatientMapper;
import com.ppm.phanipatientservice.model.Patient;
import com.ppm.phanipatientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
     this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                .map(PatientMapper::toDTO).toList();
    }
}
