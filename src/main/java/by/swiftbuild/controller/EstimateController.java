package by.swiftbuild.controller;

import by.swiftbuild.entity.Estimate;
import by.swiftbuild.service.EstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estimate")
public class EstimateController {

    @Autowired
    private EstimateService estimateService;

    @GetMapping
    public String estimate(Model model) {
        model.addAttribute("estimate",new Estimate());
        return "estimate";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Estimate estimate) {
        estimateService.save(estimate);
        return "estimate";
    }
}