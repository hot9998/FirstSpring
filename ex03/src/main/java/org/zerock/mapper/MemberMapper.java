package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.AuthVO;
import org.zerock.domain.MemberVO;

public interface MemberMapper {
	public MemberVO read(String userid);
	public void insert(MemberVO mvo);
	public void authInsert(@Param("userid") String userid,
			@Param("auth") String auth);
	
//	회원가입
	public void register(MemberVO member);
//	회원 권한
	public void registerAuth(AuthVO member);
//	아이디 중복체크
	public String idcheck(String id);
//	회원 수정
	public void modify(MemberVO member);
//	회원 권한 수정
	public void modifyAuth(AuthVO member);
//	회원 탈퇴
	public void delete(MemberVO member);
//	회원 탈퇴 권한
	public void deleteAuth(String userid);
	
	
}
