package br.com.fpgaiad.cleanmvp.model;

import java.util.List;

public interface Model {
    void addToList(String task);
    void deleteFromList(int index);
    List<String> returnActualList();
}

