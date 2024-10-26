package com.agriweigh.agriweigh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agriweigh.agriweigh.models.Pig;
import com.agriweigh.agriweigh.repositories.IPigRepository;

@Service
public class PigService {

    @Autowired
    private IPigRepository pigRepository;

    public List<Pig> findAll() {
        return pigRepository.findAll();
    }

    public Optional<Pig> findById(Long id) {
        return pigRepository.findById(id);
    }

    public Pig save(Pig pig) {
        pig.setEstimatedWeight(pig.calculateWeight());
        return pigRepository.save(pig);
    }

    public void delete(Long id) {
        pigRepository.deleteById(id);
    }
}
