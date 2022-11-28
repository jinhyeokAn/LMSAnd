package com.example.lms.notice;

import androidx.fragment.app.Fragment;

import com.example.lms.sidemenu.SideVO;

import java.io.Serializable;
import java.util.ArrayList;

public class NoticeVO implements Serializable {
	private int  readcnt, id;
	private String title, content, writer,filename,	filepath;
	private String writedate;
	private Fragment fragment;
	ArrayList<SideVO> list = new ArrayList<>();

	public NoticeVO(int readcnt, int id, String title, String content, String writer, String filename, String filepath, String writedate, Fragment fragment, ArrayList<SideVO> list) {
		this.readcnt = readcnt;
		this.id = id;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.filename = filename;
		this.filepath = filepath;
		this.writedate = writedate;
		this.fragment = fragment;
		this.list = list;
	}

	public NoticeVO(int readcnt, int id, String title, String content, String writer, String filename, String filepath, String writedate, ArrayList<SideVO> list) {
		this.readcnt = readcnt;
		this.id = id;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.filename = filename;
		this.filepath = filepath;
		this.writedate = writedate;
		this.list = list;
	}

	public NoticeVO(int readcnt, int id, String title, String content, String writer, String filename, String filepath, String writedate) {
		this.readcnt = readcnt;
		this.id = id;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.filename = filename;
		this.filepath = filepath;
		this.writedate = writedate;
	}




	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}












}
