package org.zerock.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;


@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Setter(onMethod_= @Autowired)
	private BoardMapper mapper;
	@Setter(onMethod_= @Autowired)
	private ReplyMapper replyMapper;

	@Override
	public boolean register(BoardVO board) {
		// TODO Auto-generated method stub
		log.info("register....."+board);
		
		mapper.insertSelectKey(board);
		return true;
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		mapper.update(board);
		return true;
	}

	@Transactional
	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		replyMapper.deleteByBno(bno);
		mapper.delete(bno);
		return true;
	}


	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}
	

	

}
