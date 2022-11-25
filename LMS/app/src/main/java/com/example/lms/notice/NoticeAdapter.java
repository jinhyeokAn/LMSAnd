package com.example.lms.notice;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lms.R;

import java.util.ArrayList;

public class NoticeAdapter extends BaseExpandableListAdapter {

    LayoutInflater inflater;
    ArrayList<NoticeVO> list;

    public NoticeAdapter(LayoutInflater inflater, ArrayList<NoticeVO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_notice_recv, parent, false);
        TextView notice_contentex = convertView.findViewById(R.id.notice_contentex);
        notice_contentex.setText(list.get(groupPosition).getContent());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_notice_list, parent, false);
        TextView notice_title = convertView.findViewById(R.id.notice_title);
        TextView notice_time = convertView.findViewById(R.id.notice_time);
        TextView notice_content = convertView.findViewById(R.id.notice_content);

        notice_title.setText(list.get(groupPosition).getTitle());
        notice_time.setText(list.get(groupPosition).getWritedate());
        notice_content.setText(list.get(groupPosition).getContent());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
