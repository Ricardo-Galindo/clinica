package com.Squad03.demo.services;

import com.Squad03.demo.dto.TreatmentTypeRecordDTO;
import com.Squad03.demo.models.TreatmentType;
import com.Squad03.demo.models.TreatmentTypeRecord;
import com.Squad03.demo.models.User;
import com.Squad03.demo.repository.TreatmentTypeRecordRepository;
import com.Squad03.demo.repository.TreatmentTypeRepository;
import com.Squad03.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class TreatmentTypeRecordService {

    @Autowired
    private TreatmentTypeRecordRepository treatmentTypeRecordRepository;

    @Autowired
    private TreatmentTypeRepository treatmentTypeRepository;

    @Autowired
    private UserRepository userRepository;

    public List<TreatmentTypeRecord> getAllTreatmentTypeRecords() {
        return treatmentTypeRecordRepository.findAll();
    }

    public TreatmentTypeRecord getTreatmentTypeRecordById(UUID id) {
        return treatmentTypeRecordRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, " Registro de tratamento não encontrado!"));
    }

    public TreatmentTypeRecord saveTreatmentTypeRecord(TreatmentTypeRecordDTO dto) {
        TreatmentTypeRecord treatmentTypeRecord = new TreatmentTypeRecord();

        TreatmentType treatmentType = treatmentTypeRepository.findById(dto.getTreatmentTypeId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, " Tipo de tratamento não encontrado!"));
        treatmentTypeRecord.setTreatmentType(treatmentType);

        User responsible = userRepository.findById(dto.getResponsibleId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, " Responsável não encontrado!"));
        treatmentTypeRecord.setResponsible(responsible);

        User student = userRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, " Estudante não encontrado!"));
        treatmentTypeRecord.setStudent(student);

        return treatmentTypeRecordRepository.save(treatmentTypeRecord);
    }

    public TreatmentTypeRecord updateTreatmentTypeRecordById(UUID id, TreatmentTypeRecordDTO dto) {
        TreatmentTypeRecord existingRecord = getTreatmentTypeRecordById(id);

        TreatmentType treatmentType = treatmentTypeRepository.findById(dto.getTreatmentTypeId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, " Tipo de tratamento não encontrado! "));
        existingRecord.setTreatmentType(treatmentType);

        User responsible = userRepository.findById(dto.getResponsibleId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, " Responsável não encontrado! "));
        existingRecord.setResponsible(responsible);

        User student = userRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, " Estudante não encontrado! "));
        existingRecord.setStudent(student);

        return treatmentTypeRecordRepository.save(existingRecord);
    }

    public void deleteTreatmentTypeRecordById(UUID id) {
        if (treatmentTypeRecordRepository.existsById(id)) {
            treatmentTypeRecordRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Registro de tratamento não encontrado! ");
        }
    }
}
