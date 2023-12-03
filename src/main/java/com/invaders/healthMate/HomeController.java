package com.invaders.healthMate;

import com.invaders.healthMate.model.User;
import com.invaders.healthMate.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.invaders.healthMate.repository.UserRepository;
import com.invaders.healthMate.repository.AppointmentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;


@Controller
public class HomeController {

    private final UserRepository userRepository;

    @Autowired
    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/index")
    public String index() {
        return "index"; // Return the name of HTML template (index.html)
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "Login"; // This will return the "Login.html" template
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model) {
        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            if (Objects.equals(existingUser.getLoginType(), "admin")) {
                return "redirect:/adminPanel";
            } else {
                if (Objects.equals(existingUser.getType(), "service-provider")) {
                    return "redirect:/userProfile";
                } else {
                    return "redirect:/index";
                }
            }
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "Login";
        }

    }

    @GetMapping("/adminPanel")
    public String adminPanel() {
        // Logic for handling requests to the admin panel
        return "adminPanel"; // Return the name of the HTML template (adminPanel.html)
    }

    @GetMapping("/userProfile")
    public String userProfile() {
        // Logic for handling requests to the user profile
        return "userProfile"; // Return the name of the HTML template (userProfile.html)
    }

    @GetMapping("/bookForm")
    public String bookForm() {
        // Logic for handling requests to the appointment booking form
        return "bookForm"; // Return the name of the HTML template (bookForm.html)
    }

    @GetMapping("/details")
    public String details() {
        // Logic for handling requests to available time details
        return "details"; // Return the name of the HTML template (details.html)
    }

    @PostMapping("/Location")
    public String Location(@RequestParam String patientName) {
        // Logic for handling requests to the admin panel
        return "Location"; // Return the name of the HTML template (Location.html)
    }
    @GetMapping("/doc.html")
    public String displayDoctors(@RequestParam("doctorNames") List<String> doctorNames, Model model) {
        // Add the list of doctor names to the model to be displayed in the HTML template
        model.addAttribute("doctorNames", doctorNames);

        // Logic for handling requests to the doc.html page
        return "doc"; // Return the name of the HTML template (doc.html)
    }
}

