package com.geekbrains.spring.web;

import com.geekbrains.spring.web.core.dto.Cart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CartControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void uuidTest() {
        String uuid = restTemplate.getForObject("/api/v1/cart/generate", String.class);
        assertThat(uuid).isNotNull();
        assertThat(uuid).isNotEmpty();

        Cart cart = restTemplate.getForObject("/api/v1/cart/uuid", Cart.class);
        assertThat(uuid).isNotNull();
        assertThat(uuid).isEqualTo(new Cart());
    }
}
