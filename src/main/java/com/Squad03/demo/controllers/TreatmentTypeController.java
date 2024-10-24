package com.Squad03.demo.controllers;

import com.Squad03.demo.models.TreatmentType;
import com.Squad03.demo.services.TreatmentTypeService;
import jakarta.validation.Valid;
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
    public TreatmentType createTreatmentType(@Valid @RequestBody TreatmentType treatmentType) {
        return treatmentTypeService.saveTreatmentType(treatmentType);
    }

    @GetMapping({"/type/{type}"})
    public TreatmentType getTreatmentTypeByType(@PathVariable("type") String type) throws Exception {
        return treatmentTypeService.getTreatmentTypeByType(type);
    }

    @GetMapping
    public List<TreatmentType> getAllTreatmentTypes(){
        return treatmentTypeService.getAllTreatmentTypes();
    }

    @PutMapping("{/id}")
    public TreatmentType updateTreatmentTypeById(@PathVariable UUID id,@RequestBody TreatmentType newTreatmentTypeData) throws Exception {
        return treatmentTypeService.updateTreatmentTypeById(id,newTreatmentTypeData);
    }

    @DeleteMapping
    public String deleteTreatmentTypeById(@PathVariable UUID id) throws Exception {
        treatmentTypeService.deleteTreatmentTypeById(id);
        return "O Tipo de consulta foi deletado com sucesso!";
    }

}
