import React from "react";
import { Todo } from "../../../types/todoTypes";
import "./TodoForm.css";

interface TodoFormProps {
  currentTodo: Todo | null;
  onSave: () => void;
  onCancel: () => void;
}

// TodoFormProps
// currentTodo, onSave, onCancel}
const TodoForm: React.FC = () => {
  return (
    <div className="form-container">
      <h2>Save or Edit</h2>
      <form>
        <div>
          <label>Title</label>
          <input type="text" name="title" />
        </div>
        <div>
          <label>Description</label>
          <input type="text" name="description" />
        </div>
        {/* <div>
          <label>Completed</label>
          <input type="checkbox" name="completed" />
        </div> */}
        <button type="submit">Save</button>
        <button type="button" className="cancel-button">
          Cancel
        </button>
      </form>
    </div>
  );
};

export default TodoForm;
