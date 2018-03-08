package labMVC.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import labMVC.domain.Case;

@Repository
public interface CaseRepository extends CrudRepository <Case, Integer> {
	Case findById(int id);
	List<Case> findByDebtorName(String debtorName);
	List<Case> findByCreditorName(String creditorName);
	List<Case> findByAmount(Double amount);
	List<Case> findByPaid(String paid);
	List<Case> findByDate(Date date);

//	@Modifying(clearAutomatically=true)
//	@Transactional
//	@Query(value = "DELETE from case where name like :case%", nativeQuery = true)
//	void deleteByCaseName(@Param("Case") String Case);
	
	//Update later to findAllById int caseId
	//where id=:case
	@Query(value = "SELECT * from casee", nativeQuery = true)
	List<Case> findAllByCaseName(@Param("casee") String casee);
	
	@Query(value = "SELECT * from casee where id like :caseId%", nativeQuery = true)
	Case findOneByCaseId(@Param("caseId") int caseId);
}