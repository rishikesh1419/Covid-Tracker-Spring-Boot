package com.rishikesh.covid19casestracker.controllers;

import com.rishikesh.covid19casestracker.models.LocStats;
import com.rishikesh.covid19casestracker.services.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CovidDataService covidDataService;

    @GetMapping("/")
    public String home(Model model) {
        List<LocStats> allStats = covidDataService.getAllStats();
        int totalCases = allStats.stream().mapToInt(stat -> stat.getTotalCases()).sum();
        int newCases = allStats.stream().mapToInt(stat -> stat.getOneDayDiff()).sum();
        model.addAttribute("locStats", allStats);
        model.addAttribute("totalCases", totalCases);
        model.addAttribute("newCases", newCases);
        return "home";
    }
}
