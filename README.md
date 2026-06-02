# Day 4 — Docker Compose: Spring Boot + PostgreSQL 🐳

**Part of my Java Trends 2026 series** — one hands-on topic per day.

## What is this?

A Todo REST API built with Spring Boot that stores data in PostgreSQL — both running as Docker containers managed by Docker Compose.

## Architecture

```
You (browser/curl)
      ↓
  Spring Boot (container 1 — port 8080)
      ↓ SQL queries via Docker network
  PostgreSQL (container 2 — port 5432)
      ↓
  pgdata volume (data survives restarts!)
```

## Quick Start (5-year-old steps!)

### Step 1 — Make sure Docker Desktop is running
Look for the 🐳 whale in your taskbar

### Step 2 — Open terminal in project folder

### Step 3 — Run ONE command
```bash
docker compose up --build
```
Wait for: `Started DockerComposeDay4Application`

### Step 4 — Test it!
```bash
# Create a todo
curl -X POST http://localhost:8080/todos \
  -H "Content-Type: application/json" \
  -d "{\"title\": \"Learn Docker Compose\"}"

# Get all todos
curl http://localhost:8080/todos

# Check DB connection
curl http://localhost:8080/todos/health
```

### Step 5 — Stop everything
```bash
docker compose down
```

## Key Concepts Learned

| Concept | What it means |
|---|---|
| `services` | Each container definition |
| `depends_on` | Postgres starts BEFORE Spring Boot |
| `healthcheck` | Wait for Postgres to be truly ready |
| `networks` | Containers talk to each other by service name |
| `volumes` | Data survives container restarts |
| `DB_HOST: db` | "db" = Postgres service name — Docker resolves it! |

---
> Part of my **Java Trends 2026** daily commit series.
