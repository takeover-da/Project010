package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.CommentDTO;

@SpringBootTest
public class CommentServiceTest {

	@Autowired
	CommentService service;
	
	@Test
	public void 댓글추가() {
		
		CommentDTO dto = CommentDTO.builder()
									.content("하이5")
									.boardNo(6)
									.writer("Q")
									.build();
		service.register(dto);
	}
	
}
