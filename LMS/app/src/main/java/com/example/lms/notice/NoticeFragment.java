package com.example.lms.notice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.lms.R;
import com.example.lms.lms.CommonAskTask;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class NoticeFragment extends Fragment {
    ExpandableListView exp_notice;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notice, container, false);
        exp_notice = v.findViewById(R.id.exp_notice);








        notice_select();

        return v;
    }




    public void notice_select(){

        CommonAskTask askTask = new CommonAskTask("notice.list",getContext());
        askTask.executeAsk(new CommonAskTask.AsynckTaskCallback() {
            @Override
            public void onResult(String data, boolean isResult) {
                Log.d("공지사항", "onResult: "+data);
                if (isResult) {
                    ArrayList<NoticeVO> list =
                            new Gson().fromJson(data, new TypeToken<ArrayList<NoticeVO>>() {
                            }.getType());
                    Log.d("공지사항", "onResult: " + list.size());
                    ArrayList<NoticeVO> parentList = new ArrayList<>();
                    int parentPosition = 0 ;

                    NoticeAdapter adapter = new NoticeAdapter(getLayoutInflater(), parentList);
                    exp_notice.setAdapter(adapter);
                }
            }
        });

    }








}