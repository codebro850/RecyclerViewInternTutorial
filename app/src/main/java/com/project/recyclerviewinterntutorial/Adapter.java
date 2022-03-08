package com.project.recyclerviewinterntutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    Context context;
    ArrayList<ModelClass> usersList;
    private OnItemClickListener listener;

    public Adapter(Context context) {
        usersList = new ArrayList<>();
        this.context = context;


        try {
            this.listener = ((OnItemClickListener) (context));
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {

        if (usersList != null) {
            return usersList.size();
        }
        return 0;

    }

    public void setData(ArrayList<ModelClass> userList) {
       /* usersList.clear();
        usersList.addAll(userList);*/
        this.usersList = userList;
        notifyItemInserted(usersList.size() - 1);
    }

    public interface OnItemClickListener {
        void onItemClick(int number);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvAge, tvNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAge = itemView.findViewById(R.id.tv_age);
            tvName = itemView.findViewById(R.id.tv_name);
            tvNumber = itemView.findViewById(R.id.tv_number);

            tvNumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(context,"clicked"+getAdapterPosition(),Toast.LENGTH_SHORT).show();
                    listener.onItemClick(usersList.get(getAdapterPosition()).getNumber());
                }
            });


        }

        public void bind(int position) {

            if (usersList != null) {
                tvName.setText(usersList.get(position).getName());
                tvAge.setText("" + usersList.get(position).getAge());
                tvNumber.setText("" + usersList.get(position).getNumber());
            }
        }

    }
}
