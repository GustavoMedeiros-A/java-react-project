package admin.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@ComponentScan(basePackages = { "admin.catalog.category", "admin.catalog.utils.exceptions", "admin.catalog.todo",
		"admin.catalog.config" })
@EntityScan(basePackages = { "admin.catalog.category.entities", "admin.catalog.todo.entities" })
@EnableJpaRepositories(basePackages = { "admin.catalog.category", "admin.catalog.todo" })
public class CatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogApplication.class, args);
	}

}
