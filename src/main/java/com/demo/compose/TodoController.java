package com.demo.compose;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * TodoController — REST API that stores data in PostgreSQL
 *
 * Endpoints:
 *   GET    /todos         → get all todos
 *   POST   /todos         → create a new todo
 *   PUT    /todos/{id}    → mark todo as complete
 *   DELETE /todos/{id}    → delete a todo
 *   GET    /todos/health  → check DB connection
 *
 * The data is stored in POSTGRES CONTAINER
 * connected via Docker Compose network!
 */
@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoRepository repo;

    public TodoController(TodoRepository repo) {
        this.repo = repo;
    }

    // -----------------------------------------------
    // GET /todos — fetch all todos from DB
    // -----------------------------------------------
    @GetMapping
    public List<Todo> getAll() {
        return repo.findAll();
    }

    // -----------------------------------------------
    // POST /todos — save a new todo to DB
    // Body: { "title": "Learn Docker Compose" }
    // -----------------------------------------------
    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return repo.save(todo);
    }

    // -----------------------------------------------
    // PUT /todos/{id} — mark as completed
    // -----------------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<Todo> complete(@PathVariable Long id) {
        return repo.findById(id)
                .map(todo -> {
                    todo.setCompleted(true);
                    return ResponseEntity.ok(repo.save(todo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // -----------------------------------------------
    // DELETE /todos/{id} — remove from DB
    // -----------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // -----------------------------------------------
    // GET /todos/health — sanity check
    // -----------------------------------------------
    @GetMapping("/health")
    public String health() {
        long count = repo.count();
        return "✅ Connected to PostgreSQL! Total todos in DB: " + count;
    }
}
