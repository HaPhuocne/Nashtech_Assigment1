package nashtech.ass.phuochg.coffeeshop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nashtech.ass.phuochg.coffeeshop.entities.Information;

public interface InfomationRepository extends JpaRepository<Information, Long> {
	@Query("SELECT i FROM Information i WHERE i.phoneNumber = :phoneNumber")
	public Optional<Information> findByPhoneNumber(String phoneNumber);
}
