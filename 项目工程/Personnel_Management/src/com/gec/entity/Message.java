package com.gec.entity;

import java.io.Serializable;

public class Message implements Serializable {
	private static final long serialVersionUID = 4333755680739279613L;

	private int id;
	private int send_id;
	private String content;
	private int receive_id;
	private String time;
	private String state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSend_id() {
		return send_id;
	}

	public void setSend_id(int send_id) {
		this.send_id = send_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReceive_id() {
		return receive_id;
	}

	public void setReceive_id(int receive_id) {
		this.receive_id = receive_id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Message(int id, int send_id, String content, int receive_id, String time, String state) {
		super();
		this.id = id;
		this.send_id = send_id;
		this.content = content;
		this.receive_id = receive_id;
		this.time = time;
		this.state = state;
	}

	public Message(int send_id, String content, String time, String state) {
		super();
		this.send_id = send_id;
		this.content = content;
		this.time = time;
		this.state = state;
	}	

	public Message(int send_id, String content, int receive_id, String time) {
		super();
		this.send_id = send_id;
		this.content = content;
		this.receive_id = receive_id;
		this.time = time;
	}

	public Message() {
		super();
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", send_id=" + send_id + ", content=" + content + ", receive_id=" + receive_id
				+ ", time=" + time + ", state=" + state + "]";
	}

}
