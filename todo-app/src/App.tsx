import "./App.css";
import { Link, Route, Routes, useNavigate } from "react-router-dom";
import Header from "./components/header/Header";
import TodoForm from "./components/todo/TodoForm/TodoForm";
import TodoListScreen from "./screen/TodoListScreen";
import TodoFormScreen from "./screen/TodoFormScreen";
import EditTodoScreen from "./screen/TodoEditScreen";

function App() {
  const navigate = useNavigate();

  const handleEditSelect = (id: string) => {
    navigate(`/edit/${id}`);
  };

  return (
    <div className="App">
      <Header />
      <header className="App-header">
        <Routes>
          <Route
            path="/list"
            element={<TodoListScreen onEditSelect={handleEditSelect} />}
          ></Route>
          <Route path="/add" element={<TodoFormScreen />}></Route>
          <Route path="/edit/:id" element={<EditTodoScreen />}></Route>
        </Routes>
      </header>
    </div>
  );
}

export default App;
