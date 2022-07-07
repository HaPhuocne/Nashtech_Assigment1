package nashtech.ass.phuochg.coffeeshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nashtech.ass.phuochg.coffeeshop.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


@Query("SELECT p FROM Product p where id_Category = :idCategory")
	 List<Product> getProductbyIdcategory(@Param("idCategory")Long id);
	  List<Product> findByProductName(String productName);
	  Product findByIdProduct(Long id);
}
