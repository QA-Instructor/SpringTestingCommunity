package com.qa.community.springtesting.service;

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
    }

    @Test
    void testReadById() {
    }

    @Test
    void testReadAll() {
    }

    @Test
    void testUpdate() {
    }

    @Test
    void testDelete() {
    }

}
