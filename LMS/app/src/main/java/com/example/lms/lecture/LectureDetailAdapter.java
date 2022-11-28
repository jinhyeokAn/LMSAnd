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


import java.util.List;

public class LectureDetailAdapter extends RecyclerView.Adapter<LectureDetailAdapter.LecDeHolder> {
    LayoutInflater inflater;
    List<LectureVO> list;
    MainActivity activity;

    public LectureDetailAdapter(LayoutInflater inflater, List<LectureVO> list, Activity activity) {
        this.inflater = inflater;
        this.list = list;
        this.activity = (MainActivity) activity;
    }

    @NonNull
    @Override
    public LecDeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_lecture_detail, parent, false);
        return new LecDeHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LecDeHolder h, int i) {
        h.lecture_num.setText(list.get(i).getLecture_num());
        h.lecture_room.setText(list.get(i).getLecture_room());
        h.teacher_name.setText(list.get(i).getTeacher_name());
        h.lecture_title.setText(list.get(i).getLecture_title());
        h.lecture_year.setText(list.get(i).getLecture_year());
        h.semester.setText(list.get(i).getSemester());
        h.subjectcredit.setText(list.get(i).getSubjectcredit());
        h.book.setText(list.get(i).getBook());
        h.lecture_day.setText(list.get(i).getLecture_day());
        h.lecture_time.setText(list.get(i).getLecture_time());
        h.enrolment.setText(list.get(i).getEnrolment());
        h.capacity.setText(list.get(i).getCapacity());
        h.midex.setText(list.get(i).getMidex()+"");
        h.finalex.setText(list.get(i).getFinalex()+"");
        h.state.setText(list.get(i).getState());
        h.sortation.setText(list.get(i).getSortation());
        h.reception_status.setText(list.get(i).getReception_status());
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

    public class LecDeHolder extends RecyclerView.ViewHolder {
        TextView lecture_num, lecture_room, teacher_name, lecture_title, lecture_year, semester,
                 subjectcredit, book, lecture_day, lecture_time, enrolment, capacity, midex, finalex,
                 state, sortation, reception_status;
        CardView lec_detai;


        public LecDeHolder(@NonNull View v) {
            super(v);

            lec_detai = v.findViewById(R.id.lec_detai);

            lecture_num = v.findViewById(R.id.lecture_num);
            lecture_room = v.findViewById(R.id.lecture_room);
            teacher_name = v.findViewById(R.id.teacher_name);
            lecture_title = v.findViewById(R.id.lecture_title);
            lecture_year = v.findViewById(R.id.lecture_year);
            semester = v.findViewById(R.id.semester);
            subjectcredit = v.findViewById(R.id.subjectcredit);
            book = v.findViewById(R.id.book);
            lecture_day = v.findViewById(R.id.lecture_day);
            lecture_time = v.findViewById(R.id.lecture_time);
            enrolment = v.findViewById(R.id.enrolment);
            capacity = v.findViewById(R.id.capacity);
            midex = v.findViewById(R.id.midex);
            finalex = v.findViewById(R.id.finalex);
            state = v.findViewById(R.id.state);
            sortation = v.findViewById(R.id.sortation);
            reception_status = v.findViewById(R.id.reception_status);
        }
    }
}
