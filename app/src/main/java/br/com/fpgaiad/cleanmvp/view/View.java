package br.com.fpgaiad.cleanmvp.view;

import java.util.List;

public interface View {

    void refresh(List<String> list);

    void addTaskButtonClicked(android.view.View view);
}
