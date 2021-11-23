package com.company.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;


import com.company.domain.BoardDTO;


@Repository
public class BoardDAO {

	@Autowired //객체 주입 완료
	private JdbcTemplate jdbcTemplate;

	public boolean insert(BoardDTO insertDto) {

		String sql = "insert into spring_board(bno,title,content,writer) values(seq_board.nextval,?,?,?)";
		// update(sql,Object...args) : 인자의 개수가 정해져있지 않은 경우
		int result = jdbcTemplate.update(sql, insertDto.getTitle(), insertDto.getContent(), insertDto.getWriter());

		return result > 0 ? true : false; //if(result>0) insertFlag = true; << 이구문이 간단하게 변함
	}

	public BoardDTO getRow(int bno) {

		String sql = "select * from spring_board where bno =?";
		return jdbcTemplate.queryForObject(sql, new BoardRowMapper(),bno);

	}

	public List<BoardDTO> getRows() {

		String sql = "select * from spring_board";
		return jdbcTemplate.query(sql, new BoardRowMapper());

	}

	// 게시물 업데이트
	public boolean updateBoard(BoardDTO updateDto) {

		String sql = "update spring_board set title=?,content=?,updatedate=sysdate where bno =?";
		int result = jdbcTemplate.update(sql, updateDto.getTitle(), updateDto.getContent(), updateDto.getBno());

		return result > 0 ? true : false;
	}

	public boolean deleteBoard(int bno) {

		String sql = "delete from spring_board where bno = ?";
		int result = jdbcTemplate.update(sql, bno);

		return result > 0 ? true : false;
	}
}
