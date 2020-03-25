package org.zerock.mapper;

import java.util.HashMap;
import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardMapper {
	//글 목록
	//글쓰기
	//글쓰기(시퀀스)
	//상세보기
	//삭제
	//수정
	public List<BoardVO> getList(HashMap<String, Object> hm);
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
	public int count(HashMap<String, Object> hm);
	

}

