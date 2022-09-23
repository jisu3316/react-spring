package com.board.back.controller;

import com.board.back.dto.TodoRequest;
import com.board.back.model.Todo;
import com.board.back.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<Todo> getTodos() {
       return todoService.getTodos();
    }

    @PostMapping
    public Todo insertTodo(@RequestBody TodoRequest todoRequest) {
        return todoService.insertTodo(todoRequest.getTodoName());
    }

    @PutMapping("/{todoId}")
    public Todo updateTodo(@PathVariable Long todoId) {
        return todoService.updateTodo(todoId);
    }

    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable Long todoId) {
        todoService.deleteTodo(todoId);
    }

}
