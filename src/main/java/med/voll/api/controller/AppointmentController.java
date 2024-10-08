package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.voll.api.domain.appointment.AppointmentScheduleService;
import med.voll.api.domain.appointment.DataCancelAppointment;
import med.voll.api.domain.appointment.DataDetailAppointment;
import med.voll.api.domain.appointment.DataScheduleAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
@SecurityRequirement(name = "bearer-key")
public class AppointmentController {

    @Autowired
    private AppointmentScheduleService service;

    @PostMapping
    @Transactional
    public ResponseEntity scheduleAppointment(@RequestBody @Valid DataScheduleAppointment data){
        var dto = service.schedule(data);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelAppointment(@RequestBody @Valid DataCancelAppointment data){
        service.cancelAppointment(data);
        return ResponseEntity.noContent().build();
    }
}
