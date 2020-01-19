package com.leclerc.todolist.todoservice;

import com.leclerc.todolist.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<Todo> findAllTodo();
    Optional<Todo> findTodoById(long id);
    Todo addNewTodo(String todoName);
    void updateTodo(Todo todo);
    void deleteTodo(long id);
}
