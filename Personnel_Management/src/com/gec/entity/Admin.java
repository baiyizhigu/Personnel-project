package com.gec.entity;

import java.io.Serializable;

public class Admin implements Serializable {
	private static final long serialVersionUID = -5539819186103362058L;

	private int id;
	private String name;
	private String password;
	private String head;
	private String time;
	private String role;
	private int old_id;

	public int getOld_id() {
		return old_id;
	}

	public void setOld_id(int old_id) {
		this.old_id = old_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Admin(int id, String name, String password, String head, String time, String role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.head = head;
		this.time = time;
		this.role = role;
	}

	public Admin(int id, String name, String head, String role) {
		super();
		this.id = id;
		this.name = name;
		this.head = head;
		this.role = role;
	}

	public Admin() {
		super();
	}

	public Admin(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public Admin(int id, String name, String password, String head, String role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.head = head;
		this.role = role;
	}

	public Admin(int id, String name, String password, String role, int old_id) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.old_id = old_id;
	}

	public Admin(String name, String password, String time, String role) {
		super();
		this.name = name;
		this.password = password;
		this.time = time;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password + ", head=" + head + ", time=" + time
				+ ", role=" + role + "]";
	}

}
