import React from "react";
import { Todo } from "../types/todoTypes";
import TodoList from "../components/todo/TodoList/TodoList";

interface TodoListScreenProps {
  onEditSelect: (id: string) => void;
}

const TodoListScreen: React.FC<TodoListScreenProps> = ({ onEditSelect }) => {
  const handleEdit = (todo: Todo) => {
    onEditSelect(todo.id!.toString());
  };

  return (
    <div>
      <h1>Todo List</h1>
      <TodoList onEdit={handleEdit} />
    </div>
  );
};

export default TodoListScreen;
