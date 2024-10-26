package com.agriweigh.agriweigh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agriweigh.agriweigh.models.Cow;
import com.agriweigh.agriweigh.repositories.ICowRepository;

@Service
public class CowService {

    @Autowired
    private ICowRepository cowRepository;

    public List<Cow> findAll() {
        return cowRepository.findAll();
    }

    public Optional<Cow> findById(Long id) {
        return cowRepository.findById(id);
    }

    public Cow save(Cow cow) {
        cow.setEstimatedWeight(cow.calculateWeight());
        return cowRepository.save(cow);
    }

    public void delete(Long id) {
        cowRepository.deleteById(id);
    }
}
