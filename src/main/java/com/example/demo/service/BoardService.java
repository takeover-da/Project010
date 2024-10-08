package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

public interface BoardService {

	// 게시물 등록 메소드
	int register(BoardDTO dto);
	
	// 게시물 목록조회 메소드
	// 페이지 번호를 받아서 특정 페이지의 정보를 반환
	Page<BoardDTO> getList(int pageNumber);
	
	// 게시물 상세조회 메소드
	BoardDTO read(int no);
	
	// 게시물 수정 메소드
	void modify(BoardDTO dto);
	
	// 게시물 삭제 메소드(단건삭제(int no))
	void remove(int no);
	
	// default 키워드: 인터페이스에서 일반 함수를 추가하는 기능
	// DTO를 엔티티로 변환하는 메소드
	default Board dtoToEntity(BoardDTO dto) {
		
		Member member = Member.builder()
							  .id(dto.getWriter())
							  .build();
		
		Board entity = Board.builder()
							.no(dto.getNo())
							.title(dto.getTitle())
							.content(dto.getContent())
							.writer(member)
							.build();
		return entity;
		
	}
	
	// entity -> Dto 변환 메소드
	default BoardDTO entityToDto(Board entity) {
		
		BoardDTO dto = BoardDTO.builder()
							   .no(entity.getNo())
							   .title(entity.getTitle())
							   .content(entity.getContent())
							   .writer(entity.getWriter().getId())
							   .regDate(entity.getRegDate())
							   .modDate(entity.getModDate())
							   .build();
		
		return dto;
		
	}

	/* List<BoardDTO> getList(); */

}
