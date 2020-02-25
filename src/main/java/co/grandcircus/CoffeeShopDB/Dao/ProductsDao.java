package co.grandcircus.CoffeeShopDB.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.CoffeeShopDB.Objects.Products;

@Repository
public class ProductsDao {

	@Autowired
	private JdbcTemplate jdbc;

	public List<Products> findAll() {
		String sql = "SELECT * FROM products";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(Products.class));
	}

	public Products findById(Long id) {
		String sql = "SELECT * FROM products WHERE id = ?";
		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Products.class), id);
	}

	public void update(Products product) {
		String sql = "Update products SET name=?, description=?, price=?, quantity=? WHERE id = ?";
		jdbc.update(sql, product.getName(), product.getDescription(), product.getPrice(), product.getQuantity(),
				product.getId());
	}

	public void create(Products product) {
		String sql = "INSERT INTO products (name, description, price, quantity) VALUES (?, ?, ?, ?)";
		jdbc.update(sql, product.getName(), product.getDescription(), product.getPrice(), product.getQuantity());
	}

	public void delete(Long id) {
		String sql = "DELETE FROM products WHERE id = ?";
		jdbc.update(sql, id);
	}

}
