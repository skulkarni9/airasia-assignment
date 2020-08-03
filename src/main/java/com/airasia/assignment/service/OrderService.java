package com.airasia.assignment.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.airasia.assignment.domain.CheckinOrder;
import com.airasia.assignment.exception.ServiceException;
import com.airasia.assignment.repo.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepository;

	@Autowired
	public OrderService(OrderRepository newOrderRepository) {
		orderRepository = newOrderRepository;
	}

	@Transactional
	public void createOrder(CheckinOrder order) {

		List<CheckinOrder> orders = getAllOrders();
		Optional<CheckinOrder> existingOrder = orders.stream()
				.filter(o -> o.getCustomer().getEmail().equals(order.getCustomer().getEmail()))
				.filter(o -> o.getCheckinDate().equals(order.getCheckinDate())).findFirst();
		existingOrder.ifPresent(o -> {
			throw new ServiceException(HttpStatus.BAD_REQUEST, "Already order exists for same customer on given date");
		});
		String id = UUID.randomUUID().toString();
		order.setOrderId(id);
		orderRepository.save(order);
	}

	public List<CheckinOrder> getAllOrders() {
		return orderRepository.findAll();
	}

}
