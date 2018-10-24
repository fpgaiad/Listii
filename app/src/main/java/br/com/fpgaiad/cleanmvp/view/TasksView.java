package br.com.fpgaiad.cleanmvp.view;

import java.util.List;

public interface TasksView {
    void showTaskList(List<String> taskList);
    void showMessage(String message);
    void cleanTaskInput();
}
