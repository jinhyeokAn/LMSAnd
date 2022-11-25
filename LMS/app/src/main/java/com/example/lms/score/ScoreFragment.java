package com.example.lms.score;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.lms.MainActivity;
import com.example.lms.R;
import com.example.lms.lms.CommonAskTask;
import com.example.lms.member.LoginActivity;
import com.example.lms.member.MemberVO;
import com.example.lms.sidemenu.SideVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;


public class ScoreFragment extends Fragment {
    RecyclerView recv_score;
   /* ArrayList<ScoreVO> list;*/
    ArrayList<ScoreVO> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_score, container, false);
        String id = this.getArguments().getString("id");
        Log.d("score", "onCreateView: 아이디 " +id);
        list= new ArrayList<>();
        View detail = getLayoutInflater().inflate(R.layout.item_score_detail,null);

        CommonAskTask  task = new CommonAskTask("and_score_list.lec", getContext());
        task.addParam("id", id);
        Log.d("score", "onCreateView: " + id);
        task.executeAsk(new CommonAskTask.AsynckTaskCallback() {
            @Override
            public void onResult(String data, boolean isResult) {
                if(isResult) {
                   list =
                            new Gson().fromJson(data, new TypeToken<ArrayList<ScoreVO>>() {
                            }.getType());
                    ScoreAdapter adapter = new ScoreAdapter(inflater,list,getContext());
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(
                            getContext(),RecyclerView.VERTICAL,false
                    );
                    recv_score = v.findViewById(R.id.recv_score);

                    recv_score.setAdapter(adapter);
                    recv_score.setLayoutManager(manager);
                }
            }
        });



        return v;
    }
}