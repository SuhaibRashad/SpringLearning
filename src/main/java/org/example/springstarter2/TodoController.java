package org.example.springstarter2;

import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private static List<Todo> todoList;

    public TodoController(){
        todoList = new ArrayList<>();
        todoList.add(new Todo(1, false, "Todo1", 1));
        todoList.add(new Todo(2, true, "Todo2", 2));

    }
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo){
        todoList.add(newTodo);
        return ResponseEntity.status(201).body(newTodo);
    }

    @GetMapping
    public ResponseEntity getTodos(@RequestParam(required = false , defaultValue = "false") boolean isCompleted){
        System.out.println("Incoming query params "+ isCompleted);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{todoID}")
    public ResponseEntity<?> getTodoByID(@PathVariable long todoID){
        return todoList.stream()
                .filter(todo -> todo.getId() == todoID)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.OK).build());
    }
}
