package com.econotravel.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

import javax.annotation.PostConstruct;

@Component
public class addSampleData {
    private final ExperienceRepository experienceRepository;

    @Autowired
    public addSampleData(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @PostConstruct
    public void loadSampleData() {
        experienceRepository.saveAll(List.of(
                new Experience("Paseo por el Montseny", "Naturaleza"),
                new Experience("Visita a la sagrada familia", "Cultural")

        ));
    }
}
