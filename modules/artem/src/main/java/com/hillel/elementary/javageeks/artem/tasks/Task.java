package com.hillel.elementary.javageeks.artem.tasks;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Task {
    private final String name;
    private final TaskType type;
    private final LocalDate creationDate;
    private final List<String> tags;

    public Task(String name, TaskType type, LocalDate creationDate, List<String> tags) {
        this.name = name;
        this.type = type;
        this.creationDate = creationDate;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public TaskType getType() {
        return type;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name) &&
                type == task.type &&
                Objects.equals(creationDate, task.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, creationDate);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", creationDate=" + creationDate +
                ", tags=" + tags +
                '}';
    }
}
