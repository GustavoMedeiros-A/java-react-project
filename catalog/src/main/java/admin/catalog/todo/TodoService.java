package admin.catalog.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import admin.catalog.todo.dto.UpdateCheckboxTodo;
import admin.catalog.todo.entities.Todo;
import admin.catalog.todo.entities.TodoSpecifications;
import admin.catalog.utils.exceptions.NotFoundException;
import admin.catalog.utils.pagination.PaginationResponse;
import admin.catalog.utils.pagination.SearchParams;
import admin.catalog.utils.pagination.SearchParamsFactory;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public String createTodo(Todo item) {
        this.todoRepository.save(item);
        return "Created todo item";
    }

    public PaginationResponse<Todo> getAllTodos(SearchParams params) {
        PageRequest pageRequest = SearchParamsFactory.createPageRequest(params);
        Specification<Todo> specification = TodoSpecifications.withFilter(params.getFilter());

        Page<Todo> pageResult = this.todoRepository.findAll(specification, pageRequest);

        return new PaginationResponse<>(pageResult.getContent(), pageResult.getNumber() + 1, pageResult.getSize(),
                pageResult.getTotalElements());
    }

    public Todo getTodoById(Long id) {
        return this.todoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Todo with id " + id + " not found", null));
    }

    public void updateTodo(Long id, Todo entity) {
        Todo todo = this.getTodoById(id);
        todo.setTitle(entity.getTitle());
        todo.setDescription(entity.getDescription());
        this.todoRepository.save(todo);
    }

    public void updateStatus(Long id, UpdateCheckboxTodo status) {
        Todo todo = this.getTodoById(id);
        todo.setCompleted(status.isCompleted());
        this.todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        this.getTodoById(id);
        this.todoRepository.deleteById(id);
    }

}
