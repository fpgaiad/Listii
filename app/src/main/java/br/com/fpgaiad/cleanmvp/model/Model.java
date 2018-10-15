package br.com.fpgaiad.cleanmvp.model;

import java.util.List;

public interface Model {
    void addToList(String task);
    List<String> returnActualList();
}

