package com.demo.compose;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TodoRepository — your database remote control!
 *
 * Like a 5-year-old:
 *   You don't write any SQL.
 *   Spring Data JPA reads the method names and
 *   figures out the SQL automatically.
 *
 *   findAll()    → SELECT * FROM todos
 *   save(todo)   → INSERT INTO todos ...
 *   deleteById() → DELETE FROM todos WHERE id = ?
 *   findById()   → SELECT * FROM todos WHERE id = ?
 *
 * That's it — no SQL, no boilerplate, pure magic!
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // Spring Data gives you all basic CRUD for FREE!
    // No code needed here — it's all inherited.
}
