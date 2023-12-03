package com.invaders.healthMate;

import org.springframework.ui.Model;
//import ch.qos.logback.core.model.Model;
import com.invaders.healthMate.model.Doctor;
import com.invaders.healthMate.repository.DoctorRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/Location")  //location
public class LocationController {

    //@Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/Location")
    public String showDoctorsByLocation(@RequestParam("location") String location, Model model) {
        List<Doctor> doctors = doctorRepository.findByLocation(location);
        model.addAttribute("doctors", doctors);
        return "doc";
    }
    //new
    @GetMapping
    public String showLocationPage(@RequestParam String patientName,
                                   @RequestParam String phoneNumber,
                                   @RequestParam String address,
                                   @RequestParam String email,
                                   Model model) {
        // Pass form data to the Location.html view
        model.addAttribute("patientName", patientName);
        model.addAttribute("phoneNumber", phoneNumber);
        model.addAttribute("address", address);
        model.addAttribute("email", email);

        return "Location";
    }
}