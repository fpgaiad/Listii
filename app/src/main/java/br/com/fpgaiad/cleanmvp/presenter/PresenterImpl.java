package br.com.fpgaiad.cleanmvp.presenter;

import java.util.List;

import br.com.fpgaiad.cleanmvp.model.Model;
import br.com.fpgaiad.cleanmvp.model.ModelImpl;
import br.com.fpgaiad.cleanmvp.view.View;

public class PresenterImpl implements Presenter {

    public final View view;
    public Model model;
    private List<String> list;

    public PresenterImpl(View view) {
        this.view = view;
    }


    @Override
    public void addTask(String task) {
        if (list == null) {
            model = new ModelImpl();
            list = model.addToList(task);
        } else {
            list = model.addToList(task);
        }
        view.refresh(list);
    }

    @Override
    public void deleteTask(int index) {

    }
}
