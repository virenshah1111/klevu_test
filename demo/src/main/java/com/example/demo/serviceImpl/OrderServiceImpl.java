/**
 *
 */
package com.example.demo.serviceImpl;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;

/**
 * @author virens
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Map<String, String> getProductRecommendations(final String productId) {

		if (!StringUtils.hasText(productId)) {
			return Collections.emptyMap();
		}

		final List<Order> ls = orderRepository.getProductRecommendations(productId);

		if (CollectionUtils.isEmpty(ls)) {
			return Collections.emptyMap();
		}

		final Map<String, String> productsMap = ls.stream()
				.collect(Collectors.toMap(Order::getProductId, Order::getProductName, (order1, order2) -> {
					return order1;
				}));

		final Map<String, Long> productsCount = ls.stream()
				.collect(Collectors.groupingBy(Order::getProductId, Collectors.counting()));

		// Order by frequency (descending) and return the top 5 products (id and name)
		return productsCount.entrySet().stream().sorted((Map.Entry.<String, Long>comparingByValue().reversed()))
				.limit(5).collect(Collectors.toMap(Map.Entry::getKey, entry -> productsMap.get(entry.getKey()),
						(e1, e2) -> e1, LinkedHashMap::new));
	}

}
