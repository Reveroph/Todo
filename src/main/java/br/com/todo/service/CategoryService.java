package br.com.todo.service;

import br.com.todo.entity.Category;
import br.com.todo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public String saveCategory(Category category) {

        if(Objects.nonNull(category) && !category.getName().isEmpty()) {
            repository.save(category);
            return "Ok, salvou direitinho!";
        }
        return "Objeto category invalido!";
    }
}
