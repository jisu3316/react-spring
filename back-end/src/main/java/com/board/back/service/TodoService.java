package com.board.back.service;

import com.board.back.model.Todo;
import com.board.back.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @Transactional
    public Todo insertTodo(String todoName) {
        Todo todo = Todo.builder()
                .todoName(todoName)
                .build();
        return todoRepository.save(todo);
    }

    @Transactional
    public Todo updateTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(IllegalArgumentException::new);
        todo.modifyCompleted();
        return todo;
    }

    @Transactional
    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }
}
