package com.example.lms.lecture;

import android.media.Image;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lms.R;
import com.example.lms.lms.CommonAskTask;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class LectureDetailFragment extends Fragment {
    ImageView lec_detail;
    RecyclerView lec_detail_recv;
    CardView lec_detai;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lecture_detail, container, false);

        lec_detai = v.findViewById(R.id.lec_detai);
        lec_detail_recv = v.findViewById(R.id.lec_detail_recv);
        lec_detail = v.findViewById(R.id.lec_detail);
        lecture_detail();
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
                    LectureDetailAdapter adapter = new LectureDetailAdapter(getLayoutInflater(), list, getActivity());
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(
                            getContext(), RecyclerView.VERTICAL, false
                    );


                    lec_detail_recv.setAdapter(adapter);
                    lec_detail_recv.setLayoutManager(manager);
                }else {
                    Log.d("TAG", "onResult: 안됨");
                }
            }
        });
    }
}