package br.com.fpgaiad.cleanmvp.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.fpgaiad.cleanmvp.R;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ListViewHolder> {

    private final List<String> list;
    private final View.OnClickListener clickListener;


    public TaskListAdapter(List<String> list, View.OnClickListener listener) {
        this.list = list;
        clickListener = listener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        String task = list.get(position);
        holder.ivDeleteTask.setTag(task);
        holder.taskName.setText(task);
        holder.taskIndex.setText(String.valueOf(position + 1));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView taskName;
        TextView taskIndex;
        ImageView ivDeleteTask;

        public ListViewHolder(View itemView) {
            super(itemView);
            taskIndex = itemView.findViewById(R.id.tv_task_index);
            taskName = itemView.findViewById(R.id.tv_task_name);
            ivDeleteTask = itemView.findViewById(R.id.iv_delete_icon);
            ivDeleteTask.setOnClickListener(clickListener);
        }
    }
}
