package org.zerock.mapper;

import org.zerock.domain.MemberVO;

public interface MemberMapper {
//	회원가입
	public void register(MemberVO member);
//	회원정보
	public MemberVO get(String id);
//	아이디 중복체크
	public String idcheck(String id);

}
