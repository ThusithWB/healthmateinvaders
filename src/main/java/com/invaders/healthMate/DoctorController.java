package com.invaders.healthMate;

import com.invaders.healthMate.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<Doctor>> getDoctorsByLocation(@PathVariable String location) {
        List<Doctor> doctors = doctorService.getDoctorsByLocation(location);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
}

//@GetMapping("/location/{location}")
//@GetMapping("/api/doctors/location/{location}")