package org.zerock.mapper;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.web.SampleController;

import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // root-context.xml 설정하기
public class ReplyMapperTests {
	private Long[] bnoArr = { 121L, 122L, 123L, 124L, 125L };

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	private static final Logger log = LoggerFactory.getLogger(SampleController.class);

	@Test
	public void testMapper() {

		log.info(mapper.toString());
	}

	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO();

			vo.setBno(bnoArr[i % 5]);
			vo.setReply("댓글 테스트 " + i);
			vo.setReplyer("replyer" + i);
			
			mapper.insert(vo);

		});

	}

	@Test
	public void testList() {
		log.info(mapper.getList(new Criteria(), 123L).toString());
		
		
	}

}
