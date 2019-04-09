package br.com.fpgaiad.cleanmvp.presenter


import br.com.fpgaiad.cleanmvp.model.TasksRepository
import br.com.fpgaiad.cleanmvp.view.TasksView

class TaskPresenterImpl(val view: TasksView?, val repository: TasksRepository) : TaskPresenter {

    override fun onAddTaskClicked(task: String?) {
        if (task.equals("")) {
            view?.showMessage("Sorry, nothing to add here!")
        } else {
            repository.addTask(task)
            view?.let {
                it.cleanTaskInput()
                it.showMessage("\"$task\"\nADDED")
                it.showTaskList(repository.tasks)
            }
        }
    }

    override fun onDeleteTaskClicked(task: String?) {
        task?.let { repository.deleteTask(it) }
        view?.let {
            it.showMessage("DELETED")
            it.showTaskList(repository.tasks)
        }
    }
}