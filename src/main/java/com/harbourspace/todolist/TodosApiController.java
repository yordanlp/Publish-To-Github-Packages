package com.harbourspace.todolist;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TodosApiController  {

    List<TodoItem> TodoList;
    public TodosApiController() {
        TodoList = new ArrayList<>();
    }

    @PostMapping("/api/todos")
    public ResponseEntity<TodoItem> addTodo(@RequestBody @NotNull TodoItemDto body) {
        var maxId = TodoList.stream().map(item -> item.getId()).max((a, b) -> a > b ? a : b).orElse(0);

        var item = new TodoItem(maxId + 1, body.Title, body.Description, body.IsDone, body.CreatedAt, body.UpdatedAt);
        TodoList.add(item);
        return new ResponseEntity<TodoItem>(item, HttpStatus.CREATED);
    }

    @GetMapping("/api/todos")
    public ResponseEntity<List<TodoItem>> getTodos() {
        return new ResponseEntity<List<TodoItem>>(TodoList, HttpStatus.OK);
    }

}
