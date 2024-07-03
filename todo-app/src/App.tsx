import "./App.css";
import { Link, Route, Routes } from "react-router-dom";
import Header from "./components/header/Header";
import TodoForm from "./components/todo/TodoForm/TodoForm";
import TodoListScreen from "./screens/TodoListScreen";

function App() {
  return (
    <div className="App">
      <Header />
      <header className="App-header">
        <Routes>
          <Route path="/list" element={<TodoListScreen />}></Route>
          <Route path="/add" element={<TodoForm />}></Route>
        </Routes>
      </header>
    </div>
  );
}

export default App;
