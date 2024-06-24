package admin.category;

import org.springframework.stereotype.Service;

import admin.category.dtos.CreateCategoryDto;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void createCategory(CreateCategoryDto category) {
        // this.categoryRepository.
    }
}
