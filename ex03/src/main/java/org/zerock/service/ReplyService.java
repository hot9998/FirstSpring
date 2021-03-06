package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	//추가
	//상세보기
	//수정
	//삭제
	//리스트
	public int register(ReplyVO vo);

	public ReplyVO get(Long rno);

	public int modify(ReplyVO vo);

	public int remove(Long rno);

	public List<ReplyVO> getList(Criteria cri, Long bno);
	// public ReplayPageDTO getListPage(Criteria cri,Long bno);
	
	//리스트 페이징
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
	
	public int getTotal(Long bno);
	
}
