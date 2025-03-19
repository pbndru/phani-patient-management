package com.ppm.phanipatientservice.service;

import com.ppm.phanipatientservice.dto.PatientRequestDTO;
import com.ppm.phanipatientservice.dto.PatientResponseDTO;
import com.ppm.phanipatientservice.exception.EmailAlreadyExistsException;
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

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("A patient with this email "
            + "already exists" + patientRequestDTO.getEmail());
        }

        Patient newPatient = patientRepository.save(
                PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(newPatient);
    }
}
