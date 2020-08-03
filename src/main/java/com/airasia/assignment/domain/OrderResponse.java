package com.airasia.assignment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderResponse implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String orderId;

	private String msg;

}
