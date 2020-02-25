package co.grandcircus.CoffeeShopDB.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.CoffeeShopDB.Objects.Users;

@Repository
public class UsersDao {

	@Autowired
	private JdbcTemplate jdbc;

	public List<Users> findAll() {
		String sql = "SELECT * FROM users";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(Users.class));
	}
	
	public Users findById(Long id) {
		String sql = "SELECT * FROM users WHERE id = ?";
		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Users.class), id);
	}
	
	public void update(Users user) {
		String sql = "Update users SET first_name=?, last_name=?, email=?, password=? WHERE id = ?";
		jdbc.update(sql, user.getFirst_name(), user.getLast_name(), user.getEmail(), user.getPassword(), user.getId());
	}
	
	public void create(Users user) {
		String sql = "INSERT INTO users (first_name, last_name, email, phone_number, password) VALUES (?, ?, ?, ?, ?)";
		jdbc.update(sql, user.getFirst_name(), user.getLast_name(), user.getEmail(), user.getPhone_number(), user.getPassword());
	}
	
	public void delete(Long id) {
		String sql = "DELETE FROM users WHERE id = ?";
		jdbc.update(sql, id);
	}

}
 