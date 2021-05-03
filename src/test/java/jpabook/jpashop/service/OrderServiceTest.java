package jpabook.jpashop.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.exception.NotEnoughStockException;
import jpabook.jpashop.repositoy.OrderRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class OrderServiceTest {

	@Autowired
	EntityManager em;

	@Autowired
	OrderService orderService;

	@Autowired
	OrderRepository orderRepository;

	@Test
	@DisplayName("상품주문")
	void 상품주문() {
	    //given
		Member member = createMember();

		Book book = createBook("시골 JPA", 10000, 10);

		int orderCount = 2;
		//when
		Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

		//then
		Order getOrder = orderRepository.findOne(orderId);

		assertEquals(OrderStatus.ORDER, getOrder.getStatus());
		assertEquals(1, getOrder.getOrderItems().size());
		assertEquals(10000 * orderCount, getOrder.getTotalPrice());
		assertEquals(8, book.getStockQuantity());
	}

	@Test
	@DisplayName("상품주문 재고수량 초과")
	void method() {
	    //given
		Member member = createMember();
		Book book = createBook("시골 JPA", 10000, 10);

		int orderCount = 11;
	    //when
	    //then
		assertThrows(NotEnoughStockException.class, () -> orderService.order(member.getId(), book.getId(), orderCount));
	}

	@Test
	@DisplayName("주문취소")
	void 주문취소() {
		//given
		Member member = createMember();
		Book book = createBook("시골 JPA", 10000, 10);

		int orderCount = 2;
		Long orderId = orderService.order(member.getId(), book.getId(), orderCount);
		//when
		orderService.cancelOrder(orderId);
		//then
		Order getOrder = orderRepository.findOne(orderId);

		assertEquals(OrderStatus.CANCEL, getOrder.getStatus(), "주문 취소시 상태는 CANCEL");
		assertEquals(10, book.getStockQuantity(), "주문 수량이 돌아와야 한다.");

	}

	private Book createBook(String name, int price, int stockQuantity) {
		Book book = new Book();
		book.setName(name);
		book.setPrice(price);
		book.setStockQuantity(stockQuantity);
		em.persist(book);
		return book;
	}

	private Member createMember() {
		Member member = new Member();
		member.setName("회원1");
		member.setAddress(new Address("서울", "강가", "123-123"));
		em.persist(member);
		return member;
	}
}