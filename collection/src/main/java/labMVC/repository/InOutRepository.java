package labMVC.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import labMVC.domain.InOut;

@Repository
public interface InOutRepository extends CrudRepository <InOut, Integer>{
	InOut findOneById(int id);
	List<InOut> findOneByDate(Date date);
	List<InOut> findByName(String name);

}
