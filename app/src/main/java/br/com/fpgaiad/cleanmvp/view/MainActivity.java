/**
 * Felipe P. Gaiad
 * MVP/Clean Architecture project
 */

package br.com.fpgaiad.cleanmvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import br.com.fpgaiad.cleanmvp.R;
import br.com.fpgaiad.cleanmvp.model.TasksRepositoryImpl;
import br.com.fpgaiad.cleanmvp.presenter.TaskPresenter;
import br.com.fpgaiad.cleanmvp.presenter.TaskPresenterImpl;

public class MainActivity extends AppCompatActivity implements TasksView {

    private TaskPresenter presenter;
    private RecyclerView mainRecyclerView;
    private EditText editTextInputTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new TaskPresenterImpl(this, new TasksRepositoryImpl());
        editTextInputTask = findViewById(R.id.et_input_task);
        mainRecyclerView = findViewById(R.id.rv_main);
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showTaskList(List<String> list) {
        mainRecyclerView.setAdapter(new TaskListAdapter(list, clickListener));
    }

    public void onButtonAddTaskClicked(View view) {
        String task = editTextInputTask.getText().toString();
        presenter.onAddTaskClicked(task);
    }

    public View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String task = (String) view.getTag();
            presenter.onDeleteTaskClicked(task);
        }
    };

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void cleanTaskInput() {
        editTextInputTask.getText().clear();
    }
}
