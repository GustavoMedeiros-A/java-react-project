import React from "react";
import { Todo } from "../types/todoTypes";
import TodoList from "../components/todo/TodoList/TodoList";

const TodoListScreen: React.FC = () => {
  const handleEdit = (todo: Todo) => {
    console.log("is editing");
  };

  return (
    <div>
      <h1>Todo List</h1>
      <TodoList onEdit={handleEdit} />
    </div>
  );
};

export default TodoListScreen;
