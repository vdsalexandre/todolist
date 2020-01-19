package com.leclerc.todolist.todoservice;

import com.leclerc.todolist.model.Todo;
import com.leclerc.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository repository;

    @Override
    public List<Todo> findAllTodo() {
        return (List<Todo>) repository.findAll();
    }

    @Override
    public Optional<Todo> findTodoById(long id) {
        return repository.findById(id);
    }

    @Override
    public Todo addNewTodo(String todoName) {
        return repository.save(new Todo(todoName));
    }

    @Override
    public void updateTodo(Todo todo) {
        repository.save(todo);
    }

    @Override
    public void deleteTodo(long id) {
        repository.delete(findTodoById(id).get());
    }
}
