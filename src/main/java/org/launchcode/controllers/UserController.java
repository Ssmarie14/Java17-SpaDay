package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
//        model.addAttribute();
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
// add form submission handling code here
        if (!user.getPassword().equals(verify)) {
            model.addAttribute("errorMessage", "Passwords do not match!");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());

            return "user/add";
        }
          model.addAttribute("greetUser", "Hello " + user.getUsername());
          return "user/index";
    }
}
