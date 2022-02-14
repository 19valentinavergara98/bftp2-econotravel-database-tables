package com.econotravel.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/experiences")
// NO INCLUIR NUNCA LA CABECERA CrossOrigin en un proyecto real
@CrossOrigin
public class ExperienceController {

    private final ExperienceRepository experienceRepository;
    private final CategoryRepository categoryRepository;


    @Autowired
    public ExperienceController(ExperienceRepository experienceRepository, CategoryRepository categoryRepository) {
        this.experienceRepository = experienceRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    String listExperiences(Model model, @RequestParam(required = false) String category {
        model.addAttribute("title", "Experience list");
        model.addAttribute("experiences", getExperiences(category));
        model.addAttribute("categories", categoryRepository.findAll());
        return experienceRepository.findAll();

    }

    @PostMapping
    public Experience createExperience(@RequestBody Experience experience) {
        return experienceRepository.save(experience);
    }
    private List<Experience> getExperiencess(String category) {
        if (category == null) {
            return experienceRepository.findAll();
        }
        return experienceRepository.findExperiencesByCategoryEquals(category);
    }
}
