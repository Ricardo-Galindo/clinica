package com.Squad03.demo.services;
import com.Squad03.demo.controllers.UserController;
import com.Squad03.demo.dto.AppointmentRequest;
import com.Squad03.demo.models.Appointment;
import com.Squad03.demo.models.User;
import com.Squad03.demo.repository.AppointmentRepository;
import com.Squad03.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserService userService;


    public AppointmentService(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment saveAppointment(AppointmentRequest appointmentRequest) {
        System.out.println(appointmentRequest.getStudentId().toString());
        var pacient = userService.getUserById(appointmentRequest.getPacientId());
        var responsible = userService.getUserById(appointmentRequest.getResponsibleId());
        var student = userService.getUserById(appointmentRequest.getStudentId());
        Appointment newAppointment = new Appointment();
        newAppointment.setPacient(pacient);
        newAppointment.setResponsible(responsible);
        newAppointment.setStudent(student);
        newAppointment.setObservations(appointmentRequest.getObservations());
        newAppointment.setSchedule(appointmentRequest.getSchedule());
        newAppointment.setCreatedBy(appointmentRequest.getCreatedBy());
        return appointmentRepository.save(newAppointment);
    }

    public List<Appointment> getAllAppointments() {
        return  appointmentRepository.findAll();
    }


    public Appointment getAppointmentById(UUID id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if(appointment.isPresent()){
            return appointment.get();
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Consulta não encontrada");
        }
    }

//    public Appointment updateAppointmentById(UUID id, Appointment newAppointmentData) {
//        Optional<Appointment> appointment = appointmentRepository.findById(id);
//        if(appointment.isPresent()){
//            Appointment appointmentToUpdate = appointment.get();
//            ResponseEntity<User> scheduledResponsible = userController.getUserById(appointmentToUpdate.getResponsible().getId());
//            ResponseEntity<User> scheduledStudent = userController.getUserById(appointmentToUpdate.getStudent().getId());
//
//
//        }
//    }

}
