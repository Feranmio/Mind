package labMVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import labMVC.domain.PaymentPlan;

@Repository
public interface PlanRepository extends CrudRepository <PaymentPlan, Integer>{
	PaymentPlan findOneById(int id);
	List<PaymentPlan> findByTimePeriod(String timePeriod);
	PaymentPlan findByDebtorName(String debtorName);
	List<PaymentPlan> findByAmount(Double amount);
	
	@Query(value = "SELECT * from payment_plan", nativeQuery = true)
	List<PaymentPlan> findAllByCaseName(@Param("plan") String plan);
}
