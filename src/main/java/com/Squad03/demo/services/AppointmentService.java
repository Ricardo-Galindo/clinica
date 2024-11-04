package com.Squad03.demo.services;
import com.Squad03.demo.dto.AppointmentRequest;
import com.Squad03.demo.models.Appointment;
import com.Squad03.demo.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    private final AppointmentRepository appointmentRepository;

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

    public Appointment updateAppointmentById(UUID id, AppointmentRequest newAppointmentData) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            Appointment appointmentToUpdate = appointment.get();
            if (newAppointmentData.getResponsibleId() != null) {
                appointmentToUpdate.setResponsible(userService.getUserById(newAppointmentData.getResponsibleId()));
            }
            if (newAppointmentData.getPacientId() != null) {
                appointmentToUpdate.setPacient(userService.getUserById(newAppointmentData.getPacientId()));
            }
            if (newAppointmentData.getStudentId() != null) {
                appointmentToUpdate.setStudent(userService.getUserById(newAppointmentData.getStudentId()));
            }
            if (newAppointmentData.getObservations() != null) {
                appointmentToUpdate.setObservations(newAppointmentData.getObservations());
            }
            if (newAppointmentData.getCreatedBy() != null) {
                appointmentToUpdate.setCreatedBy(newAppointmentData.getCreatedBy());
            }
            if (newAppointmentData.getSchedule() != null) {
                appointmentToUpdate.setSchedule(newAppointmentData.getSchedule());
            }

            return appointmentRepository.save(appointmentToUpdate);
        }
        return null;
    }

    public void deleteAppointmentById(UUID id) {
        if (appointmentRepository.existsById(id)) {
            appointmentRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Consulta não encontrada");
        }
    }
}