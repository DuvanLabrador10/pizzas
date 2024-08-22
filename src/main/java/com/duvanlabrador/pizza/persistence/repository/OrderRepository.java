package com.duvanlabrador.pizza.persistence.repository;

import com.duvanlabrador.pizza.persistence.entity.OrderEntity;
import com.duvanlabrador.pizza.persistence.projections.OrderSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Query(value = """
            SELECT\s
                o.id_order AS idOrders,\s
                o.fe_date AS orderDate,\s
                c.name AS customerName,\s
                GROUP_CONCAT(p.name SEPARATOR ', ') AS pizzaNames,
                SUM(oi.quantity) AS quantity,\s
                SUM(p.price) AS orderTotal
            FROM tb_order o
            INNER JOIN tb_order_item oi ON o.id_order = oi.id_order
            INNER JOIN tb_customer c ON o.id_customer = c.id_customer
            INNER JOIN tb_pizza p ON oi.id_pizza = p.id_pizza
            WHERE o.id_order = ?1
            GROUP BY o.id_order, o.fe_date, c.name
            ORDER BY o.id_order;
            """, nativeQuery = true)
    OrderSummary findSummary(@Param("orderId") Long orderId);
}
