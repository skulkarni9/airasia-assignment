package com.airasia.assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airasia.assignment.domain.CheckinOrder;

public interface OrderRepository extends JpaRepository<CheckinOrder, String> {

}
