package com.Squad03.demo.controllers;

import com.Squad03.demo.dto.TreatmentTypeRecordDTO;
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
    public ResponseEntity<List<TreatmentTypeRecord>> getAllTreatmentTypeRecords() {
        return new ResponseEntity<>(treatmentTypeRecordService.getAllTreatmentTypeRecords(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreatmentTypeRecord> getTreatmentTypeRecordById(@PathVariable UUID id) {
        return new ResponseEntity<>(treatmentTypeRecordService.getTreatmentTypeRecordById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TreatmentTypeRecord> createTreatmentTypeRecord(@RequestBody TreatmentTypeRecordDTO dto) {
        return new ResponseEntity<>(treatmentTypeRecordService.saveTreatmentTypeRecord(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreatmentTypeRecord> updateTreatmentTypeRecord(@PathVariable UUID id, @RequestBody TreatmentTypeRecordDTO dto) {
        return new ResponseEntity<>(treatmentTypeRecordService.updateTreatmentTypeRecordById(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTreatmentTypeRecord(@PathVariable UUID id) {
        treatmentTypeRecordService.deleteTreatmentTypeRecordById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
