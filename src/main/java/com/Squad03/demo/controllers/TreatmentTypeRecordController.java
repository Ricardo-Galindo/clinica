package com.Squad03.demo.controllers;

import com.Squad03.demo.dto.TreatmentTypeRecordRequestDTO;
import com.Squad03.demo.dto.TreatmentTypeRecordResponseDTO;
import com.Squad03.demo.models.TreatmentTypeRecord;
import com.Squad03.demo.services.TreatmentTypeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/treatmentTypeRecords")
public class TreatmentTypeRecordController {

    @Autowired
    private TreatmentTypeRecordService treatmentTypeRecordService;

    @GetMapping
    public ResponseEntity<List<TreatmentTypeRecordResponseDTO>> getAllTreatmentTypeRecords() {
        List<TreatmentTypeRecordResponseDTO> allTreatmentTypeRecords = treatmentTypeRecordService.getAllTreatmentTypeRecords();
        return ResponseEntity.status(HttpStatus.OK).body(allTreatmentTypeRecords);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreatmentTypeRecordResponseDTO> getTreatmentTypeRecordById(@PathVariable UUID id) {
        TreatmentTypeRecord currentTreatmentTypeRecord = treatmentTypeRecordService.getTreatmentTypeRecordById(id);
        TreatmentTypeRecordResponseDTO dto = treatmentTypeRecordService.convertToTreatmentTypeRecordDTO(currentTreatmentTypeRecord);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping
    public ResponseEntity<TreatmentTypeRecordResponseDTO> createTreatmentTypeRecord(@RequestBody TreatmentTypeRecordRequestDTO dto) {
        TreatmentTypeRecord treatmentTypeRecord = treatmentTypeRecordService.saveTreatmentTypeRecord(dto);
        TreatmentTypeRecordResponseDTO treatmentTypeRecordResponseDTO = treatmentTypeRecordService.convertToTreatmentTypeRecordDTO(treatmentTypeRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(treatmentTypeRecordResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreatmentTypeRecordResponseDTO> updateTreatmentTypeRecord(@PathVariable UUID id, @RequestBody TreatmentTypeRecordRequestDTO dto) {
        TreatmentTypeRecord treatmentTypeRecordToUpdate = treatmentTypeRecordService.updateTreatmentTypeRecordById(id, dto);
        TreatmentTypeRecordResponseDTO treatmentTypeRecordResponseDTO = treatmentTypeRecordService.convertToTreatmentTypeRecordDTO(treatmentTypeRecordToUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(treatmentTypeRecordResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTreatmentTypeRecord(@PathVariable UUID id) {
        treatmentTypeRecordService.deleteTreatmentTypeRecordById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
