import axios from "axios";
import { Todo } from "../types/todoTypes";

const API_URL = import.meta.env.VITE_API_URL;

class TodoService {
  getAll(params: any) {
    return axios.get(`${API_URL}/search`, { params });
  }

  create(todo: Todo) {
    return axios.post(API_URL, todo);
  }

  update(id: number, todo: Todo) {
    return axios.put(`${API_URL}/${id}`, todo);
  }

  delete(id: number) {
    return axios.delete(`${API_URL}/${id}`);
  }
}

export default new TodoService();
