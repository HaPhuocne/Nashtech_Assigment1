package nashtech.ass.phuochg.coffeeshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nashtech.ass.phuochg.coffeeshop.entities.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
