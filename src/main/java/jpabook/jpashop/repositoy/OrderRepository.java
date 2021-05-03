package jpabook.jpashop.repositoy;

import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

//    public List<Order> findAll(OrderSearch orderSearch) {
//
//    }
}
