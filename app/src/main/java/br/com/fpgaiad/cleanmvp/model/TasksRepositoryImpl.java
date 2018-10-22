package br.com.fpgaiad.cleanmvp.model;

import java.util.ArrayList;
import java.util.List;

public class TasksRepositoryImpl implements TasksRepository {

    private List<String> list = new ArrayList<>();

    public void addTask(String task) {
        list.add(0, task);
    }

    @Override
    public void deleteTask(String task) {
        list.remove(task);
    }

    @Override
    public List<String> getTasks() {
        return list;
    }

}
