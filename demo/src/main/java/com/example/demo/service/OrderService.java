/**
 *
 */
package com.example.demo.service;

import java.util.Map;

/**
 * @author virens
 *
 */
public interface OrderService {

	Map<String, String> getProductRecommendations(final String productId);

}
