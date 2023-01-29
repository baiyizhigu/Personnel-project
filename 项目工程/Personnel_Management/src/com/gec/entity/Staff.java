package com.gec.entity;

import java.io.Serializable;

public class Staff implements Serializable {
	private static final long serialVersionUID = -7995791212197557732L;

	private int id;
	private String name;
	private String password;
	private String card;
	private String sex;
	private String head;
	private int position_id;
	private int department_id;
	private String phone;
	private String time;
	private String pos_name;
	private String dep_name;
	private int old_id;

	public int getOld_id() {
		return old_id;
	}

	public void setOld_id(int old_id) {
		this.old_id = old_id;
	}

	public String getPos_name() {
		return pos_name;
	}

	public void setPos_name(String pos_name) {
		this.pos_name = pos_name;
	}

	public String getDep_name() {
		return dep_name;
	}

	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
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

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public int getPosition_id() {
		return position_id;
	}

	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public Staff(int id, String name, String password, String card, String sex, String head, int position_id,
			int department_id, String phone, String time) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.card = card;
		this.sex = sex;
		this.head = head;
		this.position_id = position_id;
		this.department_id = department_id;
		this.phone = phone;
		this.time = time;
	}

	public Staff(int id, String name, String password, String head) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.head = head;
	}

	public Staff() {
		super();
	}

	public Staff(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public Staff(int id, String name, String sex, String head, String pos_name, String dep_name, String phone,
			String time) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.head = head;
		this.pos_name = pos_name;
		this.dep_name = dep_name;
		this.phone = phone;
		this.time = time;
	}

	public Staff(int id, String name, String password, String card, String sex, String head, String pos_name,
			String dep_name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.card = card;
		this.sex = sex;
		this.head = head;
		this.pos_name = pos_name;
		this.dep_name = dep_name;
		this.phone = phone;
	}

	public Staff(int id, String name, String password, String card, String sex, String head, String pos_name,
			String dep_name, String phone, String time) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.card = card;
		this.sex = sex;
		this.head = head;
		this.pos_name = pos_name;
		this.dep_name = dep_name;
		this.phone = phone;
		this.time = time;
	}

	public Staff(int id, String name, String password, String card, String phone, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.card = card;
		this.phone = phone;
		this.sex = sex;
	}

	public Staff(int id, String name, String password, String card, String sex, String head, int position_id,
			int department_id, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.card = card;
		this.sex = sex;
		this.head = head;
		this.position_id = position_id;
		this.department_id = department_id;
		this.phone = phone;
	}

	public Staff(int id, String name, String password, String card, String sex, int position_id, int department_id,
			String phone, int old_id) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.card = card;
		this.sex = sex;
		this.position_id = position_id;
		this.department_id = department_id;
		this.phone = phone;
		this.old_id = old_id;
	}

	public Staff(String name, String password, String card, String sex, int position_id, int department_id,
			String phone, String time) {
		super();
		this.name = name;
		this.password = password;
		this.card = card;
		this.sex = sex;
		this.position_id = position_id;
		this.department_id = department_id;
		this.phone = phone;
		this.time = time;
	}
	
	public Staff(int id, String name, String head) {
		super();
		this.id = id;
		this.name = name;
		this.head = head;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", password=" + password + ", card=" + card + ", sex=" + sex
				+ ", head=" + head + ", position_id=" + position_id + ", department_id=" + department_id + ", phone="
				+ phone + ", time=" + time + "]";
	}
}
