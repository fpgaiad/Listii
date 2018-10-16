package br.com.fpgaiad.cleanmvp.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

    private List<String> list;

    public void addToList(String task) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(task);
    }

    @Override
    public void deleteFromList(int index) {
        list.remove(index);
    }

    @Override
    public List<String> returnActualList() {
        return list;
    }

}
