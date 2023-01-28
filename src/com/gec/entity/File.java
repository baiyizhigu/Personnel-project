package com.gec.entity;

import java.io.Serializable;

public class File implements Serializable {
	private static final long serialVersionUID = -7339118257715813725L;

	private int id;
	private String title;
	private String name;
	private int upload_id;
	private String time;
	private String file_name;
	private String sta_name;
	private String all_name;
	private String identity;

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getAll_name() {
		return all_name;
	}

	public void setAll_name(String all_name) {
		this.all_name = all_name;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getSta_name() {
		return sta_name;
	}

	public void setSta_name(String sta_name) {
		this.sta_name = sta_name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUpload_id() {
		return upload_id;
	}

	public void setUpload_id(int upload_id) {
		this.upload_id = upload_id;
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

	public File(int id, String title, String name, int upload_id, String time) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.upload_id = upload_id;
		this.time = time;
	}

	public File() {
		super();
	}

	public File(String title, int upload_id, String time, String identity) {
		super();
		this.title = title;
		this.upload_id = upload_id;
		this.time = time;
		this.identity = identity;
	}

	public File(int id, String title, String file_name, String all_name, String time) {
		super();
		this.id = id;
		this.title = title;
		this.file_name = file_name;
		this.all_name = all_name;
		this.time = time;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", title=" + title + ", name=" + name + ", upload_id=" + upload_id + ", time=" + time
				+ "]";
	}

}
