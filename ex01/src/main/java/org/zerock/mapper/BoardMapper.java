package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.MemberVO;

public interface BoardMapper {
	//글 목록
	//글쓰기
	//글쓰기(시퀀스)
	//상세보기
	//삭제
	//수정
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);

	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
		
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
	public int getTotalCount(Criteria cri);
	
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
	
	//회원 이름 수정 시 업데이트
	public void updateName(MemberVO member);
	
	public void deleteById(String id);	

}

