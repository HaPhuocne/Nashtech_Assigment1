package nashtech.ass.phuochg.coffeeshop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import nashtech.ass.phuochg.coffeeshop.entities.Products;
import nashtech.ass.phuochg.coffeeshop.repositories.ProductRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository Prepo;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testCreateProduct() {

		Products product = new Products();
		product.setProductName("test");
		product.setPrice(1000);
		product.setImage("test");
		product.setUpdateDate("test");
		product.setCreateDate("test");
		product.setQuantity(10);

		Products saveProducts = Prepo.save(product);

		Products existProducts = entityManager.find(Products.class, saveProducts.getIdProduct());
		
		assertThat(existProducts.getProductName()).isEqualTo(product.getProductName());
	}

}
