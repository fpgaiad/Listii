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
import br.com.fpgaiad.cleanmvp.presenter.Presenter;
import br.com.fpgaiad.cleanmvp.presenter.PresenterImpl;

public class MainActivity extends AppCompatActivity implements br.com.fpgaiad.cleanmvp.view.View {

    private Presenter presenter;
    private RecyclerView mainRecyclerView;
    private EditText editTextInputTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new PresenterImpl(this);

        editTextInputTask = findViewById(R.id.et_input_task);
        mainRecyclerView = findViewById(R.id.rv_main);

        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * Methods triggered by the presenter
     * @param list
     */
    @Override
    public void refresh(List<String> list) {
        mainRecyclerView.setAdapter(new TaskListAdapter(list));
    }

    /**
    * Methods triggered by the user
    */
    public void addTaskButtonClicked(View view) {
        String task = editTextInputTask.getText().toString();
        Toast.makeText(getApplicationContext(), "Task \"" + task + "\" added!", Toast.LENGTH_SHORT).show();
        editTextInputTask.getText().clear();
        presenter.addTask(task);
    }
}
