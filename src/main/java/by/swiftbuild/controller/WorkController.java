package by.swiftbuild.controller;

import by.swiftbuild.entity.Work;
import by.swiftbuild.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/work")
public class WorkController {

    @Autowired
    private WorkService workService;

    @GetMapping
    public String work(Model model) {
        model.addAttribute("work", new Work());
        return "work";
    }

    @GetMapping("/workList")
    public String workList(Model model) {
        List<Work> works = workService.findAll();
        model.addAttribute("works", works);
        return "worklist";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Work work) {
        workService.save(work);
        return "redirect:workList";
    }

    @PostMapping("/saveten")
    public String saveTen(@ModelAttribute Work work) {
        workService.saveTen();
        return "redirect:workList";
    }

}