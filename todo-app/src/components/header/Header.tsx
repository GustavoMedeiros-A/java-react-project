import React from "react";
import { Link } from "react-router-dom";
import "./Header.css";

const Header: React.FC = () => {
  return (
    <div className="header">
      <nav>
        <ul>
          <li>
            <Link to="/list">Todo List</Link>
          </li>
          <li>
            <Link to="/add">Add Todo</Link>
          </li>
        </ul>
      </nav>
    </div>
  );
};

export default Header;
