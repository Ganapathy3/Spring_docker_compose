package com.demo.compose;

import jakarta.persistence.*;

/**
 * Todo — a Java object that maps to a database table.
 *
 * Like a 5-year-old:
 *   @Entity  = "This class is a table in the database"
 *   @Id      = "This field is the unique ID (primary key)"
 *   Each field = one column in the table
 *
 * JPA automatically creates this table in PostgreSQL on startup!
 */
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment ID
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private boolean completed = false;

    // ---- Constructors ----
    public Todo() {}

    public Todo(String title) {
        this.title = title;
    }

    // ---- Getters & Setters ----
    public Long getId()               { return id; }
    public String getTitle()          { return title; }
    public boolean isCompleted()      { return completed; }

    public void setId(Long id)               { this.id = id; }
    public void setTitle(String title)       { this.title = title; }
    public void setCompleted(boolean done)   { this.completed = done; }
}
