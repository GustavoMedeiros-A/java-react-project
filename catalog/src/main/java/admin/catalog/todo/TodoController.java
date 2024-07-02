package admin.catalog.todo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import admin.catalog.todo.entities.Todo;
import admin.catalog.todo.entities.TodoSpecifications;
import admin.catalog.utils.pagination.PaginationResponse;
import admin.catalog.utils.pagination.SearchParams;
import admin.catalog.utils.pagination.SearchParamsFactory;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("")
    public String createTodo(@RequestBody Todo entity) {
        return this.todoService.createTodo(entity);
    }

    @GetMapping("")
    public PaginationResponse<Todo> getAllTodos(SearchParams params) {
        return this.todoService.getAllTodos(params);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getById(@PathVariable Long id) {
        Todo todo = this.todoService.getTodoById(id);
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        this.todoService.deleteTodo(id);
        return "Successfully deleted";
    }

}
