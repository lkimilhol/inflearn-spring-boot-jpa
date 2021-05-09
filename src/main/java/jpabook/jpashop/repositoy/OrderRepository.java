package jpabook.jpashop.repositoy;

import java.util.List;

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

	public List<Order> findAll(OrderSearch orderSearch) {
		// TODO QueryDsl로 해결 해야 한다.
		// return em.createQuery("select o from Order o join o.member m" +
		// 	"where o.status = :status" +
		// 	"and m.name like :name", Order.class)
		// 	.setParameter("status", orderSearch.getOrderStatus())
		// 	.setParameter("name", orderSearch.getMemberName())
		// 	.setMaxResults(100)
		// 	.getResultList()
		// 	;
		return null;
	}

}
