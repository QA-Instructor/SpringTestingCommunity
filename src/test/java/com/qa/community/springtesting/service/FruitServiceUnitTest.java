package com.qa.community.springtesting.service;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.community.springtesting.persistence.domain.Fruit;
import com.qa.community.springtesting.persistence.repository.FruitRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FruitServiceUnitTest {

    @Autowired
    private FruitService service;

    @MockBean
    private FruitRepository repo;

    @Test
    void testCreate() {

        // GIVEN
        Fruit toSave = new Fruit(null, "banana", "yellow", 1);
        Fruit saved = new Fruit(1L, "banana", "yellow", 1);

        // WHEN
        Mockito.when(this.repo.save(toSave)).thenReturn(saved);

        // THEN
        Assertions.assertThat(this.service.create(toSave)).isEqualTo(saved);

        // verify
        Mockito.verify(this.repo, Mockito.times(1)).save(toSave);
    }

    @Test
    void testReadById() {

        // GIVEN
        Long id = 1L;
        Fruit expected = new Fruit(id, "banana", "yellow", 1);

        // WHEN
        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(expected));

        // THEN
        Assertions.assertThat(this.service.readById(id)).isEqualTo(expected);

        // verify
        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
    }

    @Test
    void testReadAll() {

        // GIVEN
        Long id = 1L;
        Fruit testBanana = new Fruit(null, "banana", "yellow", 1);
        testBanana.setId(id);
        List<Fruit> fruits = List.of(testBanana);

        // WHEN
        Mockito.when(this.repo.findAll()).thenReturn(fruits);

        // THEN
        Assertions.assertThat(this.service.readAll()).isEqualTo(fruits);

        // verify
        Mockito.verify(this.repo, Mockito.times(1)).findAll();

    }

    @Test
    void testUpdate() {

        // GIVEN
        Long id = 1L;
        Fruit newValues = new Fruit(null, "banana", "yellow", 1);
        Fruit existing = new Fruit(id, "Wumpus", "red and orange", 99);
        Fruit updated = new Fruit(id, newValues.getName(), newValues.getColour(), newValues.getQuantity());

        // WHEN
        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(existing));
        Mockito.when(this.repo.save(updated)).thenReturn(updated);

        // THEN
        Assertions.assertThat(this.service.update(id, newValues)).isEqualTo(updated);

        // verify
        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
        Mockito.verify(this.repo, Mockito.times(1)).save(updated);

    }

    @Test
    void testDelete() {

        // GIVEN
        Long id = 1L;

        // WHEN
        Mockito.when(this.repo.existsById(id)).thenReturn(false);

        // THEN
        Assertions.assertThat(this.service.delete(id)).isTrue();

        // verify
        Mockito.verify(this.repo, Mockito.times(1)).existsById(id);

    }

}
