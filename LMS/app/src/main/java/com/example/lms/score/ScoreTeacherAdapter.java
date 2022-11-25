package com.example.lms.score;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lms.R;

import java.util.ArrayList;

public class ScoreTeacherAdapter extends RecyclerView.Adapter<ScoreTeacherAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<ScoreVO> list;
    Context context;

    public ScoreTeacherAdapter(LayoutInflater inflater, ArrayList<ScoreVO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_scoret_list, parent, false);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, @SuppressLint("RecyclerView") int i) {
        h.tv_student_title.setText(list.get(i).getName() + "(" + list.get(i).getLecture_num() + ")");
        h.tv_score.setText(list.get(i).getSemesterpoint()+"");



        h.imgv_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getTag().equals("0")){

                View detail  = inflater.inflate(R.layout.item_scoret_detail , h.view_layout , true);

                 TextView lecture_title, detail_student_name, detail_lecture_year, detail_semester, detail_score, detail_score_name;
                  lecture_title  = detail.findViewById(R.id.detail_lecture_title);
                    detail_student_name = detail.findViewById(R.id.detail_student_name);
                    detail_lecture_year = detail.findViewById(R.id.detail_lecture_year);
                    detail_semester = detail.findViewById(R.id.detail_semester);
                    detail_score = detail.findViewById(R.id.detail_score);
                    detail_score_name = detail.findViewById(R.id.detail_score_name);

                    lecture_title.setText(list.get(i).getLecture_title() + "(" + list.get(i).getLecture_num() + ")");
                    Log.d("asdf", "onClick: " + list.get(i).getName());
                    detail_student_name.setText(list.get(i).getName());
                    detail_lecture_year.setText(list.get(i).getLecture_year());
                    detail_semester.setText(list.get(i).getSemester());
                    detail_score.setText(list.get(i).getSemesterpoint()+"");
                    detail_score_name.setText(list.get(i).getScore_name());
                    v.setTag("1");


                }else{
                    v.setTag("0");
                    h.view_layout.removeAllViews();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout view_layout ;
        ImageView imgv_arrow ;
        TextView tv_student_title,tv_score;

        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_arrow = v.findViewById(R.id.imgv_arrow);
            view_layout = v.findViewById(R.id.view_layout);
            tv_student_title =  v.findViewById(R.id.tv_student_title);
            tv_score = v.findViewById(R.id.tv_score);


            imgv_arrow.setTag("0");
        }
    }

}