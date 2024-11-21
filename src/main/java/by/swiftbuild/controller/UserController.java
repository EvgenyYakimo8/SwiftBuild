package by.swiftbuild.controller;

import by.swiftbuild.entity.User;
import by.swiftbuild.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String reg(Model model) {
        model.addAttribute("user", new User());
        return "reg";
    }

    @PostMapping("/reg")
    public String regSubmit(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/login";
    }

    /**
     * Post запрос для login указывается в login.html и обрабатывается в loginProcessingUrl в классе SecurityConfiguration
     * Post запрос для logout указывается в home.html и обрабатывается в loginProcessingUrl в классе SecurityConfiguration
     * */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/profile")
    public String profile() { // после входа почему-то перенаправляет на эту страницу todo разобраться
        return "profile";
    }
}
