package admin.category;

import org.springframework.data.jpa.repository.JpaRepository;

import admin.category.entities.Category;;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
