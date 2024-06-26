package admin.catalog.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import admin.catalog.category.entities.Category;;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
