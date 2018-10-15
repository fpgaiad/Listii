package br.com.fpgaiad.cleanmvp.presenter;

import java.util.List;

import br.com.fpgaiad.cleanmvp.model.Model;
import br.com.fpgaiad.cleanmvp.model.ModelImpl;
import br.com.fpgaiad.cleanmvp.view.View;

public class PresenterImpl implements Presenter {

    public View view;
    public Model model;
    public List<String> list;

    public PresenterImpl(View view) {
        this.view = view;
    }

    /**
     * Methods triggered by the View layer
     * and redirected to the Model layer
     *
     * @param task
     */
    @Override
    public void addTask(String task) {
        if (list == null) {
            model = new ModelImpl();
        }
        model.addToList(task);
        list = getList();
        loadList(list);
    }

    @Override
    public void deleteTask(int index) {
    }

    /**
     * Methods triggered by this Presenter layer
     * to the Model layer
     */
    public List<String> getList() {
        return model.returnActualList();
    }

    /**
     * Methods triggered by the Presenter layer
     * to the View layer
     * @param list
     */
    public void loadList(List<String> list) {
        view.refresh(list);
    }

}
