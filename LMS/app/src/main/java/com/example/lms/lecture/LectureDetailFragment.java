package com.example.lms.lecture;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lms.R;
import com.example.lms.lms.CommonAskTask;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class LectureDetailFragment extends Fragment {
    Button lec_detail;
    RecyclerView recv_lecture;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lecture_detail, container, false);

        recv_lecture = v.findViewById(R.id.recv_lecture);




        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        lecture_detail();
    }

    public void lecture_detail(){
        CommonAskTask task = new CommonAskTask("anddetail.lec", getContext());
        task.executeAsk(new CommonAskTask.AsynckTaskCallback() {
            @Override
            public void onResult(String data, boolean isResult) {
                if(isResult){
                    ArrayList<LectureVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<LectureVO>>(){}.getType());
                    LectureAdapter adapter = new LectureAdapter(getLayoutInflater(), list);
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(
                            getContext(), RecyclerView.VERTICAL, false
                    );


                    recv_lecture.setAdapter(adapter);
                    recv_lecture.setLayoutManager(manager);
                }
            }
        });
    }
}