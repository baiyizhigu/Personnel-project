package com.gec.entity;

import java.io.Serializable;

public class Positions implements Serializable{
	private static final long serialVersionUID = 2676239913048320658L;
	
	private int id;
	private String name;
	private int department_id;
	private String dep_name;
	private String describer;
	private int old_id;
	public int getOld_id() {
		return old_id;
	}
	public void setOld_id(int old_id) {
		this.old_id = old_id;
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
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
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
	public Positions(int id, String name, int department_id, String describer) {
		super();
		this.id = id;
		this.name = name;
		this.department_id = department_id;
		this.describer = describer;
	}
	
	public Positions(int id, String name, String dep_name, String describer) {
		super();
		this.id = id;
		this.name = name;
		this.dep_name = dep_name;
		this.describer = describer;
	}
	
	public Positions(int id, String name, int department_id, String describer, int old_id) {
		super();
		this.id = id;
		this.name = name;
		this.department_id = department_id;
		this.describer = describer;
		this.old_id = old_id;
	}
	
	public Positions(String name, int department_id, String describer) {
		super();
		this.name = name;
		this.department_id = department_id;
		this.describer = describer;
	}
	public Positions() {
		super();
	}
	@Override
	public String toString() {
		return "Positions [id=" + id + ", name=" + name + ", department_id=" + department_id + ", describer="
				+ describer + "]";
	}	
	
}
