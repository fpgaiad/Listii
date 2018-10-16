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

public class MainActivity extends AppCompatActivity implements br.com.fpgaiad.cleanmvp.view.View, TaskListAdapter.ListItemClickListener {

    private Presenter presenter;
    private RecyclerView mainRecyclerView;
    private EditText editTextInputTask;
    private List<String> mList;
    private Toast mToast = null;

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
     * MainActivity internal method
     */
    private void verifyToastStatus() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

    /**
     * Methods triggered by the user
     * @param view
     */
    public void onButtonAddTaskClicked(View view) {
        String task = editTextInputTask.getText().toString();
        if (task.equals("")) {
            verifyToastStatus();
            String emptyTaskMessage = "Sorry! Nothing to add here";
            mToast = Toast.makeText(getApplicationContext(), emptyTaskMessage, Toast.LENGTH_SHORT);
            mToast.show();
            return;
        }
        presenter.addTask(task);
        verifyToastStatus();
        String addTaskMessage = "\"" + task + "\"\nADDED";
        mToast = Toast.makeText(getApplicationContext(), addTaskMessage, Toast.LENGTH_SHORT);
        mToast.show();
        editTextInputTask.getText().clear();
    }

    @Override
    public void onButtonDeleteTaskClicked(int clickedItemIndex) {
        String task = mList.get(clickedItemIndex);
        verifyToastStatus();
        String deleteTaskMessage = "\"" + task + "\"\nDELETED";
        mToast = Toast.makeText(this, deleteTaskMessage, Toast.LENGTH_LONG);
        mToast.show();
        presenter.deleteTask(clickedItemIndex);
    }

    /**
     * Method triggered by the presenter
     * @param list
     */
    @Override
    public void refresh(List<String> list) {
        mainRecyclerView.setAdapter(new TaskListAdapter(list, this));
        mList = list;
    }

}
