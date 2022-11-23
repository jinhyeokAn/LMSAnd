package com.example.lms.timetable;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lms.R;

import java.util.ArrayList;

public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<TimeTableVO> list;

    public TimeTableAdapter(LayoutInflater inflater, ArrayList<TimeTableVO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_regist, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.lecture_num.setText(list.get(i).getLecture_num());
        holder.lecture_title.setText(list.get(i).getLecture_title());
        holder.lecture_room.setText(list.get(i).getLecture_room());
        holder.teacher_name.setText(list.get(i).getTeacher_name());
        holder.lecture_time.setText(list.get(i).getLecture_day() +"(" +list.get(i).getLecture_time() + ")");

        holder.btn_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.lecture_num.getContext(), TimeTableDetailActivity.class);

                holder.lecture_num.getContext().startActivity(intent);
            }
        });

        holder.btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView lecture_num, lecture_title, sortation, lecture_room, capacity, teacher_name, lecture_time, subjectcredit, state, book;
        Button btn_detail, btn_regist;

        public ViewHolder(@NonNull View v) {
            super(v);
            lecture_num = v.findViewById(R.id.lecture_num);
            lecture_title = v.findViewById(R.id.lecture_title);
            sortation = v.findViewById(R.id.sortation);
            lecture_room = v.findViewById(R.id.lecture_room);
            capacity = v.findViewById(R.id.capacity);
            teacher_name = v.findViewById(R.id.teacher_name);
            lecture_time = v.findViewById(R.id.lecture_time);
            subjectcredit = v.findViewById(R.id.subjectcredit);
            state = v.findViewById(R.id.state);
            book = v.findViewById(R.id.book);
            btn_detail = v.findViewById(R.id.btn_detail);
            btn_regist = v.findViewById(R.id.btn_regist);

        }
    }

}
