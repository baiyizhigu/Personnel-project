package com.gec.entity;

import java.io.Serializable;

public class Notice implements Serializable{
	private static final long serialVersionUID = 3697889873640285206L;
	
	private int id;
	private String title;
	private String content;
	private int admin_id;
	private String time;
	private String name;
	private int old_id;
	
	
	public int getOld_id() {
		return old_id;
	}
	public void setOld_id(int old_id) {
		this.old_id = old_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Notice(int id, String title, String content, int admin_id, String time) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.admin_id = admin_id;
		this.time = time;
	}
	
	public Notice(int id, String title, String content, String name, String time) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.name = name;
		this.time = time;
	}
	
	public Notice(int id, String title, String content, int admin_id) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.admin_id = admin_id;
	}
	
	public Notice(int id, String title, String content, int admin_id, String time, int old_id) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.admin_id = admin_id;
		this.time = time;
		this.old_id = old_id;
	}
	
	public Notice(String title, String content, int admin_id, String time) {
		super();
		this.title = title;
		this.content = content;
		this.admin_id = admin_id;
		this.time = time;
	}
	public Notice() {
		super();
	}
	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", content=" + content + ", admin_id=" + admin_id + ", time="
				+ time + "]";
	}
	
}
