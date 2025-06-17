package com.firstproject.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstproject.course.entities.OrderItem;
import com.firstproject.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
