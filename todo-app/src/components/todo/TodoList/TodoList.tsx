import React, { useEffect, useState } from "react";
import { Todo } from "../../../types/todoTypes";
import "./TodoList.css";
import TodoService from "../../../services/TodoService";
interface TodoListProps {
  onEdit: (todo: Todo) => void;
}

const TodoList: React.FC<TodoListProps> = ({ onEdit }) => {
  const [todos, setTodos] = useState<Todo[]>([]);

  useEffect(() => {
    fetchTodos();
  }, []);

  const fetchTodos = async () => {
    try {
      const response = await TodoService.getAll({});
      setTodos(response.data.content);
    } catch (error) {
      console.error(error);
    }
  };

  const deleteTodo = async (todoId: number) => {
    try {
      await TodoService.delete(todoId);
      setTodos((prevTodo) => prevTodo.filter((todo) => todo.id != todoId));
    } catch (err) {
      console.error(err);
    }
  };

  const handleChangeStatus = async (todo: Todo) => {
    try {
      const updatedTodo = { ...todo, completed: !todo.completed }; // Catch the inversion of the current status (if true, is now false and ...)
      await TodoService.updateStatus(todo.id!, {
        completed: updatedTodo.completed,
      });
      setTodos((prevTodos) =>
        prevTodos.map((t) => (t.id === todo.id ? updatedTodo : t))
      );
    } catch (err) {
      console.error(err);
    }
  };

  return (
    <div className="todo-container">
      <h2>ToDo List</h2>
      {todos.length > 0 ? (
        <table className="todo-table">
          <thead>
            <tr>
              <th>Title</th>
              <th>Description</th>
              <th>Edit</th>
              <th>Completed</th>
              <th>Delete</th>
            </tr>
          </thead>
          <tbody>
            {todos.map((todo) => (
              <tr key={todo.id} className={todo.completed ? "completed" : ""}>
                <td>{todo.title}</td>
                <td>{todo.description} </td>
                <td>
                  <button
                    onClick={() => onEdit(todo)}
                    disabled={todo.completed}
                  >
                    Edit
                  </button>
                </td>
                <td className="completed-checkbox">
                  <input
                    type="checkbox"
                    checked={todo.completed}
                    onChange={() => handleChangeStatus(todo)}
                  />
                </td>

                <td>
                  <button
                    className="delete-button"
                    onClick={() => deleteTodo(todo.id!)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <h3>No toDo's available</h3>
      )}
    </div>
  );
};

export default TodoList;
