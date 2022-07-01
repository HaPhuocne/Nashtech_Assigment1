package nashtech.ass.phuochg.coffeeshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nashtech.ass.phuochg.coffeeshop.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	 List<Category> findByNameCategory(String nameCategory);

}
