package es.beonit.dcastalm.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import es.beonit.dcastalm.entity.Price;

public interface IPriceDao extends CrudRepository<Price, Long> {

	@Query("SELECT p FROM Price p WHERE p.brand.id = ?1 AND p.productId = ?2 AND ?3 BETWEEN p.startDate AND p.endDate ORDER BY p.priority DESC")
	public List<Price> findByBrandIdAndProductIdAndActiveInRequestDate(Long brandId, Long productId, Date requestDate);
}
