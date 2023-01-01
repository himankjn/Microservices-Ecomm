package com.himankjn.orderservice.dao;

import com.himankjn.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order,Long> {

}
