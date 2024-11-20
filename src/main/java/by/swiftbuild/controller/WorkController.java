package by.swiftbuild.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/work")
public class WorkController {

    @GetMapping
    public String work() {
        return "work";
    }
}