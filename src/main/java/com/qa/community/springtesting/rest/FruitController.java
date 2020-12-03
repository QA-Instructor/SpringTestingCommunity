package com.qa.community.springtesting.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.community.springtesting.persistence.domain.Fruit;
import com.qa.community.springtesting.service.FruitService;

@RestController
public class FruitController {

    public FruitService service;

    public FruitController(FruitService service) {
        super();
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Fruit> create(@RequestBody Fruit fruit) {
        return new ResponseEntity<>(this.service.create(fruit), HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Fruit> read(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.readById(id));
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<Fruit>> readAll() {
        return ResponseEntity.ok(this.service.readAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruit> updateDog(@PathVariable Long id, @RequestBody Fruit newValues) {
        return new ResponseEntity<>(this.service.update(id, newValues), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (this.service.delete(id)) {
            return ResponseEntity.ok(this.service.delete(id));
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
