package com.leclerc.todolist.repository;

import com.leclerc.todolist.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TodoRepository extends CrudRepository<Todo, Long> {

}
