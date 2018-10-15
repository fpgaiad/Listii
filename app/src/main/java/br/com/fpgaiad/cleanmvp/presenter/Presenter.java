package br.com.fpgaiad.cleanmvp.presenter;

import java.util.List;

public interface Presenter {
    void addTask(String task);
    void deleteTask(int index);
    List<String> getList();
    void loadList(List<String> list);
}
