package admin.catalog.todo.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

public class TodoSpecifications {

    public static Specification<Todo> withFilter(Map<String, Object> filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            if (filter != null) {
                for (Map.Entry<String, Object> entry : filter.entrySet()) {
                    predicates.add(cb.equal(root.get(entry.getKey()), entry.getValue()));
                }
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
