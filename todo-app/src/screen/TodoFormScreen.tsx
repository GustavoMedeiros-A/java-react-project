import React from "react";
import { useNavigate } from "react-router-dom";
import TodoForm from "../components/todo/TodoForm/TodoForm";

const TodoFormScreen: React.FC = () => {
  const navigate = useNavigate();

  const handleSave = () => {
    navigate("/list");
  };

  const handleCancel = () => {
    navigate("/list");
  };

  return (
    <div>
      <TodoForm
        onSave={handleSave}
        onCancel={handleCancel}
        currentTodo={null}
      />
    </div>
  );
};

export default TodoFormScreen;
