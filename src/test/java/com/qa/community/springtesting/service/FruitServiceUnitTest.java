package com.qa.community.springtesting.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.community.springtesting.persistence.repository.FruitRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FruitServiceUnitTest {

    @Autowired
    private FruitService service;

    @MockBean
    private FruitRepository repo;

    @Test
    void testCreate() {
        Assertions.fail("create testing incomplete");
    }

    @Test
    void testReadById() {
        Assertions.fail("readById testing incomplete");
    }

    @Test
    void testReadAll() {
        Assertions.fail("readAll testing incomplete");
    }

    @Test
    void testUpdate() {
        Assertions.fail("update testing incomplete");
    }

    @Test
    void testDelete() {
        Assertions.fail("delete testing incomplete");
    }

}
