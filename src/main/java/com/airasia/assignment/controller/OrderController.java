package com.airasia.assignment.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airasia.assignment.domain.CheckinOrder;
import com.airasia.assignment.domain.OrderResponse;
import com.airasia.assignment.exception.ServiceException;
import com.airasia.assignment.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

	private OrderService orderService;

	@Autowired
	public OrderController(OrderService newOrderService) {
		orderService = newOrderService;
	}

	@PostMapping
	public OrderResponse createOrder(@RequestBody @Valid CheckinOrder order) {
		log.info("Create order request recieved {}", order);
		Date checkin = order.getCheckinDate();
		Date checkout = order.getCheckoutDate();
		if (checkin.after(checkout)) {
			throw new ServiceException(HttpStatus.BAD_REQUEST, "checkin date cannot be after chekout date");
		}
		orderService.createOrder(order);
		return new OrderResponse(order.getOrderId(), "Order place successfully");
	}

	@GetMapping
	public List<CheckinOrder> getAllOrders() {
		return orderService.getAllOrders();
	}

}
