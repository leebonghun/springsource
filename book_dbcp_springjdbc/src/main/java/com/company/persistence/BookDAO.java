package com.company.persistence;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.company.domain.BookDTO;

@Repository // == @Component
public class BookDAO {

	@Autowired // 객체 주입
	private JdbcTemplate jdbcTemplate;

	// insert
	public boolean insert(BookDTO insertDto) {
		String sql = "insert into bookTBL values(?,?,?,?)";
		int result = jdbcTemplate.update(sql, insertDto.getCode(), insertDto.getTitle(), insertDto.getWriter(),
				insertDto.getPrice());

		return result > 0 ? true : false;

	}

	// delete
	public boolean delete(String code) {
		String sql = "delete from bookTBL where code =?";

		int result = jdbcTemplate.update(sql, code);

		return result > 0 ? true : false;

	}

	public boolean update(String code, int price) {
		String sql = "update bookTBL set price = ? where code =? ";
		int result = jdbcTemplate.update(sql, price, code);

		return result > 0 ? true : false;
	}
	// update

	public List<BookDTO> select() {

		String sql = "select* from bookTBL";

		return jdbcTemplate.query(sql, new BookRowMapper());
	}

	public List<BookDTO> search(String criteria, String keyword) {

		String sql = "select * from bookTBL where " + criteria + "=?";

		return jdbcTemplate.query(sql, new BookRowMapper(), keyword);
	}

}
