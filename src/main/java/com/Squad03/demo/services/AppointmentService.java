package com.Squad03.demo.services;
import com.Squad03.demo.dto.AppointmentRequestDTO;
import com.Squad03.demo.dto.AppointmentResponseDTO;
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

    public AppointmentResponseDTO convertToResponseDTO(Appointment appointment) {
        return new AppointmentResponseDTO(
                appointment.getId(),
                appointment.getPacient().getId(),
                appointment.getPacient().getName(),
                appointment.getResponsible().getId(),
                appointment.getResponsible().getName(),
                appointment.getStudent().getId(),
                appointment.getStudent().getName(),
                appointment.getSchedule(),
                appointment.getObservations(),
                appointment.getCreatedBy(),
                appointment.getStatus()
        );
    }

    public Appointment saveAppointment(AppointmentRequestDTO appointmentRequest) {
        var pacient = userService.getUserById(appointmentRequest.pacientId());
        var responsible = userService.getUserById(appointmentRequest.responsibleId());
        var student = userService.getUserById(appointmentRequest.studentId());
        Appointment newAppointment = new Appointment();
        newAppointment.setPacient(pacient);
        newAppointment.setResponsible(responsible);
        newAppointment.setStudent(student);
        newAppointment.setObservations(appointmentRequest.observations());
        newAppointment.setSchedule(appointmentRequest.schedule());
        newAppointment.setCreatedBy(appointmentRequest.createdBY());
        newAppointment.setStatus(appointmentRequest.status());
        return appointmentRepository.save(newAppointment);
    }

    public List<AppointmentResponseDTO> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return  appointments.stream().map(appointment -> convertToResponseDTO(appointment)).toList();
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

    public Appointment updateAppointmentById(UUID id, AppointmentRequestDTO newAppointmentData) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            Appointment appointmentToUpdate = appointment.get();
            if (newAppointmentData.responsibleId() != null) {
                appointmentToUpdate.setResponsible(userService.getUserById(newAppointmentData.responsibleId()));
            }
            if (newAppointmentData.pacientId() != null) {
                appointmentToUpdate.setPacient(userService.getUserById(newAppointmentData.pacientId()));
            }
            if (newAppointmentData.studentId() != null) {
                appointmentToUpdate.setStudent(userService.getUserById(newAppointmentData.studentId()));
            }
            if (newAppointmentData.observations() != null) {
                appointmentToUpdate.setObservations(newAppointmentData.observations());
            }
            if (newAppointmentData.createdBY() != null) {
                appointmentToUpdate.setCreatedBy(newAppointmentData.createdBY());
            }
            if (newAppointmentData.schedule() != null) {
                appointmentToUpdate.setSchedule(newAppointmentData.schedule());
            }
            appointmentToUpdate.setStatus(newAppointmentData.status());

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