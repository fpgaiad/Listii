package br.com.fpgaiad.cleanmvp.model;

import java.util.List;

public interface TasksRepository {
    void addTask(String task);
    void deleteTask(String task);
    List<String> getTasks();
}

