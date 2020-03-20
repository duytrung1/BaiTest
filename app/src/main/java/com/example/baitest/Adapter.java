package com.example.baitest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.baitest.Modeel.Model;
import com.example.baitest.Modeel.Subjects;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private List<Subjects> modelList;
    private int layout;
    public  static  Subjects subjects;

    public Adapter(List<Subjects> modelList, Context context) {
        this.context = context;
        this.modelList = modelList;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, null);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Subjects dienThoai = modelList.get(position);
        holder.txt1.setText(dienThoai.getId());
        holder.txt2.setText(dienThoai.getEmployeeName());
        holder.txt3.setText(dienThoai.getEmployeeAge());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ScreenDetail.class);
               subjects=modelList.get(position);
               context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        LinearLayout linearLayout;
        TextView txt1, txt2, txt3, txt4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.number);
            txt2 = itemView.findViewById(R.id.name);
            txt3 = itemView.findViewById(R.id.age);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
