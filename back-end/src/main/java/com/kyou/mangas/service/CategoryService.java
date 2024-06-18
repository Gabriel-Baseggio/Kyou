package com.kyou.mangas.service;

import com.kyou.mangas.model.Category;
import com.kyou.mangas.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategory(Integer id) {
        Optional<Category> optional = categoryRepository.findById(id);

        if (optional.isEmpty())
            throw new RuntimeException("Categoria não encontrada");

        return optional.get();
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Category updatedCategory) {
        validateCategory(updatedCategory.getId());
        return categoryRepository.save(updatedCategory);
    }

    public String deleteCategory(Integer id) {
        validateCategory(id);

        categoryRepository.deleteById(id);

        if (categoryRepository.existsById(id))
            throw new RuntimeException("Não foi possível deletar a categoria de id: " + id);

        return "Categoria de id " + id + " deletada";
    }

    private void validateCategory(Integer id) {
        if (!(categoryRepository.existsById(id)))
            throw new RuntimeException("Categoria não encontrada");
    }

}
