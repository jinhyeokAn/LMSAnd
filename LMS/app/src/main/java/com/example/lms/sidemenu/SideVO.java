package com.example.lms.sidemenu;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class SideVO {
    private String menu;
    private String subTitle;
    private String mainColor;
    private Fragment fragment;
    private int ImageId;

    ArrayList<SideVO> list = new ArrayList<>();
    public SideVO(String menu, String subTitle, String mainColor, ArrayList<SideVO> list , Fragment fragment) {
        this.menu = menu;
        this.subTitle = subTitle;
        this.mainColor = mainColor;
        this.list = list;
        this.fragment = fragment;
    }
    public SideVO(String menu, String subTitle, String mainColor, ArrayList<SideVO> list) {
        this.menu = menu;
        this.subTitle = subTitle;
        this.mainColor = mainColor;
        this.list = list;
    }

    public SideVO(String menu, Fragment fragment) {
        this.menu = menu;
        this.fragment = fragment;
    }


    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getMainColor() {
        return mainColor;
    }

    public void setMainColor(String mainColor) {
        this.mainColor = mainColor;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public ArrayList<SideVO> getList() {
        return list;
    }

    public void setList(ArrayList<SideVO> list) {
        this.list = list;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }
}
