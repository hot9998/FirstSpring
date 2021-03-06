package com.guestapp.vo;

import org.springframework.stereotype.Component;

//@Component : 빈에 등록하는 어노테이션 (Autowired를 사용할때는 굳이 넣지않아도 됨)
@Component
public class GuestVO {
	private int num;
	private String name;
	private String content;
	private String grade;
	private String created;
	private String ipaddr;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

}
