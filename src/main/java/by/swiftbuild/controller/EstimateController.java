package by.swiftbuild.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estimate")
public class EstimateController {

    @GetMapping
    public String estimate() {
        return "estimate";
    }
}
