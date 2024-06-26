package admin.catalog.category;

import admin.catalog.category.entities.Category;
import admin.catalog.utils.exceptions.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    public String createCategory(Category category) {
        this.categoryRepository.save(category);
        return "created";
    }

    public List<Category> getAllCategories() {
        List<Category> categories = this.categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new NotFoundException("No categories found", null);
        }
        return categories;
    }

    public Category getCategoryById(Long id) {
        logger.info("Fetching category with id: {}", id);
        return this.categoryRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Category with id {} not found", id);
                    return new NotFoundException("Category with id" + id + "not found", null);
                });
    }
}
