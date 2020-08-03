package com.airasia.assignment.service;

import static org.mockito.Mockito.times;

import java.util.Collections;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.airasia.assignment.domain.CheckinOrder;
import com.airasia.assignment.domain.Customer;
import com.airasia.assignment.exception.ServiceException;
import com.airasia.assignment.repo.OrderRepository;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

	@InjectMocks
	private OrderService orderService;

	@Mock
	private OrderRepository orderRepository;

	@Test
	public void testShouldVerify_create_throwsException_when_sameCustomer_createOrder_for_sameDay() {
		CheckinOrder order = new CheckinOrder();
		Customer customer = new Customer();
		customer.setEmail("abc@xyz.com");
		order.setCustomer(customer);
		Date d = new Date();
		order.setCheckinDate(d);
		Mockito.when(orderRepository.findAll()).thenReturn(Collections.singletonList(order));
		Assertions.assertThrows(ServiceException.class, () -> {
			orderService.createOrder(order);
		});
	}

	@Test
	public void testShouldVerify_createOrder() {
		CheckinOrder order = new CheckinOrder();
		Customer customer = new Customer();
		customer.setEmail("abc@xyz.com");
		order.setCustomer(customer);
		Date d = new Date();
		order.setCheckinDate(d);

		orderService.createOrder(order);
		Mockito.verify(orderRepository, times(1)).save(order);
		Assertions.assertNotNull(order.getOrderId());
	}

}
