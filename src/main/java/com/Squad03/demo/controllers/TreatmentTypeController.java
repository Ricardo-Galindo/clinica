package com.Squad03.demo.controllers;

import com.Squad03.demo.models.TreatmentType;
import com.Squad03.demo.services.TreatmentTypeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/treatmentType")
public class TreatmentTypeController {

    private final TreatmentTypeService treatmentTypeService;

    public TreatmentTypeController(TreatmentTypeService treatmentTypeService){
        this.treatmentTypeService = treatmentTypeService;
    }

    @PostMapping
    public ResponseEntity<TreatmentType> createTreatmentType(@Valid @RequestBody TreatmentType treatmentType) {
        TreatmentType newTreatmentType = treatmentTypeService.saveTreatmentType(treatmentType);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTreatmentType);
    }

    @GetMapping({"/type/{type}"})
    public ResponseEntity<TreatmentType> getTreatmentTypeByType(@PathVariable("type") String type) throws Exception {
        TreatmentType currentTreatmentType = treatmentTypeService.getTreatmentTypeByType(type);
        return ResponseEntity.status(HttpStatus.OK).body(currentTreatmentType);
    }

    @GetMapping
    public List<TreatmentType> getAllTreatmentTypes(){
        return treatmentTypeService.getAllTreatmentTypes();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreatmentType> updateTreatmentTypeById(@PathVariable UUID id,@RequestBody TreatmentType newTreatmentTypeData) throws Exception {
        TreatmentType updatedTreatmentType = treatmentTypeService.updateTreatmentTypeById(id,newTreatmentTypeData);
        return ResponseEntity.status(HttpStatus.OK).body(updatedTreatmentType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTreatmentTypeById(@PathVariable UUID id) throws Exception {
        treatmentTypeService.deleteTreatmentTypeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("O Tipo de consulta foi deletado com sucesso!");
    }

}
