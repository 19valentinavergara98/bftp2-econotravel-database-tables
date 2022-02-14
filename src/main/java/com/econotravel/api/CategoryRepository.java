package com.econotravel.api;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository {

    public CategoryRepository() {
    }

    public List<Category> findAll() {
        return List.of(
                new Category("Aventura"),
                new Category("Cultural"),
                new Category("Naturaleza"),
                new Category("Gastronomia")

        );
    }
}