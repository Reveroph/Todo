package br.com.todo.service;

import br.com.todo.entity.Category;
import br.com.todo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<Category> getAllCategory() {

        Iterable<Category> categoryIterable = repository.findAll();
        List<Category> categoryList = new ArrayList<>();
        categoryIterable.forEach(categoryList::add);
        return categoryList;
    }

    public String deleteCategory(Integer categoryId) {
        try {
            repository.deleteById(categoryId);
            return "Categoria deletada com sucesso!";
        } catch (Exception e) {
            return "Houve um erro com exclusão da categoria!";
        }
    }

    public Category findByIdCategory(Integer categoryId) {

        return repository.findById(categoryId).isPresent() ?
                repository.findById(categoryId).get() : new Category();
    }

    public Category updateCategory(Category category) {
        return repository.save(category);
    }
}
