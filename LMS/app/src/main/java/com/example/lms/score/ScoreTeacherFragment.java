package com.example.lms.score;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lms.R;
import com.example.lms.lms.CommonAskTask;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Locale;

public class ScoreTeacherFragment extends Fragment {
    RecyclerView recv_scoret;
    ArrayList<ScoreVO> teacher_score_list;
    SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_score_teacher, container, false);

        String id = this.getArguments().getString("id");
        String name = this.getArguments().getString("name");
        Log.d("score", "onCreateView: 아이디 " +id);
        teacher_score_list= new ArrayList<>();

        CommonAskTask task = new CommonAskTask("and_scoret_list.sc", getContext());
        task.addParam("id", id);
        Log.d("score", "onCreateView: " + id);
        task.executeAsk(new CommonAskTask.AsynckTaskCallback() {
            @Override
            public void onResult(String data, boolean isResult) {
                Log.d("교수", "onResult: isResult<<<<<< " + isResult);
                if(isResult) {
                    teacher_score_list =
                            new Gson().fromJson(data, new TypeToken<ArrayList<ScoreVO>>() {
                            }.getType());
                    ScoreTeacherAdapter adapter = new ScoreTeacherAdapter(inflater,teacher_score_list,getContext());
                    RecyclerView.LayoutManager manager = new LinearLayoutManager(
                            getContext(),RecyclerView.VERTICAL,false
                    );
/*
                    searchView = v.findViewById(R.id.search_student);
                    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                        @Override
                        public boolean onQueryTextSubmit(String query) {
                            return false;
                        }

                        @Override
                        public boolean onQueryTextChange(String newText) {
                            ArrayList<ScoreVO> filter = new ArrayList<>();                                    ;
                            for(int i = 0; i< teacher_score_list.size(); i++){
                                *//*filter = new ArrayList<>();*//*
                                if(teacher_score_list.get(i).getName().toLowerCase().contains(newText.toLowerCase())){
                                    filter.add(teacher_score_list.get(i));
                                }
                            }
                                Log.d("score", "onQueryTextChange: filter리스트 사이즈 :      " + filter.size());

                            return false;
                        }
                    });

                    */
                    recv_scoret = v.findViewById(R.id.recv_scoret);

                    recv_scoret.setAdapter(adapter);
                    recv_scoret.setLayoutManager(manager);

                }
            }
        });


        return v;
    }
}