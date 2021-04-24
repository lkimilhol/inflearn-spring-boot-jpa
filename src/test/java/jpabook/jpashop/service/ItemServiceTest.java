package jpabook.jpashop.service;

import jpabook.jpashop.domain.Item;
import jpabook.jpashop.repositoy.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemService itemService;

    @Test
    @DisplayName("상품 등록")
    void createItem() {
        //given

        //when

        //then
    }
}