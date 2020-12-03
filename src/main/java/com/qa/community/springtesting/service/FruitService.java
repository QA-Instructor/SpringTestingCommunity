package com.qa.community.springtesting.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.qa.community.springtesting.persistence.domain.Fruit;
import com.qa.community.springtesting.persistence.repository.FruitRepository;

@Service
public class FruitService {

    private FruitRepository repo;

    public FruitService(FruitRepository repo) {
        super();
        this.repo = repo;
    }

    public Fruit create(Fruit fruit) {
        return this.repo.save(fruit);
    }

    public Fruit readById(Long id) {
        Optional<Fruit> fruit = this.repo.findById(id);
        return fruit.get();
    }

    public List<Fruit> readAll() {
        return this.repo.findAll();
    }

    public Fruit update(Long id, Fruit newValues) {
        Fruit toUpdate = this.repo.findById(id).orElseThrow(EntityNotFoundException::new);
        toUpdate.setName(newValues.getName());
        toUpdate.setColour(newValues.getColour());
        toUpdate.setQuantity(newValues.getQuantity());
        return this.repo.save(toUpdate);
    }

    public boolean delete(Long id) {
        this.repo.deleteById(id);
        return !this.repo.existsById(id);
        // this one's tricky:
        // first, delete the Fruit by its id
        // then check if the Fruit still exists after we've deletedd it
        // if this.repo.existsById(id) returns false then it's been deleted properly
        // so we return the opposite - so !false (i.e. true) if it's successfully been deleted
    }

}
