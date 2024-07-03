import React, { useEffect, useState } from "react";
import { Todo } from "../../../types/todoTypes";
import "./TodoForm.css";
import TodoService from "../../../services/TodoService";

interface TodoFormProps {
  currentTodo: Todo | null;
  onSave: () => void;
  onCancel: () => void;
}

// TodoFormProps
// currentTodo, onSave, onCancel}
const TodoForm: React.FC<TodoFormProps> = ({
  currentTodo,
  onCancel,
  onSave,
}) => {
  const [todo, setTodo] = useState<Todo>({
    title: "",
    description: "",
    completed: false,
  });

  useEffect(() => {
    if (currentTodo) {
      setTodo(currentTodo);
    }
  }, [currentTodo]);

  const handleCancel = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value, type, checked } = e.target;
    setTodo((prevTodo) => ({
      ...prevTodo,
      [name]: type === "checkbox" ? checked : value,
    }));
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      if (todo.id) {
        await TodoService.update(todo.id, todo);
      } else {
        await TodoService.create(todo);
      }
      onSave();
      setTodo({
        title: "",
        description: "",
        completed: false,
      });
    } catch (err) {
      console.error(err);
      return;
    }
  };

  return (
    <div className="form-container">
      <h2>{todo.id ? "Edit Todo" : "Add Todo"}</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Title</label>
          <input
            type="text"
            name="title"
            value={todo.title}
            onChange={handleCancel}
          />
        </div>
        <div>
          <label>Description</label>
          <input
            type="text"
            name="description"
            value={todo.description}
            onChange={handleCancel}
          />
        </div>
        <button type="submit">Save</button>
        <button type="button" className="cancel-button" onClick={onCancel}>
          Cancel
        </button>
      </form>
    </div>
  );
};

export default TodoForm;
