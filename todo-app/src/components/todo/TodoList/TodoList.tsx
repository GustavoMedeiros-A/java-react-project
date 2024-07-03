import React, { useEffect, useState } from "react";
import { Todo } from "../../../types/todoTypes";
import "./TodoList.css";

interface TodoListProps {
  onEdit: (todo: Todo) => void;
}

const TodoList: React.FC<TodoListProps> = ({ onEdit }) => {
  const [todos, setTodos] = useState<Todo[]>([]);
  useEffect(() => {
    const fetchTodos = () => {
      const mock = [
        {
          id: 1,
          title: "Learn React",
          description: "Learn how to use React",
          completed: false,
        },
        {
          id: 2,
          title: "Learn TypeScript",
          description: "Learn how to use TypeScript",
          completed: true,
        },
      ];
      setTodos(mock);
    };
    fetchTodos();
  }, []);

  return (
    <div className="todo-container">
      <h2>Todo List</h2>
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
                <button onClick={() => onEdit(todo)} disabled={todo.completed}>
                  Edit
                </button>
              </td>
              <td className="completed-checkbox">
                <input
                  type="checkbox"
                  checked={todo.completed}
                  onChange={() => {
                    todo.completed = !todo.completed;
                    setTodos([...todos]);
                  }}
                />
              </td>

              <td>
                <button className="delete-button">Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TodoList;
