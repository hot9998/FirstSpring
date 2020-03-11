package com.member.model;

import java.util.List;

public interface MemService {
	//추가
	//전체보기
	//상세보기
	//수정
	//삭제
	public void insert(MemberVO member);
	public List<MemberVO> list();
	public MemberVO view(String id);
	public void update(MemberVO member);
	public void delete(String id);	
}
