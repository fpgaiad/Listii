package br.com.fpgaiad.cleanmvp.view;

import java.util.List;

public interface View {
    void refresh(List<String> list);
    void buttonAddTaskClicked(android.view.View view);
}
