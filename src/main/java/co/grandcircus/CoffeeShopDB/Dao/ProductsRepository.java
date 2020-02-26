package co.grandcircus.CoffeeShopDB.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.CoffeeShopDB.Objects.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {

}
