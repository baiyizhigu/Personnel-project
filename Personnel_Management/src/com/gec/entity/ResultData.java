package com.gec.entity;

import java.io.Serializable;
import java.util.HashMap;

public class ResultData implements Serializable{
	private static final long serialVersionUID = 7279362549194130137L;
	private boolean ok;// 是否成功的标志
	private HashMap<String, Object> datas = new HashMap<>();// 用于存放数据

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public HashMap<String, Object> getDatas() {
		return datas;
	}

	public void setDatas(HashMap<String, Object> datas) {
		this.datas = datas;
	}

	public ResultData(boolean ok, HashMap<String, Object> datas) {
		super();
		this.ok = ok;
		this.datas = datas;
	}

	public ResultData(boolean ok) {
		super();
		this.ok = ok;
	}

	public ResultData() {
		super();
	}

	@Override
	public String toString() {
		return "ResultData [ok=" + ok + ", datas=" + datas + "]";
	}
}
