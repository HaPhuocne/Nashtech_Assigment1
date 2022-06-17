package nashtech.ass.phuochg.coffeeshop;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import nashtech.ass.phuochg.coffeeshop.entities.Account;
import nashtech.ass.phuochg.coffeeshop.entities.Categories;
import nashtech.ass.phuochg.coffeeshop.entities.Information;
import nashtech.ass.phuochg.coffeeshop.entities.Products;
import nashtech.ass.phuochg.coffeeshop.entities.Roles;
import nashtech.ass.phuochg.coffeeshop.repositories.AccountRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.CategoriesRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.InfomationRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.ProductRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.RolesRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository Prepo;
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CategoriesRepository Catepo;

	@Autowired
	private InfomationRepository Infopo;
	
	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testCreateProduct() {
		
		Categories cate = new Categories();
		cate.setNameCategory("test2");
		
		Catepo.save(cate);
		
		Roles roles = new Roles();
		roles.setName("testadmin");
		rolesRepository.save(roles);
		
		
//		Account acc = new Account();
//		acc.setEmail("testadmin");
//		acc.setPassword("test123");
//		acc.setRoles(roles);
//		
//		accountRepository.save(acc);
//		
//		Information info = new Information();
//		info.setName("test");
//		info.setAddress("Testlun");
//		info.setPhoneNumber("12312312");
//		info.setAccount(acc);
//		Infopo.save(info);
			
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
