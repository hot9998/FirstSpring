package org.zerock.service;

import org.zerock.domain.MemberVO;

public interface MemberService {
	public void register(MemberVO member);
	
	public MemberVO get(String userid);
	
	public void modify(MemberVO member);
	
	public void delete(MemberVO member);
	
	public String idcheck(String userid);
	
	
}
