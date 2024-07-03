package admin.catalog.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import admin.catalog.todo.entities.Todo;
import admin.catalog.utils.pagination.PaginationResponse;
import admin.catalog.utils.pagination.SearchParams;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

    @PatchMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable Long id) {
        Todo todo = this.todoService.getTodoById(id);
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        this.todoService.deleteTodo(id);
        return "Successfully deleted";
    }

}
