import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { Todo } from "../types/todoTypes";
import TodoForm from "../components/todo/TodoForm/TodoForm";
import TodoService from "../services/TodoService";

const EditTodoScreen: React.FC = () => {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const [currentTodo, setCurrentTodo] = useState<Todo | null>(null);

  useEffect(() => {
    const fetchTodo = async () => {
      try {
        if (id) {
          const response = await TodoService.getById(id);
          setCurrentTodo(response.data);
        }
      } catch (error) {
        console.error("Error fetching todo", error);
      }
    };

    fetchTodo();
  }, [id]);

  const handleSaveOrCancel = () => {
    navigate("/list");
  };

  return (
    <div>
      <TodoForm
        currentTodo={currentTodo}
        onSave={handleSaveOrCancel}
        onCancel={handleSaveOrCancel}
      />
    </div>
  );
};

export default EditTodoScreen;
