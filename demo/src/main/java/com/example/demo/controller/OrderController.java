/**
 *
 */
package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OrderService;

/**
 * @author virens
 *
 */

@RequestMapping("/order")
@RestController
public class OrderController {


	@Autowired
	private OrderService orderService;

	@GetMapping("/recommendation")
	public Map<String, String> getRecommendation(@RequestParam("productId") final String productId)
	{
		return orderService.getProductRecommendations(productId);
	}

}
