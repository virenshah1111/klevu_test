/**
 *
 */
package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Order;

/**
 * @author virens
 *
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

	@Query("from Order as o where o.customerIp in (select distinct customerIp from Order sub where sub.productId like ?1)"
			+ " and o.productId not like ?1 group by o.customerIp, o.productId")
	public List<Order> getProductRecommendations(final String productId);

}
