package org.zerock.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.web.SampleController;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	private static final Logger log = LoggerFactory.getLogger(SampleController.class);
	
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		log.info("register....."+board);
		
		mapper.insertSelectKey(board);
		
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

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		mapper.delete(bno);
		return true;
	}

	@Override
	public List<BoardVO> getList(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return mapper.getList(hm);
	}
	
	public int count(HashMap<String, Object> hm) {
		return mapper.count(hm);
	}
	

}
