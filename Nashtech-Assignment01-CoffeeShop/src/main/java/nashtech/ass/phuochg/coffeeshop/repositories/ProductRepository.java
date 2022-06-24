package nashtech.ass.phuochg.coffeeshop.repositories;

import java.util.List;
 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nashtech.ass.phuochg.coffeeshop.entities.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {


@Query("SELECT p FROM Products p where id_Category = :idCategory")
	public List<Products> getProductbyIdcategory(@Param("idCategory")Long id);
	public  List<Products> findByProductName(String productName);

}
