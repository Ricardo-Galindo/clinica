package com.Squad03.demo.services;

import com.Squad03.demo.models.TreatmentType;
import com.Squad03.demo.models.User;
import com.Squad03.demo.repository.TreatmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TreatmentTypeService {

    @Autowired
    private TreatmentTypeRepository treatmentTypeRepository;

    private TreatmentTypeService(TreatmentTypeRepository treatmentTypeRepository){
        this.treatmentTypeRepository = treatmentTypeRepository;
    }


    public List<TreatmentType> getAllTreatmentTypes() {
        return  treatmentTypeRepository.findAll();
    }

    public TreatmentType getTreatmentTypeById(UUID id) throws Exception{
        Optional<TreatmentType> treatmentType = treatmentTypeRepository.findById(id);
        if (treatmentType.isPresent()){
           return treatmentType.get();
        }
        else{
            throw new Exception("Tipo de tratamento não encontrado!");
        }
    }

    public TreatmentType saveTreatmentType(TreatmentType treatmentType) {
        return treatmentTypeRepository.save(treatmentType);
    }

    public TreatmentType getTreatmentTypeByType(String type) throws Exception{
        Optional<TreatmentType> treatmentType = treatmentTypeRepository.findTreatmentTypeByType(type);

        if (treatmentType.isPresent()){
            return treatmentType.get();
        }
        else{
            throw new Exception("Tipo de atendimento não encontrado!");
        }
    }

    public TreatmentType updateTreatmentTypeById(UUID id, TreatmentType newTreatmentTypeData) throws Exception {
        Optional<TreatmentType> existingTreatmentType = treatmentTypeRepository.findById(id);

        if (existingTreatmentType.isPresent()) {
            TreatmentType treatmentTypeUpToDate = existingTreatmentType.get();
            treatmentTypeUpToDate.setType(newTreatmentTypeData.getType());
            treatmentTypeUpToDate.setSchedule(newTreatmentTypeData.getSchedule());

            return treatmentTypeRepository.save(treatmentTypeUpToDate);
        } else {
            throw new Exception("Tipo de atendimento não encontrado!");
        }
    }

    public void deleteTreatmentTypeById(UUID id) throws  Exception{
        if(treatmentTypeRepository.existsById(id)){
            treatmentTypeRepository.deleteById(id);
        }
        else{
            throw new Exception("Tipo de atendimento não encontrado!");
        }
    }

}
