import axios from "axios";
import { Todo } from "../types/todoTypes";

const API_URL = import.meta.env.VITE_API_URL;

class TodoService {
  getAll(params: any) {
    return axios.get(`${API_URL}`, { params });
  }

  getById(id: string) {
    return axios.get(`${API_URL}/${id}`);
  }

  create(todo: Todo) {
    return axios.post(API_URL, todo);
  }

  update(id: number, todo: Todo) {
    return axios.put(`${API_URL}/${id}`, todo);
  }

  updateStatus(id: number, status: { complete: boolean }) {
    return axios.patch(`${API_URL}/${id}/status`, status);
  }

  delete(id: number) {
    return axios.delete(`${API_URL}/${id}`);
  }
}

export default new TodoService();
