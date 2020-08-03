package com.airasia.assignment.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "checkin_order")
@ToString
public class CheckinOrder {

	@Id
	@Column(name = "id")
	private String orderId;

	@NotNull(message = "hotelId is missing")
	@Column(name = "hotel_id")
	private String hotelId;

	@NotNull(message = "hotelName is missing")
	@Column(name = "hotel_name")
	private String hotelName;

	@NotNull(message = "checkinDate is missing")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "checkin_date")
	private Date checkinDate;

	@NotNull(message = "checkoutDate is missing")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "checkout_date")
	private Date checkoutDate;

	@NotNull(message = "customer data is missing")
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;

	@NotNull(message = "roomId is missing")
	@Column(name = "room_id")
	private String roomId;

	@NotNull(message = "roomName is missing")
	@Column(name = "room_name")
	private String roomName;

	@NotNull(message = "noOfGuests is missing")
	@Column(name = "no_of_Guests")
	private int noOfGuests;

	@NotNull(message = "amount is missing")
	@Column(name = "amount")
	private Double amount;

}
