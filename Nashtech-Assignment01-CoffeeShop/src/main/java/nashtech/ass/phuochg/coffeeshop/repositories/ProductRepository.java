package nashtech.ass.phuochg.coffeeshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nashtech.ass.phuochg.coffeeshop.entities.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

}
