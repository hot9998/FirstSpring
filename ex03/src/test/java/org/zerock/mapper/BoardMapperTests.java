package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.web.SampleController;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // root-context.xml �����ϱ�
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	private static final Logger log = LoggerFactory.getLogger(SampleController.class);

/*	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board.toString()));
	}*/

	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("���� �ۼ��ϴ� ��");
		board.setContent("���� �ۼ��ϴ� ����");
		board.setWriter("newbie");

		mapper.insert(board);

		log.info(board.toString());
	}
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board.toString()));
	}
	

//	@Test
//	public void testInsertSelectKey() {
//		BoardVO board = new BoardVO();
//		board.setTitle("���� �ۼ��ϴ� �� select key");
//		board.setContent("���� �ۼ��ϴ� ���� select key");
//		board.setWriter("newbie");
//
//		mapper.insertSelectKey(board);
//
//		log.info(board.toString());
//	}
//
//	@Test
//	public void testRead() {
//		BoardVO board = mapper.read(13L);
//
//		log.info(board.toString());
//	}
//
//	@Test
//	public void testDelete() {
//
//		log.info("DELETE COUNT: " + mapper.delete(3L));
//	}
	/*@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		
		board.setBno(5L);
		board.setTitle("������ ����");
		board.setContent("������ ����");
		board.setWriter("user22");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: "+count);
	}*/
	
	
	

}