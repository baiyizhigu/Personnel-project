package com.gec.entity;

import java.io.Serializable;

public class Department implements Serializable {
	private static final long serialVersionUID = -5207511028523597090L;

	private int id;
	private String name;
	private String describer;
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

	public String getDescriber() {
		return describer;
	}

	public void setDescriber(String describer) {
		this.describer = describer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Department(int id, String name, String describer) {
		super();
		this.id = id;
		this.name = name;
		this.describer = describer;
	}

	public Department(int id, String name, String describer, int old_id) {
		super();
		this.id = id;
		this.name = name;
		this.describer = describer;
		this.old_id = old_id;
	}

	public Department(String name, String describer) {
		super();
		this.name = name;
		this.describer = describer;
	}

	public Department() {
		super();
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", describer=" + describer + "]";
	}

}
