package br.com.fpgaiad.cleanmvp.presenter;

import br.com.fpgaiad.cleanmvp.model.TasksRepository;
import br.com.fpgaiad.cleanmvp.view.TasksView;

public class TaskPresenterImpl implements TaskPresenter {

    public TasksView view;
    private TasksRepository repository;

    public TaskPresenterImpl(TasksView view, TasksRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void onAddTaskClicked(String task) {
        if (task.equals("")) {
            view.showMessage("Sorry! Nothing to add here");
        } else {
            view.cleanTaskInput();
            view.showMessage("\"" + task + "\"\nADDED");
            repository.addTask(task);
            view.showTaskList(repository.getTasks());
        }
    }

    @Override
    public void onDeleteTaskClicked(String task) {
        repository.deleteTask(task);
        view.showMessage("DELETED");
        view.showTaskList(repository.getTasks());
    }
}
