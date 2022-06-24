package nashtech.ass.phuochg.coffeeshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nashtech.ass.phuochg.coffeeshop.entities.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {
	 List<Categories> findByNameCategory(String nameCategory);

}
