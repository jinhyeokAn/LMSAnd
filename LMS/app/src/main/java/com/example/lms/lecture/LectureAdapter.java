package com.example.lms.lecture;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lms.MainActivity;
import com.example.lms.R;

import java.util.ArrayList;

public class LectureAdapter extends RecyclerView.Adapter<LectureAdapter.LecHolder> {
    LayoutInflater inflater;
    ArrayList<LectureVO> list;
    MainActivity activity;

    public LectureAdapter(LayoutInflater inflater, ArrayList<LectureVO> list, Activity activity) {
        this.inflater = inflater;
        this.list = list;
        this.activity = (MainActivity) activity;
    }


    @NonNull
    @Override
    public LecHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_lecture, parent, false);
        return new LecHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LecHolder h, int i) {
        h.teacher_name.setText(list.get(i).getTeacher_name());
        h.lecture_room.setText(list.get(i).getLecture_room());
        h.lecture_year.setText(list.get(i).getLecture_year());
        h.semester.setText(list.get(i).getSemester());
        h.lecture_title.setText(list.get(i).getLecture_title());
        h.lec_detai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new LectureDetailFragment()).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LecHolder extends RecyclerView.ViewHolder {
        CardView lec_detai;
        TextView lecture_title, teacher_name, semester, lecture_room,  lecture_year;


        public LecHolder(@NonNull View v) {
            super(v);
            lec_detai = v.findViewById(R.id.lec_detai);
            teacher_name = v.findViewById(R.id.teacher_name);
            lecture_room = v.findViewById(R.id.lecture_room);
            lecture_year = v.findViewById(R.id.lecture_year);
            semester = v.findViewById(R.id.semester);
            lecture_title = v.findViewById(R.id.lecture_title);
        }
    }
}
