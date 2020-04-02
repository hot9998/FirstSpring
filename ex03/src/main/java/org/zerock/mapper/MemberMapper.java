package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.AuthVO;
import org.zerock.domain.MemberVO;

public interface MemberMapper {
	public MemberVO read(String userid);
	public void insert(MemberVO mvo);
	public void authInsert(@Param("userid") String userid,
			@Param("auth") String auth);
	
//	ȸ������
	public void register(MemberVO member);
//	ȸ�� ����
	public void registerAuth(AuthVO member);
//	���̵� �ߺ�üũ
	public String idcheck(String id);
//	ȸ�� ����
	public void modify(MemberVO member);
//	ȸ�� ���� ����
	public void modifyAuth(AuthVO member);
//	ȸ�� Ż��
	public void delete(MemberVO member);
//	ȸ�� Ż�� ����
	public void deleteAuth(String userid);
	
	
}